package com.xiacong.common.validator.constrants;

import com.xiacong.common.validator.validator.CheckNumberIntervalValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

/**
 * 校验结束时间大于等于开始时间
 *
 * @author xc
 * @Date 2023-07-12
 */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE,
        ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckNumberIntervalValidation.class)
@Documented
@Repeatable(CheckNumberInterval.List.class)
public @interface CheckNumberInterval {

    String high() default "high";

    String low() default "low";

    String message() default "{high}必须大于{low}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
            ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        CheckNumberInterval[] value();
    }
}