package com.xiacong.flow.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * @author xiacong
 * @Classname NormalFlowNode
 * @Version 1.0.0
 * @Date 2024/4/12 10:26
 * @Created by xiacong
 */
@Setter
@Getter
public abstract class NormalFlowNode implements FlowNode {

    /**
     * 流程id
     */
    public String floweId;

    /**
     * 节点id
     */
    public String nodeId;

    /**
     * 节点类型（START-开始节点，END-结束节点，NORMAL-正常节点，EXCEPTION-异常处理节点，CONDITION-条件节点，NORMAL_FLOW-流程节点，ASYNC_FLOW-异步流程节点）
     */
    public String nodeType;

    /**
     * 条件字符串
     */
    public String conditionStr;

    /**
     * 节点流程id
     * 流程节点使用
     */
    public String nodeFlowId;

    /**
     * 节点bean名称
     */
    public String nodeBeanName;

    /**
     * 节点bean类引用
     */
    public String nodeBeanReference;

    /**
     * 下一个节点id
     */
    public List<String> nextNodeIds;

    /**
     * 节点参数
     */
    public Map<String,String> nodeParams;
}
