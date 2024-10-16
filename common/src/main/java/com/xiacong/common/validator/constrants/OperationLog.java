package com.xiacong.common.validator.constrants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 操作日志
 *
 * @author xiacong
 * @Classname OperationLog
 * @Version 1.0.0
 * @Date 2023/7/17 9:06
 * @Created by xiacong
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OperationLog {

    /**
     * 操作模块
     * @return
     */
    String module() default "";


    /**
     * 操作描述
     * @return
     */
    String descrip() default "";

}
