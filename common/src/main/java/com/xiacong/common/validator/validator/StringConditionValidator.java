package com.xiacong.common.validator.validator;

import cn.hutool.core.bean.BeanUtil;
import com.xiacong.common.validator.constrants.StringCondition;
import jakarta.validation.ConstraintValidator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 参数关联校验处理器
 * @author xiacong
 * @date 2023/7/6
 */
@Slf4j
public class StringConditionValidator
        implements ConstraintValidator<StringCondition, Object> {

    /**
     * 条件属性名字
     */
    private String conditionName;
    /**
     * 条件属性值
     */
    private String conditionValue;
    /**
     * 结果属性名字
     */
    private String resultName;

    private ConditionMode resultMode;
    /**
     * 结果属性值
     */
    private Set<String> resultValueSet;

    @Override
    public void initialize(StringCondition conditionResult) {
        this.conditionName = conditionResult.conditionName();
        this.resultName = conditionResult.resultName();
        this.resultMode = conditionResult.resultMode();
        this.conditionValue = conditionResult.conditionValue();
        this.resultValueSet = new HashSet<>(Arrays.asList(conditionResult.resultValue()));
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {
        boolean flag=false;
        try {
            // 入参为空
            if (StringUtils.isBlank(this.conditionName) || StringUtils.isBlank(this.resultName) || StringUtils.isBlank(this.conditionValue) || resultMode == null) {
                return false;
            }

            final String conditionFieldValue = BeanUtil.getProperty(obj, this.conditionName);
            // 条件不成立，则此约束不进入
            if (!StringUtils.equals(this.conditionValue, conditionFieldValue)) {
                return true;
            }
            // 条件进入，则会进入此校验
            final String resultFieldValue = BeanUtil.getProperty(obj, this.resultName);
            switch (resultMode){
                case IN:
                    if(CollectionUtils.isEmpty(this.resultValueSet)){
                        return false;
                    }
                    flag=CollectionUtils.contains(this.resultValueSet.iterator(),resultFieldValue);
                    break;
                case NOT_IN:
                    if(CollectionUtils.isEmpty(this.resultValueSet)){
                        return false;
                    }
                    flag = !CollectionUtils.contains(this.resultValueSet.iterator(),resultFieldValue);
                    break;
                case NOT_NULL:
                    flag = StringUtils.isNotEmpty(resultFieldValue);
                    break;
                case NULL:
                    flag = StringUtils.isEmpty(resultFieldValue);
                    break;
                default:
                    flag = false;
            }
        } catch (Exception e) {
            log.error("校验发生异常");
        }
        if (!flag){
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(this.resultName+"校验失败").addConstraintViolation();
        }
        return false;
    }

}



