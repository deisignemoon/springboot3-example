package com.xiacong.common.validator.validator;

import com.xiacong.common.validator.constrants.CheckNumberInterval;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * 校验结束时间大于等于开始时间
 */
public class CheckNumberIntervalValidation implements ConstraintValidator<CheckNumberInterval, Object> {

    private String high;
    private String low;

    @Override
    public void initialize(CheckNumberInterval constraintAnnotation) {
        this.high = constraintAnnotation.high();
        this.low = constraintAnnotation.low();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        BeanWrapper beanWrapper = new BeanWrapperImpl(value);
        Object propertyValue = beanWrapper.getPropertyValue(this.high);
        Object propertyValue1 = beanWrapper.getPropertyValue(this.low);
        if (ObjectUtils.isNotEmpty(propertyValue) && ObjectUtils.isNotEmpty(propertyValue1)) {
            Integer end = (Integer) propertyValue;
            Integer begin = (Integer) propertyValue1;
            int result = end.compareTo(begin);
            if (result < 0) {
                return false;
            }
        }
        return true;
    }

}