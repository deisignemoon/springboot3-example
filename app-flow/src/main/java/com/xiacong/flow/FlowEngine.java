package com.xiacong.flow;

import cn.hutool.core.lang.Assert;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.xiacong.common.exception.ServiceException;
import com.xiacong.common.exception.SystemCodeInfo;
import com.xiacong.flow.common.content.ApplicationContent;
import com.xiacong.flow.model.domain.Flow;
import com.xiacong.flow.model.domain.NormalFlowNode;
import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/**
 * 流程引擎
 *
 * @author xiacong
 * @Classname FlowEngine
 * @Version 1.0.0
 * @Date 2024/4/12 10:49
 * @Created by xiacong
 */
@Component
@Slf4j
@Getter
@Setter
public class FlowEngine {
    //@Resource
    private Map<String, NormalFlowNode> flowNodeMap = new ConcurrentHashMap<>();

    //@Resource
    private Map<String, Flow> flowMap = new ConcurrentHashMap<>();

    @Resource(name = "controlAsync")
    private Executor executor;

    public ApplicationContent startFlow(ApplicationContent content) {
        String flowId = content.getFlowId();
        Flow flow = flowMap.get(flowId);
        Assert.notNull(flow, flowId + "流程不存在");
        log.info("开始流程：{}，id：{}", flow.getFlowName(), flow.getFlowId());
        String flowStatus = flow.getFlowStatus();
        log.warn("本流程状态：{}", flowStatus);
        String startNodeId = flow.getStartNodeId();
        NormalFlowNode startNode = (NormalFlowNode) flowNodeMap.get(startNodeId);
        Assert.notNull(startNode, flowId + "流程的" + startNodeId + "流程节点不存在");
        content.setCurrentNode(startNode);
        try {
            invokeNode(content);
        } catch (Exception e) {
            log.error("流程执行异常", e);
        }
        log.info("结束流程：{}，id：{}", flow.getFlowName(), flowId);
        return content;
    }

