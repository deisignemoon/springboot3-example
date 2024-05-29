package com.xiacong.common.validator.validator;

import com.xiacong.common.validator.constrants.CheckTimeInterval;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Date;

/**
 *  校验结束时间大于等于开始时间
 */
public class CheckTimeIntervalValidation implements ConstraintValidator<CheckTimeInterval, Object> {
 
        private String[] beginTime;
        private String[] endTime;
 
        @Override
        public void initialize(CheckTimeInterval constraintAnnotation) {
            this.beginTime = constraintAnnotation.beginTime();
            this.endTime = constraintAnnotation.endTime();
        }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        BeanWrapper beanWrapper = new BeanWrapperImpl(value);
        boolean valid = true;
        for (int i = 0; i < beginTime.length; i++) {
            String s = beginTime[i];
            Object propertyValue = beanWrapper.getPropertyValue(s);
            Object propertyValue1 = beanWrapper.getPropertyValue(endTime[i]);
            if (ObjectUtils.isNotEmpty(propertyValue) && ObjectUtils.isNotEmpty(propertyValue1)) {
                Date beginTimeVal = (Date) propertyValue;
                Date endTimeVal = (Date) propertyValue1;
                int result = endTimeVal.compareTo(beginTimeVal);
                if (result < 0) {
                    valid = false;
                    break;
                }
            }
        }
        return valid;
    }

}