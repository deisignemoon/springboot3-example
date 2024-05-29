package com.xiacong.flow.nodes;

import com.alibaba.fastjson2.JSONObject;
import com.xiacong.flow.model.domain.NormalFlowNode;
import com.xiacong.flow.common.content.ApplicationContent;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xiacong
 * @Classname StartFlowNode
 * @Version 1.0.0
 * @Date 2024/4/15 11:04
 * @Created by xiacong
 */
@Slf4j
public class EndFlowNode extends NormalFlowNode {

    @Override
    public ApplicationContent invoke(ApplicationContent appContent) {
        log.info("结束流程{}", appContent.getFlowId());
        appContent.setCurrentNode(null);
        appContent.setResponse(JSONObject.toJSONString(appContent));
        return appContent;
    }
}
