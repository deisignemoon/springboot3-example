package com.xiacong.common.util;

import com.xiacong.common.constant.CommonConstant;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 跟踪号处理工具类
 *
 * @author xiacong
 * @Classname TraceIdUtil
 * @Version 1.0.0
 * @Date 2023/9/5 9:02
 * @Created by xiacong
 */
public class TraceIdUtil {

    public static void setTraceId() {
        String traceId = MDC.get(CommonConstant.TRACE_ID);
        if (StringUtils.isEmpty(traceId)) {
            MDC.put(CommonConstant.TRACE_ID, createTraceId(null));
        }
    }

    public static void setTraceId(String traceId) {
        MDC.put(CommonConstant.TRACE_ID, traceId);
    }

    public static String getTraceId() {
        return MDC.get(CommonConstant.TRACE_ID);
    }

    public static String createTraceId(String prefix) {
        String res = LocalDateTime.now().format(DateTimeFormatter.ofPattern(CommonConstant.DATE_TIME_FORMATE4)) + SequenceUtil.getUuId();
        if (StringUtils.isNotBlank(prefix)) {
            res = res + CommonConstant.AEPARATOR1 + prefix;
        }
        return res;
    }

    public static void removeTraceId() {
        MDC.remove(CommonConstant.TRACE_ID);
    }
}
