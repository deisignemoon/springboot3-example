package com.xiacong.utils.tencent.model;

import lombok.Data;

/**
 *
 *
 * @author xiacong
 * @Classname Knowledge
 * @Version 1.0.0
 * @Date 2025/4/17 13:45
 * @Created by xiacong
 */
@Data
public class Knowledge {

    /**
     * 命中的知识 ID
     */
    private String id;

    /**
     * 命中的知识类型：
     * 1: 问答
     * 2: 文档片段
     */
    private Integer type;

    /**
     *
     * 片段 ID , 可通过 DescribeSegments 接口查看片段详情
     */
    private String seg_id;
}
