package com.xiacong.util.suqi;

import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpStatus;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Base64;
import java.util.Date;
import java.util.List;

/**
 *
 *
 * @author xiacong
 * @Classname SuZhouBusUtil
 * @Version 1.0.0
 * @Date 2025/6/3 14:12
 * @Created by xiacong
 */
@Slf4j
public class SuZhouBusUtil {

    public static String URL;

    public static String KEY;
    public static String CHANNEL;

    public SuZhouBusUtil(String url, String key, String channel) {
        URL = url;
        KEY = key;
        CHANNEL = channel;
    }


    /**
     * 出发城市或景区/演出列表查询
     */
    private static String GET_SCENIC_ALL_GO_CITY_OR_STATION = "/eos/product/getScenicAllGoCityOrStation";

    /**
     * 到达城市或景区/演出列表查询
     */
    private static String LIST_SCENIC_DESTINATION_CITY = "/eos/product/listScenicDestinationCity";
    /**
     * 查询景区/演出产品列表
     */
    private static String LIST_PRODUCT = "/eos/product/list";

    /**
     * 库存列表查询
     */
    private static String PRODUCT_STOCK_INFO = "/eos/product/stockInfo";

    /**
     * 套餐列表查询
     */
    private static String PARK_LIST_QUERY = "/eos/product/packList";

    /**
     * 新增订单
     * 客户支付成功之后， 调用下单接口。
     */
    private static String ORDER_APPLY = "/eos/order/apply";

    /**
     * 订单详情查询
     */
    private static String ORDER_INFO = "/eos/order/info";

    /**
     *  获取购票信息说明接口
     */
    private static String PRODUCT_DESC = "/eos/product/desc";
    /**
     * 获取退改规则
     */
    private static String REFUND_RULE = "/eos/order/refundRule";

    /**
     *  获取订单退款价格
     */
    private static String REFUND_PRICE = "/eos/order/refundPrice";

    /**
     * 订单退款
     */
    private static String REFUND_ORDER = "/eos/order/refund";

    /**
     * 发票申请接口
     */
    private static String ORDER_INVOICE = "/eos/order/requestInvoice";

    /**
     * 订单评价接口
     */
    private static String ORDER_COMMENT = "/eos/order/makeComment";

    private String invoke(String method, JSONObject params) {
        String data = JSONObject.toJSONString(params);
        log.info("请求苏汽报文{}", data);
        long timestamp = System.currentTimeMillis();
        JSONObject jsonObject = new JSONObject();
        byte[] decode = Base64.getEncoder().encode(data.getBytes());
        jsonObject.put("data", new String(decode));
        jsonObject.put("timestamp", timestamp);
        jsonObject.put("channel", CHANNEL);
        jsonObject.put("sign", getSign(new String(decode), String.valueOf(timestamp)));
        HttpRequest request = HttpUtil.createPost(URL + method).body(jsonObject.toJSONString()).charset("UTF-8");
        HttpResponse response = request.execute();
        int status = response.getStatus();
        log.info("苏汽响应:{}", JSONObject.toJSONString(response));
        Assert.isTrue(status == HttpStatus.HTTP_OK, "调用苏汽失败");
        String body = response.body();
        log.info("苏汽响应报文:{}", body);
        JSONObject resJson = JSONObject.parseObject(body);
        String code = resJson.getString("code");
        Assert.isTrue(StringUtils.equals(code, "0000"), "调用苏汽返回失败:" + resJson.getString("message"));
        return resJson.getString("data");
    }

    private String getSign(String data, String timeStamp) {
        return DigestUtils.md5Hex(timeStamp + data + KEY);
    }

    /**
     * 出发城市或景区/演出列表查询
     * @param type 类型： 0， 景区 1， 演出
     * @return
     */
    public List<GoCityOrStation> getScenicAllGoCityOrStation(String type) {
        JSONObject params = new JSONObject();
        params.put("type", type);
        String invoke = invoke(GET_SCENIC_ALL_GO_CITY_OR_STATION, params);
        return JSONArray.parseArray(invoke, GoCityOrStation.class);
    }

