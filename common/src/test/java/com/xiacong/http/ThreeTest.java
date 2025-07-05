package com.xiacong.http;

import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;

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
public class ThreeTest {
    private static final String HMACSHA256 = "HmacSHA256";
    private static final String key = "6963265685";
    private static final String secret = "2885sg8ik2dfwgvah";
    @Test
    public void test(){
        String now = DateUtil.now();
        String sign = sign(key, secret, now);
        HashMap<String, String> headers = new HashMap<>();
        headers.put("sign", sign);
        headers.put("timestamp", now);
        headers.put("key", key);
        System.out.println(JSONObject.toJSONString(headers));
        HttpRequest request = HttpUtil.createGet("https://apizyld.zswl0580.cn/api/zhoushanweidao/page?area=DING_HAI&type=DISHES&page=1$limit=3")
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


    /**
     * 三方验签
     * @param key
     * @param threeSecret
     * @param timestamp
     * @param sign
     * @return
     */
    private boolean verifyThree(String key, String threeSecret, String timestamp, String sign) {
        log.info("key:{},sign:{},timestamp:{}", key, sign, timestamp);
        String body = key + timestamp;
        try {
            Mac hmac = Mac.getInstance(HMACSHA256);
            SecretKeySpec secretKeySpec = new SecretKeySpec(threeSecret.getBytes(StandardCharsets.UTF_8), HMACSHA256);
            hmac.init(secretKeySpec);
            byte[] bytes = hmac.doFinal(body.getBytes(StandardCharsets.UTF_8));
            String ver = Base64.getEncoder().encodeToString(bytes);
            if (StringUtils.equals(ver, sign)) {
                return true;
            }
        } catch (Exception e) {
            log.error("verifyThree error {}", e.getMessage());
            throw new RuntimeException(e);
        }
        return false;
    }

    private String sign(String key, String threeSecret, String timestamp) {
        log.info("key:{},threeSecret:{} timestamp:{}", key, threeSecret,timestamp);
        String body = key + timestamp;
        try {
            Mac hmac = Mac.getInstance(HMACSHA256);
            SecretKeySpec secretKeySpec = new SecretKeySpec(threeSecret.getBytes(StandardCharsets.UTF_8), HMACSHA256);
            hmac.init(secretKeySpec);
            byte[] bytes = hmac.doFinal(body.getBytes(StandardCharsets.UTF_8));
            String ver = Base64.getEncoder().encodeToString(bytes);
            return ver;
        } catch (Exception e) {
            log.error("verifyThree error {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }


    @Test
    public void test2(){
        String sailticket_id = "668132";
        String sign = DigestUtils.md5Hex(sailticket_id + "ld7UMYLnwyNvGwEq");
        HttpRequest request = HttpUtil.createGet("https://ysstest.dazhoushan.net/island-cloud-server/scenic/scenic-order/checkTicket?sailticket_id="+sailticket_id+"&checkNum=1&sign="+sign)
                .charset("UTF-8");
        HttpResponse response = request.execute();
        String body = response.body();
        System.out.println(body);
        int status = response.getStatus();
        JSONObject resJson = JSONObject.parseObject(body);
        String data = resJson.getString("data");
        System.out.println(data);
    }
}
