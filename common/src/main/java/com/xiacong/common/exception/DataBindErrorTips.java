package com.xiacong.common.exception;

import java.lang.annotation.*;

/**
 * 数据绑定异常提示语
 */
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface DataBindErrorTips {
	String value();
}
