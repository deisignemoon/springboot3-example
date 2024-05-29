package com.xiacong.flow.model.domain;

import lombok.Data;

/**
 * @author xiacong
 * @Classname FlowConfig
 * @Version 1.0.0
 * @Date 2024/4/12 10:30
 * @Created by xiacong
 */
@Data
public class Flow {

    /**
     * 流程id
     */
    public String flowId;

    /**
     * 流程名称
     */
    public String flowName;

    /**
     * 流程状态(INIT-草稿，RUN-运行中，FAIL-失效)
     */
    public String flowStatus;

    /**
     * 流程开始节点id
     */
    public String startNodeId;

    /**
     * 流程异常处理节点id
     */
    public String exceptionNodeId;

    /**
     * 是否支持被引用 NO-不支持，REF-支持
     */
    public String reference;

    /**
     * 版本号
     */
    public String version;


}
