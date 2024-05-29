package com.xiacong.common.validator.constrants;

import com.xiacong.common.validator.validator.ConditionMode;
import com.xiacong.common.validator.validator.StringConditionValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

/**
 * 类中两个字段的联合约束：条件结果约束
 * 1. 当condition字段的值满足约束的时候，才会继续比较result的值的约束
 * 抛出异常在BindingResult.allErrors中
 * @author xiacong
 * @date 2022-07-06
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StringConditionValidator.class)
@Documented
public @interface StringCondition {

    String message() default "校验失败";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * 条件属性的名字
     */
    String conditionName();

    /**
     * 条件属性的值
     */
    String conditionValue();

    /**
     * 结果属性的名字
     */
    String resultName();

    /**
     * 结构属性模式
     *
     * @return
     */
    ConditionMode resultMode() default ConditionMode.NOT_NULL;

    /**
     * 结果属性的值
     */
    String[] resultValue();


    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        StringCondition[] value();
    }

}
