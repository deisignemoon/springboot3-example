package com.xiacong.common.exception;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * 用户提示生成器。
 *
 * @author songguanxun
 * @since 2023-8-24
 */
@Slf4j
public class UserTipGenerator {

    public static String getUserMessage(InvalidFormatException rootCause) {
        // 目标类型
        Class<?> targetType = rootCause.getTargetType();
        // 目标类型提示信息
        String targetTypeNotification = "";
        if (targetType == BigInteger.class || targetType == Integer.class || targetType == Long.class
                || targetType == Short.class || targetType == Byte.class) {
            targetTypeNotification = "参数类型应为：整数；";
        } else if (targetType == BigDecimal.class || targetType == Double.class || targetType == Float.class) {
            targetTypeNotification = "参数类型应为：数值；";
        } else if (targetType == String.class) {
            targetTypeNotification = "参数类型应为：字符串；";
        }
        Object value = rootCause.getValue();

        return String.format("参数格式错误！%s当前输入参数：[%s]", targetTypeNotification, value);
    }

    public static String getUserMessage2(InvalidFormatException e) {
        String erroMessage = "";
        List<JsonMappingException.Reference> path = e.getPath();
        JsonMappingException.Reference reference;
        if (!CollectionUtils.isEmpty(path) && (reference = path.get(0)) != null) {
            erroMessage = getDataBindErrorTips(reference.getFrom().getClass(), reference.getFieldName());
            if (erroMessage == null) {
                //erroMessage = "参数名：" + reference.getFieldName() + " 输入不合法，需要的是 " + e.getTargetType().getName() + " 类型，" + "提交的值是：" + e.getValue().toString();
                erroMessage = "";
            }
        } else {
            erroMessage = "";
        }
        return erroMessage + "格式错误，请输入正确数据";
    }


    //获取字段所在实体类中所对应的自定义提示信息
    private static String getDataBindErrorTips(Class<?> targetCalss, String fieldName) {
        if (targetCalss == null || StringUtils.isEmpty(fieldName)) {
            return null;
        }
        while (targetCalss != Object.class) {
            Field field;
            try {
                field = targetCalss.getDeclaredField(fieldName);
                DataBindErrorTips dataBindErrorTips = field.getDeclaredAnnotation(DataBindErrorTips.class);
                return dataBindErrorTips == null ? null : dataBindErrorTips.value();
            } catch (NoSuchFieldException e) {
                targetCalss = targetCalss.getSuperclass();
            }
        }
        return null;
    }

}

