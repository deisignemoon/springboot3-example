package com.xiacong.flow.nodes;

import com.xiacong.flow.model.domain.NormalFlowNode;
import com.xiacong.flow.common.content.ApplicationContent;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xiacong
 * @Classname ConditionFlowNode
 * @Version 1.0.0
 * @Date 2024/4/15 11:16
 * @Created by xiacong
 */
@Slf4j
public class ConditionFlowNode extends NormalFlowNode {
    @Override
    public ApplicationContent invoke(ApplicationContent appContent) {
        return appContent;
    }
}
