package com.xiacong.common.thirdinterface;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.xiacong.common.util.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

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

    private static String url = "https://fsy.shengsi.gov.cn/island-cloud-server/travel/wallet/info/flowPage?homestayId=&order=&orderField=&page=1&limit=50&consumeType=&startDate=&endDate=&flowType=&merchantId=&orderCode=";
    private static String url2 = "&payType=&merchantType=3&_t=1744013846320";
    private static String token = "Bearer 647bf084-30d6-433c-ace0-8b5de4fe78a2";

    private static String orderUrl1 = "https://fsy.shengsi.gov.cn/island-cloud-server/travel/isshiporder/pageDetailAndOrder?homestayId=&order=&orderField=&page=1&limit=10&sailTime=&orderId=";
    private static String orderUrl2 = "&createTime=&_t=1744024029843";

    private static String orderUrl3 = "https://fsy.shengsi.gov.cn/island-cloud-server/travel/api/ship/order/detail/";
    private static String orderQuery = "https://fsy.shengsi.gov.cn/island-cloud-server/order/is-order/queryOrderByOrderCodes";
    private static String refundInfoQuery = "https://fsy.shengsi.gov.cn/island-cloud-server/order/isrefundinfo/";
    private static String merchantList = "https://fsy.shengsi.gov.cn/island-cloud-server/scenic/merchant/info/page?page=1&limit=500&status=1";
    private static String hotelList = "https://fsy.shengsi.gov.cn/island-cloud-server/hotel/homestay/page?page=1&limit=500&status=1";
    private static String recordPage = "https://fsy.shengsi.gov.cn/island-cloud-server/order/merchant/flow/record/list";
    private static String HOUSE_BASE_PAGE = "https://fsy.shengsi.gov.cn/island-cloud-server/hotel/house/base/page?homestayId=";
    private static String HOUSE_BASE_DETAIL = "https://fsy.shengsi.gov.cn/island-cloud-server/hotel/house/base/";
    private static String GET_ORDER = "https://fsy.shengsi.gov.cn/island-cloud-server/order/is-order/queryOrderCodeAll/";


    /**
     * 交易明细
     * @param orderCode
     * @return
     */
    public String invoke(String orderCode) {
        HttpRequest request = HttpUtil.createGet(url + orderCode + url2).header("Authorization", token).charset("UTF-8");
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
    public String invoke2(String orderCode) {
        HttpRequest request = HttpUtil.createGet(orderUrl1 + orderCode + orderUrl2).header("Authorization", token).charset("UTF-8");
        HttpResponse response = request.execute();
        String body = response.body();
        int status = response.getStatus();
        JSONObject resJson = JSONObject.parseObject(body);
        Integer code = resJson.getInteger("Code");
        String message = resJson.getString("Message");
        return resJson.getString("data");
    }


    public String invoke3(String orderCode) {
        HttpRequest request = HttpUtil.createPost(orderUrl3 + orderCode).body("{}").charset("UTF-8");
        HttpResponse response = request.execute();
        String body = response.body();
        int status = response.getStatus();
        JSONObject resJson = JSONObject.parseObject(body);
        Integer code = resJson.getInteger("Code");
        String message = resJson.getString("Message");
        return resJson.getString("data");
    }

    public List<IsOrderDTO> orderQuery(List<String> orderCodes) {
        //分批处理。每批100
        int size = 100;
        int count = orderCodes.size();
        int batchCount = count / size + (count % size == 0 ? 0 : 1);
        List<IsOrderDTO> res = new ArrayList<>();
        for (int i = 0; i < batchCount; i++) {
            log.info("开始处理第{}批数据", i + 1);
            int start = i * size;
            int end = Math.min(start + size, count);
            List<String> batchOrderCodes = new ArrayList<>(orderCodes.subList(start, end));
            String batchOrderCodesJson = JSON.toJSONString(batchOrderCodes);
            HttpRequest request = HttpUtil.createPost(orderQuery).body(batchOrderCodesJson).charset("UTF-8");
            HttpResponse response = request.execute();
            String body = response.body();
            log.info("响应:{}", body);
            int status = response.getStatus();
            JSONObject resJson = JSONObject.parseObject(body);
            Integer code = resJson.getInteger("code");
            String message = resJson.getString("message");
            String data = resJson.getString("data");
            List<IsOrderDTO> batchRes = JSON.parseArray(data, IsOrderDTO.class);
            res.addAll(batchRes);
        }
        return res;
    }

    public IsOrderDTO getOrder(String orderCode) {
        HttpRequest request = HttpUtil.createGet(GET_ORDER + orderCode).header("Authorization", token).charset("UTF-8");
        HttpResponse response = request.execute();
        String body = response.body();
        //log.info("响应:{}", body);
        int status = response.getStatus();
        JSONObject resJson = JSONObject.parseObject(body);
        Integer code = resJson.getInteger("code");
        String message = resJson.getString("message");
        String data = resJson.getString("data");
        if (StringUtils.isEmpty(data)) {
            return  null;
        }
        IsOrderDTO order = JSON.parseObject(data, IsOrderDTO.class);
        return order;
    }

    public List<IsRefundInfoDTO> refundInfoQuery(List<String> ids) {
        List<IsRefundInfoDTO> res = new ArrayList<>();
        for (String id : ids) {
            if (StringUtils.startsWith(id, "202")) {
                continue;
            }
            if (StringUtils.startsWith(id, "DUP")) {
                id = StringUtils.replace(id, "DUP", "");
            }
            HttpRequest request = HttpUtil.createGet(refundInfoQuery + id).header("Authorization", token).charset("UTF-8");
            HttpResponse response = request.execute();
            String body = response.body();
            //log.info("响应:{}", body);
            int status = response.getStatus();
            JSONObject resJson = JSONObject.parseObject(body);
            Integer code = resJson.getInteger("code");
            String message = resJson.getString("message");
            String data = resJson.getString("data");
            if (StringUtils.isEmpty(data)) {
                continue;
            }
            IsRefundInfoDTO batchRes = JSON.parseObject(data, IsRefundInfoDTO.class);
            res.add(batchRes);
        }
        return res;
    }

    public List<MerchantInfoDTO> getMerchantList() {
        HttpRequest request = HttpUtil.createGet(merchantList).header("Authorization", token).charset("UTF-8");
        HttpResponse response = request.execute();
        String body = response.body();
        log.info("响应:{}", body);
        JSONObject resJson = JSONObject.parseObject(body);
        Integer code = resJson.getInteger("code");
        String message = resJson.getString("message");
        JSONObject data = resJson.getJSONObject("data");

        if (data == null) {
            return null;
        }
        String list = data.getString("list");
        List<MerchantInfoDTO> res = JSONArray.parseArray(list, MerchantInfoDTO.class);
        return res;
    }

    public List<HotelHomestayDTO> getHotelList() {
        HttpRequest request = HttpUtil.createGet(hotelList).header("Authorization", token).charset("UTF-8");
        HttpResponse response = request.execute();
        String body = response.body();
        //log.info("响应:{}", body);
        JSONObject resJson = JSONObject.parseObject(body);
        Integer code = resJson.getInteger("code");
        String message = resJson.getString("message");
        JSONObject data = resJson.getJSONObject("data");

        if (data == null) {
            return null;
        }
        String list = data.getString("list");
        List<HotelHomestayDTO> res = JSONArray.parseArray(list, HotelHomestayDTO.class);
        return res;
    }

    public List<HouseBaseDTO> getHouseBaseList(String homeStayId) {
        HttpRequest request = HttpUtil.createGet(HOUSE_BASE_PAGE+homeStayId+"&page=1&limit=100").header("Authorization", token).charset("UTF-8");
        HttpResponse response = request.execute();
        String body = response.body();
        //log.info("响应:{}", body);
        JSONObject resJson = JSONObject.parseObject(body);
        Integer code = resJson.getInteger("code");
        String message = resJson.getString("message");
        JSONObject data = resJson.getJSONObject("data");

        if (data == null) {
            return null;
        }
        String list = data.getString("list");
        List<HouseBaseDTO> res = JSONArray.parseArray(list, HouseBaseDTO.class);
        return res;
    }

    public HouseBaseDTO getHouseBaseDetail(String houseBaseId) {
        HttpRequest request = HttpUtil.createGet(HOUSE_BASE_DETAIL+houseBaseId).header("Authorization", token).charset("UTF-8");
        HttpResponse response = request.execute();
        String body = response.body();
        //log.info("响应:{}", body);
        JSONObject resJson = JSONObject.parseObject(body);
        Integer code = resJson.getInteger("code");
        String message = resJson.getString("message");
        JSONObject data = resJson.getJSONObject("data");

        if (data == null) {
            return null;
        }
        return JSONObject.parseObject(data.toJSONString(), HouseBaseDTO.class);
    }

    public List<MerchantFlowRecordDTO> getrecord(String merchantId,String startDate,String endDate,String merchantType) {
        String url = recordPage + "?merchantId=" + merchantId + "&startDate=" + startDate + "&endDate=" + endDate + "&merchantType=" + merchantType;
        HttpRequest request = HttpUtil.createGet(url).header("Authorization", token).charset("UTF-8");
        HttpResponse response = request.execute();
        String body = response.body();
        log.info("响应:{}", body);
        JSONObject resJson = JSONObject.parseObject(body);
        Integer code = resJson.getInteger("code");
        String message = resJson.getString("message");
        String data = resJson.getString("data");
        if (data == null) {
            return null;
        }
        List<MerchantFlowRecordDTO> res = JSONArray.parseArray(data, MerchantFlowRecordDTO.class);
        return res;
    }
}
