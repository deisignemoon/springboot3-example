

package com.xiacong.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统内置code
 *
 * @author yue
 * @date 2023/5/31 14:12
 */

@Getter
@AllArgsConstructor
public enum SystemCodeInfo {

    SYSTEM_ERROR("A019999", "系统异常", "system_error"),
    PARAM_MISS("A010001", "参数缺少异常", "param_miss"),
    DATABASE_ERROR("A010002", "数据库异常", "database_error"),
    PARAM_TYPE_ERROR("A010003", "参数格式错误", "param_type_error"),
    PARAM_BIND_ERROR("A010004", "参数校验错误", "param_bind_error"),
    MSG_NOT_READABLE("A010005", "消息无法读取异常处理", "msg_not_readable"),
    METHOD_NOT_SUPPORTED("A010006", "不支持当前请求方法", "method_not_supported"),
    MEDIA_TYPE_NOT_SUPPORTED("A010007", "不支持当前媒体类型", "media_type_not_supported"),
    FLOW_NODE_TYPE_ERROR("A010008", "流程节点类型异常", "flow_node_type_error"),
    FLOW_NODE_RUN_ERROR("A010009", "流程节点运行异常", "flow_node_run_error"),
    CONTENT_NULL_ERROR("A010010", "上下文为空异常", "content_null_error"),
    Condition_EXPRESS_PRECESS_ERROR("A010011", "条件判断发生异常", "condition_express_precess_error"),
    ;
    /**
     * code编码
     */
    private String code;
    /**
     * 中文信息描述
     */
    private String cnMsg;
    /**
     * 英文信息描述
     */
    private String enMsg;


}
