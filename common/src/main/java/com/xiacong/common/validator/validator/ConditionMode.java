package com.xiacong.common.validator.validator;

/**
 * 条件判断模式
 */
public enum ConditionMode{
    /**
     * 为空
     */
    NULL,
    /**
     * 不为空
     */
    NOT_NULL,
    /**
     * 范围内
     */
    IN,
    /**
     * 不在范围内
     */
    NOT_IN,;
}