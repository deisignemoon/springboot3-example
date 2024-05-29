package com.xiacong.common.validator.validator;

import com.xiacong.common.validator.constrants.ListNotEmpty;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * list数据非空校验
 *
 * @Create xiacong
 */
public class ListNotEmptyValidator implements ConstraintValidator<ListNotEmpty, List<?>> {
    private String message;
    private String name;

    @Override
    public void initialize(ListNotEmpty constraintAnnotation) {
        this.message = constraintAnnotation.message();
        this.name = constraintAnnotation.name();
    }

    @Override
    public boolean isValid(List<?> list, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        if (list == null || list.isEmpty()) {
            // 列表为空，校验失败
            context.buildConstraintViolationWithTemplate(this.name + this.message).addConstraintViolation();
            return false;
        }
        for (Object element : list) {
            if (element == null) {
                // 列表中有元素为空，校验失败
                context.buildConstraintViolationWithTemplate(this.name + "内部元素" + this.message).addConstraintViolation();
                return false;
            }
        }
        // 校验通过
        return true;
    }
}