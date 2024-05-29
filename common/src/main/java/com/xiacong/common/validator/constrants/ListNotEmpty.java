package com.xiacong.common.validator.constrants;

import com.xiacong.common.validator.validator.ListNotEmptyValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xiacong
 * @Classname ListNotNull
 * @Version 1.0.0
 * @Date 2023/7/6 16:02
 * @Created by xiacong
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ListNotEmptyValidator.class)
public @interface ListNotEmpty {
    String message() default "列表不能为空";

    String name() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
