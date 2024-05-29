package com.xiacong.common.validator.validator;

import com.xiacong.common.validator.constrants.Incloud;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author xiacong
 * @Classname IncloudValidator
 * @Version 1.0.0
 * @Date 2023/7/5 10:08
 */
public class IncloudValidator implements ConstraintValidator<Incloud, String> {

    private Incloud incloud;

    @Override
    public void initialize(Incloud incloud) {
        this.incloud = incloud;
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(s)) {
            return true;
        }
        String[] values = incloud.values();
        boolean res = Arrays.asList(values).contains(s);
        if (!res) {
            String name = incloud.name();
            String message = incloud.message();
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(name + message + ",取值应在" + Arrays.toString(values) + "之中").addConstraintViolation();
        }
        return res;
    }
}