    private void excepionFlowProcess(ApplicationContent content) {
        String flowId = content.getFlowId();
        Flow flow = flowMap.get(flowId);
        Assert.notNull(flow, flowId + "流程不存在");
        String exceptionNodeId = flow.getExceptionNodeId();
        if (StringUtils.isBlank(exceptionNodeId)) {
            return;
        }
        NormalFlowNode exceptionNode = (NormalFlowNode) flowNodeMap.get(exceptionNodeId);
        Assert.notNull(exceptionNode, flowId + "流程的" + exceptionNodeId + "流程节点不存在");
        content.setCurrentNode(exceptionNode);
        try {
            invokeNode(content);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void invokeNode(ApplicationContent content) throws Exception {
        Assert.notNull(content, () -> new ServiceException(SystemCodeInfo.CONTENT_NULL_ERROR.getCode(), SystemCodeInfo.CONTENT_NULL_ERROR.getCnMsg()));
        while (content.getCurrentNode() != null) {
            NormalFlowNode node = content.getCurrentNode();
            String nodeType = node.getNodeType();
            log.debug("流程节点{}类型为：{}", node.getNodeId(), nodeType);
            log.info("开始执行流程节点：{}", node.getNodeBeanName());
            try {
                switch (nodeType) {
                    case "START", "END", "EXCEPTION", "NORMAL" -> handleNormalNode(content);
                    case "CONDITION" -> handleConditionNode(content);
                    case "NORMAL_FLOW" -> handleNormalFlowNode(content);
                    case "ASYNC_FLOW" -> handleAsyncFlowNode(content);
                    default ->
                            throw new ServiceException(SystemCodeInfo.FLOW_NODE_TYPE_ERROR.getCode(), SystemCodeInfo.FLOW_NODE_TYPE_ERROR.getCnMsg());
                }
            } catch (ServiceException e) {
                log.error("处理流程节点时发生异常", e);
                content.setFlowException(e);
                excepionFlowProcess(content);
                throw e;
            } catch (Exception e) {
                log.error("处理流程节点时发生未知异常", e);
                content.setFlowException(e);
                excepionFlowProcess(content);
                throw e;
            }
            log.info("结束执行流程节点：{}", node.getNodeBeanName());
        }
    }

    private void handleNormalNode(ApplicationContent content) {
        NormalFlowNode node = content.getCurrentNode();
        node.invoke(content);
        List<String> nextNodeIds = node.getNextNodeIds();
        if (nextNodeIds != null && !nextNodeIds.isEmpty()) {
            String nextNodeId = nextNodeIds.get(0);
            NormalFlowNode nextNode = (NormalFlowNode) flowNodeMap.get(nextNodeId);
            Assert.notNull(nextNode, () -> new ServiceException(SystemCodeInfo.FLOW_NODE_RUN_ERROR.getCode(), SystemCodeInfo.FLOW_NODE_RUN_ERROR.getCnMsg() + "无法找到下一个节点: " + nextNodeId));
            content.setCurrentNode(nextNode);
        }
    }

    private void handleConditionNode(ApplicationContent content) {
        log.info("条件节点");
        NormalFlowNode node = content.getCurrentNode();
        List<String> nextNodeIds = node.getNextNodeIds();
        for (String nextNodeId : nextNodeIds) {
            NormalFlowNode nextNode = (NormalFlowNode) flowNodeMap.get(nextNodeId);
            Assert.notNull(nextNode, () -> new ServiceException(SystemCodeInfo.FLOW_NODE_RUN_ERROR.getCode(), SystemCodeInfo.FLOW_NODE_RUN_ERROR.getCnMsg() + "无法找到下一个节点: " + nextNodeId));
            String conditionStr = nextNode.getConditionStr();
            if (StringUtils.isBlank(conditionStr) || processCondition(content, nextNode)) {
                content.setCurrentNode(nextNode);
                break;
            }
        }
    }

    private void handleNormalFlowNode(ApplicationContent content) {
        String flowId = content.getFlowId();
        NormalFlowNode node = content.getCurrentNode();
        content.setFlowId(node.getNodeFlowId());
        startFlow(content);
        content.setFlowId(flowId);
        List<String> nextNodeIds = node.getNextNodeIds();
        if (nextNodeIds != null && !nextNodeIds.isEmpty()) {
            String nextNodeId = nextNodeIds.get(0);
            NormalFlowNode nextNode = (NormalFlowNode) flowNodeMap.get(nextNodeId);
            Assert.notNull(nextNode, () -> new ServiceException(SystemCodeInfo.FLOW_NODE_RUN_ERROR.getCode(), SystemCodeInfo.FLOW_NODE_RUN_ERROR.getCnMsg() + "无法找到下一个节点: " + nextNodeId));
            content.setCurrentNode(nextNode);
        }
    }

    private void handleAsyncFlowNode(ApplicationContent content) {
        //克隆上下文
        ApplicationContent syncContent = (ApplicationContent) content.deepClone();
        content.setFlowId(syncContent.getCurrentNode().getNodeFlowId());
        executor.execute(() -> startFlow(syncContent));
    }

    /**
     * 条件判断
     *
     * @param node
     * @return
     */
    private boolean processCondition(ApplicationContent content, NormalFlowNode node) {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        Map<String, Object> temp = content.getTemp();
        temp.forEach(context::put);
        Object execute = null;
        try {
            execute = runner.execute(node.getConditionStr(), context, null, true, false);
        } catch (Exception e) {
            log.error("条件表达式执行异常", e);
            throw new ServiceException(SystemCodeInfo.Condition_EXPRESS_PRECESS_ERROR.getCode(), node.getNodeId() + SystemCodeInfo.Condition_EXPRESS_PRECESS_ERROR.getCnMsg());
        }
        return (boolean) execute;
    }
}
