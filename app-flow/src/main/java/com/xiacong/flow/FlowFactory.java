package com.xiacong.flow;

import com.alibaba.fastjson2.JSONObject;
import com.xiacong.common.util.ApplicationContextUtil;
import com.xiacong.flow.model.domain.Flow;
import com.xiacong.flow.model.domain.NormalFlowNode;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @author xiacong
 * @Classname FlowFactory
 * @Version 1.0.0
 * @Date 2024/4/15 9:25
 * @Created by xiacong
 */
@Component
public class FlowFactory {
    @Resource
    private FlowEngine flowEngine;

    public Flow initFlow(String flowConifgJson) {
        JSONObject flowJson = JSONObject.parseObject(flowConifgJson);
        Flow flow = (Flow) ApplicationContextUtil.registerBean(Flow.class, flowJson.getString("flowId"));
        init(flowConifgJson, flow);
        flowEngine.getFlowMap().put(flow.getFlowId(), flow);
        return flow;
    }

    public NormalFlowNode initFlowNode(String nodeConfigJson) {
        JSONObject json = JSONObject.parseObject(nodeConfigJson);
        String reference = json.getString("nodeBeanReference");
        String nodeId = json.getString("nodeId");
        NormalFlowNode node = null;
        try {
            Class<?> clazz = Class.forName(reference);
            node = (NormalFlowNode) ApplicationContextUtil.registerBean(clazz, nodeId);
            init(nodeConfigJson, node);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        flowEngine.getFlowNodeMap().put(nodeId, node);
        return node;
    }

    public void init(String json, Object obj) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        Class<?> clazz = obj.getClass();
        Field[] fields = FieldUtils.getAllFields(clazz);
        for (Field field : fields) {
            String name = field.getName();
            if (jsonObject.containsKey(name)) {
                field.setAccessible(true);
                try {
                    field.set(obj, jsonObject.get(name));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
