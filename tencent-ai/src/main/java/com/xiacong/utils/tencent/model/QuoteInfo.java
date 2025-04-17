package com.xiacong.utils.tencent.model;

import lombok.Data;

/**
 *
 *
 * @author xiacong
 * @Classname QuoteInfo
 * @Version 1.0.0
 * @Date 2025/4/17 13:48
 * @Created by xiacong
 */
@Data
public class QuoteInfo {

    /**
     * 引用的角标索引， 角标 icon 请接入方自行设计实现
     */
    private Integer index;

    /**
     * 在回复内容 content 中的位置(中文字符，英文字符，其他符号都算一个字符)
     */
    private Integer position;
}
