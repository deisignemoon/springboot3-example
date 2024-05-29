package com.xiacong.flow.model.domain;

import com.xiacong.flow.common.content.ApplicationContent;

/**
 * @author xiacong
 * @Classname FlowNode
 * @Version 1.0.0
 * @Date 2024/4/12 10:20
 * @Created by xiacong
 */
public interface FlowNode {

    ApplicationContent invoke(ApplicationContent appContent);
}
