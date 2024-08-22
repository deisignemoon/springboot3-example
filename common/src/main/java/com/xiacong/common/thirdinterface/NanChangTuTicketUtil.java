package com.xiacong.common.thirdinterface;

import com.alibaba.fastjson2.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 *
 * @author xiacong
 * @Classname NanChangTuTicketUtil
 * @Version 1.0.0
 * @Date 2024/7/25 9:29
 * @Created by xiacong
 */
public class NanChangTuTicketUtil {

    private static String HOST;

    private static String UID;
    private static String PASSWORD;

    /**
     * 门票列表
     */
    private static String QUERY_TICKET="queryticket";


    private String invoke(String url, String method, JSONObject params){
        LocalDateTime now = LocalDateTime.now();
        params.put("timestamp",now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
        return null;
    }
}
