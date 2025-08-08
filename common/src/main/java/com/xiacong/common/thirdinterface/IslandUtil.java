package com.xiacong.common.thirdinterface;

import cn.hutool.core.lang.Assert;
import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpStatus;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.server.Http2;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author xiacong
 * @Classname HuaNiaoUtil
 * @Version 1.0.0
 * @Date 2024/7/25 9:39
 * @Created by xiacong
 */
@Slf4j
public class IslandUtil {

    private static String url = "https://fsy.shengsi.gov.cn/island-cloud-server/travel/wallet/info/flowPage?homestayId=&order=&orderField=&page=1&limit=10&consumeType=&startDate=&endDate=&flowType=&merchantId=&orderCode=";
    private static String url2 = "&payType=&merchantType=3&_t=1744013846320";
    private static String token= "Bearer ce0f4bf2-3406-4b3b-9233-1651d9cfb35c";

    private static String orderUrl1="https://fsy.shengsi.gov.cn/island-cloud-server/travel/isshiporder/pageDetailAndOrder?homestayId=&order=&orderField=&page=1&limit=10&sailTime=&orderId=";
    private static String orderUrl2="&createTime=&_t=1744024029843";

    private static String orderUrl3="https://fsy.shengsi.gov.cn/island-cloud-server/travel/api/ship/order/detail/";



    /**
     * 交易明细
     * @param orderCode
     * @return
     */
    public String invoke(String orderCode){
        HttpRequest request = HttpUtil.createGet(url+orderCode+url2).header("Authorization",token).charset("UTF-8");
        HttpResponse response = request.execute();
        String body = response.body();
        int status = response.getStatus();
        JSONObject resJson = JSONObject.parseObject(body);
        Integer code = resJson.getInteger("Code");
        String message = resJson.getString("Message");
        return resJson.getString("data");
    }

    /**
     * 订单详情
     * @param orderCode
     * @return
     */
    public String invoke2(String orderCode){
        HttpRequest request = HttpUtil.createGet(orderUrl1+orderCode+orderUrl2).header("Authorization",token).charset("UTF-8");
        HttpResponse response = request.execute();
        String body = response.body();
        int status = response.getStatus();
        JSONObject resJson = JSONObject.parseObject(body);
        Integer code = resJson.getInteger("Code");
        String message = resJson.getString("Message");
        return resJson.getString("data");
    }


    public String invoke3(String orderCode){
        HttpRequest request = HttpUtil.createPost(orderUrl3+orderCode).body("{}").charset("UTF-8");
        HttpResponse response = request.execute();
        String body = response.body();
        int status = response.getStatus();
        JSONObject resJson = JSONObject.parseObject(body);
        Integer code = resJson.getInteger("Code");
        String message = resJson.getString("Message");
        return resJson.getString("data");
    }
}
