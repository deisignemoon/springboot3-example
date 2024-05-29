package com.xiacong.flow.nodes;

import com.xiacong.flow.FlowEngine;
import com.xiacong.flow.model.domain.NormalFlowNode;
import com.xiacong.flow.common.content.ApplicationContent;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xiacong
 * @Classname StartFlowNode
 * @Version 1.0.0
 * @Date 2024/4/15 11:04
 * @Created by xiacong
 */
@Slf4j
public class StartFlowNode extends NormalFlowNode {
    @Resource
    private FlowEngine flowEngine;

    @Override
    public ApplicationContent invoke(ApplicationContent appContent) {
        log.info("开始流程{}", appContent.getFlowId());
        log.info(String.valueOf(flowEngine == null));
        return appContent;
    }
}
