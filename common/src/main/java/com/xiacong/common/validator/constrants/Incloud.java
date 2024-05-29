package com.xiacong.common.validator.constrants;


import com.xiacong.common.validator.validator.IncloudValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

/**
 * 校验入参必须是注解数组元素中的一个
 * 允许为空
 * @author xiacong
 * @Classname Incloud
 * @Version 1.0.0
 * @Date 2023/7/5 10:07
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IncloudValidator.class)
public @interface Incloud {
    /**
     * 默认校验失败信息
     *
     * @return
     */
    String message() default "校验失败";

    /**
     * 校验属性名称
     *
     * @return
     */
    String name() default "";

    /**
     * 校验入参的数组
     *
     * @return
     */
    String[] values() default {};

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface List {
        Incloud[] value();
    }
}
