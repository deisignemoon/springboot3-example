package com.xiacong.utils.tencent.model;

import lombok.Data;

import java.util.Map;

/**
 *
 *
 * @author xiacong
 * @Classname HttpSSEReqDTO
 * @Version 1.0.0
 * @Date 2025/4/17 13:13
 * @Created by xiacong
 */
@Data
public class HttpSSEReqDTO {

    /**
     * 请求 ID，用于标识一个请求（作消息串联，建议每个请求使用不同的 request_id）。
     * 为了便于问题排查，建议必填。
     */
    private String request_id;

    /**
     * 消息内容，如果发送图片，在此传递 markdown 格式的图片链接，例如![](图片连接)，其中图片链接需要可公有读。
     */
    private String content;

    /**
     * 会话 ID，用于标识一个会话（外部系统提供，建议不同的用户端会话传入不同的 session_id，否则同一个应用下的不同用户的消息记录会串掉）
     * 参数长度：2-64个字符
     * 校验规则： ^[a-zA-Z0-9_-]{2,64}$  ，一般可以用 uuid 来生成该值
     *             uuid 示例：1b9c0b03-dc83-47ac-8394-b366e3ea67ef
     */
    private String session_id;

    /**
     * 应用密钥
     */
    private String bot_app_key;

    /**
     * 访客 ID（外部输入，建议唯一，标识当前接入会话的用户）
     */
    private String visitor_biz_id;

    /**
     * 流式回复频率控制：控制应用回包频率。该值表示应用每积攒多少字符向调用方回包一次，值越小回包越频繁（体验上越流畅，但流量开销也越大）。当不传值或者为 0 时以系统配置为准。
     * 默认值：5
     * 建议最大值：100
     * 注意：该设置项也不会加快大模型输出的时间，只是改变了向调用方回包的频率。因此如果设置很大，则会出现很长时间没有回包的现象。
     */
    private Integer streaming_throttle;

    /**
     * 角色指令（提示词）, 为空时使用应用配置默认设定，填写时取当前值。
     */
    private String system_role;

    /**
     *
     * 控制回复事件和思考事件中的 content 是否是增量输出的内容，默认 false
     */
    private Boolean incremental;

    /**
     * 工作流场景：
     * 自定义参数可用于传递参数给工作流开始节点的API参数字段，通过该API参数字段可以被工作流识别并使用，具体参考开始节点使用文档。
     *
     * 检索知识库范围设置场景：
     * 自定义参数可用于设置知识库检索范围，如需传入多个参数值，使用英文竖线分隔(|)，例如： "user1|user2"。
     */
    private Map<String,String> custom_variables;
}
