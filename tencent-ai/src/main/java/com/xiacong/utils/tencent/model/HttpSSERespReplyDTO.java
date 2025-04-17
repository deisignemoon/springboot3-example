package com.xiacong.utils.tencent.model;

import lombok.Data;

import java.util.List;

/**
 *
 *
 * @author xiacong
 * @Classname HttpSSERespDTO
 * @Version 1.0.0
 * @Date 2025/4/17 13:42
 * @Created by xiacong
 */
@Data
public class HttpSSERespReplyDTO {

    /**
     * 请求 ID，用于标识一个请求（作消息串联，建议每个请求使用不同的 request_id）
     */
    private String request_id;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 消息唯一 ID
     */
    private String record_id;

    /**
     * 关联的消息唯一 ID
     */
    private String related_record_id;

    /**
     * 会话 ID，用于标识一个会话（外部系统提供，建议不同的用户端会话传入不同的 session_id，否则同一个应用下的不同用户的消息记录会串掉）
     */
    private String session_id;

    /**
     *
     * 消息是否由自己发出
     * （如果是自己发出，显示在聊天框右侧，否则在左侧）
     */
    private Boolean is_from_self;

    /**
     * 该消息记录是否能评价
     */
    private Boolean can_rating;

    /**
     * 消息时间戳（秒级）
     */
    private Long timestamp;

    /**
     * 消息是否已输出完
     * （流式模式下，消息会多次返回，每次返回均覆盖之前的答案）
     * （当 is_final == true 时，停止生成按钮隐藏，并且显示点赞点踩按钮）
     */
    private Boolean is_final;

    /**
     * 是否命中敏感内容
     * 注意：消息上行后会先进行敏感内容检测，并返回一条【reply】事件，告知敏感内容检测结果， 敏感问题检测通过后才会进入正常业务逻辑处理
     */
    private Boolean is_evil;

    /**
     * 是否为模型生成内容
     */
    private Boolean is_llm_generated;

    /**
     * 回复方式：
     * 1: 大模型回复
     * 2: 未知问题回复
     * 3: 拒答问题回复
     * 4: 敏感回复
     * 5: 已采纳问答对优先回复
     * 6: 欢迎语回复
     * 7: 并发数超限回复
     * 8: 全局干预知识
     * 9: 任务流回复
     * 10: 任务流答案
     * 11: 搜索引擎回复
     * 12: 知识润色后回复
     * 13: 图片理解回复
     * 14: 实时文档回复
     * 15: 澄清确认回复
     * 16: 工作流回复
     * 17: 工作流运行结束
     * 18: 智能体回复
     */
    private Integer reply_method;

    /**
     * 命中的知识
     */
    private List<Knowledge> knowledge;

    /**
     * 选项卡，任务流程专有
     * 注：该字段可能为空，为空时该字段不返回
     */
    private List<String> option_cards;

    /**
     * 用户自定义业务参数，用于透传问答中业务参数
     * 注：该字段可能为空，为空时该字段不返回
     */
    private List<String> custom_params;

    /**
     * 引用信息
     */
    private List<QuoteInfo> quote_infos;
}