    /**
     * 到达城市或景区/演出列表查询
     * @param fromType 出发类型 1:城市
     * @param fromName 出发城市/站点
     * @param type 类型  0， 景区 1， 演出
     * @return
     */
    public List<ToCityStationList> listScenicDestinationCity(String fromType, String fromName, String type) {
        JSONObject params = new JSONObject();
        params.put("fromType", fromType);
        params.put("fromName", fromName);
        params.put("type", type);
        String invoke = invoke(LIST_SCENIC_DESTINATION_CITY, params);
        return JSONArray.parseArray(invoke, ToCityStationList.class);
    }

    /**
     * 查询景区/演出产品列表
     * @param scenicId 景区/演出 id
     * @param travelDate 出发日期 yyyy-MM-dd
     * @return
     */
    public ScenicProductInfo listProduct(String scenicId, Date travelDate) {
        JSONObject params = new JSONObject();
        params.put("scenicId", scenicId);
        params.put("travelDate", DateUtil.format(travelDate, "yyyy-MM-dd"));
        String invoke = invoke(LIST_PRODUCT, params);
        return JSONObject.parseObject(invoke, ScenicProductInfo.class);
    }


    /**
     * 库存列表查询
     * @param dto
     * @return
     */
    public List<StockInfoQueryRespDTO> productStockInfo(StockInfoQueryDTO dto) {
        JSONObject params = JSONObject.parseObject(JSONObject.toJSONString(dto));
        String invoke = invoke(PRODUCT_STOCK_INFO, params);
        return JSONArray.parseArray(invoke, StockInfoQueryRespDTO.class);
    }

    /**
     * 套餐列表查询
     * @param date 出行日期
     * @param productId 产品 ID
     */
    public List<ParkListQueryRespDTO> parkListQuery(Date date, String productId) {
        JSONObject params = new JSONObject();
        params.put("productId", productId);
        params.put("date", DateUtil.format(date, "yyyy-MM-dd"));
        String invoke = invoke(PARK_LIST_QUERY, params);
        return JSONArray.parseArray(invoke, ParkListQueryRespDTO.class);
    }



    /**
     * 新增订单
     * @param dto
     * @return 苏汽订单号
     */
    public String addOrder(BusAddOrderReqDTO dto) {
        JSONObject params = JSONObject.parseObject(JSONObject.toJSONString(dto));
        String invoke = invoke(ORDER_APPLY, params);
        JSONObject jsonObject = JSONObject.parseObject(invoke);
        return jsonObject.getString("orderNumber");
    }


    /**
     * 订单详情查询
     * @param orderNumber
     * @return
     */
    public BusOrderInfoRespDTO orderInfo(String orderNumber) {
        JSONObject params = new JSONObject();
        params.put("orderNumber", orderNumber);
        String invoke = invoke(ORDER_INFO, params);
        return JSONObject.parseObject(invoke, BusOrderInfoRespDTO.class);
    }


    /**
     * 获取订单退款价格
     * @param orderNumber
     * @return
     */
    public BigDecimal orderRefundPrice(String orderNumber) {
        JSONObject params = new JSONObject();
        params.put("orderNumber", orderNumber);
        String invoke = invoke(REFUND_PRICE, params);
        JSONObject jsonObject = JSONObject.parseObject(invoke);
        return jsonObject.getBigDecimal("refundPrice");
    }

    /**
     * 订单退款
     * @param orderNumber
     * @return
     */
    public Boolean orderRefund(String orderNumber,String refundReason,BigDecimal refundPrice) {
        JSONObject params = new JSONObject();
        params.put("orderNumber", orderNumber);
        params.put("refundReason", refundReason);
        params.put("refundPrice", refundPrice.setScale(2, RoundingMode.HALF_UP).toString());
        String invoke = invoke(REFUND_ORDER, params);
        return true;
    }

    /**
     * 发票申请接口
     * @return
     */
    public Boolean orderInvoice(BusOrderInvoiceReqDTO dto) {
        JSONObject params = JSONObject.parseObject(JSONObject.toJSONString(dto));
        String invoke = invoke(ORDER_INVOICE, params);
        return true;
    }
}
