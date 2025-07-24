package com.xiacong.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 *
 *
 * @author xiacong
 * @Classname ThreeTest
 * @Version 1.0.0
 * @Date 2025/5/14 11:09
 * @Created by xiacong
 */
@Slf4j
public class FbsystemTest {
    private static final String HMACSHA256 = "HmacSHA256";
    private static final String URL = "https://ysstest.dazhoushan.net";
    private static final String LOCAL_URL = "http://127.0.0.1:8080";
    private static final String TICKET = "/fbsystem-admin/api/ship/order/ticket";
    private static final String DETAIL = "/fbsystem-admin/api/ship/order/detail";


    public void invoke(JSONObject params, String method) {
        log.info("请求体{}",JSONObject.toJSONString(params));
        String now = DateUtil.now();
        String sign = sign("123456789", "HVnkiIKJM52258HJ", now, paramSort(params));
        HashMap<String, String> headers = new HashMap<>();
        headers.put("X-Signature", sign);
        headers.put("X-Timestamp", now);
        headers.put("X-merchant", "123456789");
        System.out.println(JSONObject.toJSONString(headers));
        HttpRequest request = HttpUtil.createPost(LOCAL_URL + method).body(params.toJSONString())
                .addHeaders(headers)
                .charset("UTF-8");
        HttpResponse response = request.execute();
        String body = response.body();
        System.out.println(body);
        int status = response.getStatus();
        JSONObject resJson = JSONObject.parseObject(body);
        String data = resJson.getString("data");
        System.out.println(data);
    }

    public String sign(String merchantNo, String secretKey, String timestamp, String body) {
        String data = merchantNo + timestamp + body;
        try {
            Mac sha256Hmac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            sha256Hmac.init(secretKeySpec);
            byte[] hmacBytes = sha256Hmac.doFinal(data.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hmacBytes);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            log.error("Error validating signature：{}", e.getMessage());
            return null;
        }
    }

    private String paramSort(Map<String, Object> params) {
        //将params的参数按照字典序排序，key,value使用=连接，参数间使用&连接
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>(params.keySet());
        Collections.sort(list);
        for (String key : list) {
            Object value = params.get(key);
            if (null != value) {
                if (value instanceof String) {
                    value = ((String) value).trim();
                } else {
                    value = JSONObject.toJSONString(value);
                }
                sb.append(key).append("=").append(value).append("&");
            }
        }
        return sb.toString();
    }

    @Test
    public void test2() {
        JSONObject object = new JSONObject();
        object.put("startPortNo", "001");
        object.put("endPortNo", "002");
        object.put("boatDate", "2025-07-15");
        invoke(object, TICKET);
    }

    @Test
    public void test3() {
        JSONObject object = new JSONObject();
        object.put("orderNo", "202507151640401945040808101113856");
        invoke(object, DETAIL);
    }
}
