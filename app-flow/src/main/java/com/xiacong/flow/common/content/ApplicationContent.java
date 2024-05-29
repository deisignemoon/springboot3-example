package com.xiacong.flow.common.content;

import com.xiacong.common.content.AppContent;
import com.xiacong.flow.model.domain.NormalFlowNode;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xiacong
 * @Classname AppContent
 * @Version 1.0.0
 * @Date 2024/4/12 10:15
 * @Created by xiacong
 */
@Data
@Slf4j
public class ApplicationContent extends AppContent {


    /**
     * 流程id
     */
    private String flowId;

    /**
     * 当前节点id
     */
    private NormalFlowNode currentNode;

}
