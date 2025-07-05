import com.alibaba.fastjson2.JSONObject;
import com.xiacong.util.suqi.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 *
 * @author xiacong
 * @Classname SuqiTest
 * @Version 1.0.0
 * @Date 2025/6/3 16:12
 * @Created by xiacong
 */
public class SuqiTest {

    /**
     * [{"cityName":"昆山","fromName":"昆山","fromType":"1"},{"cityName":"嵊泗","fromName":"嵊泗","fromType":"1"},{"cityName":"舟山","fromName":"嵊泗","fromType":"3","scenicId":"1930062752437448705"}]
     */
    @Test
    public void startCity() {
        SuZhouBusUtil util = new SuZhouBusUtil("http://open.qa.sqk.com.cn:31005", "lavx0x3fdigzcugxyppxo3axn50uz1jy", "zszyqd");
        List<GoCityOrStation> scenicAllGoCityOrStation = util.getScenicAllGoCityOrStation("0");
        System.out.println(JSONObject.toJSONString(scenicAllGoCityOrStation));
    }

    /**
     * [{"cityCode":"320583","cityName":"昆山","cityScenicList":[{"type":1,"name":"昆山"}]},{"cityCode":"330922","cityName":"嵊泗","cityScenicList":[{"type":1,"name":"嵊泗"}]}]
     */
    @Test
    public void endCity() {
        SuZhouBusUtil util = new SuZhouBusUtil("http://open.qa.sqk.com.cn:31005", "lavx0x3fdigzcugxyppxo3axn50uz1jy", "zszyqd");
        List<ToCityStationList> toCityStationLists = util.listScenicDestinationCity("", "", "");
        System.out.println(JSONObject.toJSONString(toCityStationLists));
    }

    /**
     * [{"cityName":"上海","fromName":"迪士尼","fromType":"3","scenicId":"1920348117100707842"},{"cityName":"苏州","fromName":"苏州","fromType":"1"},{"cityName":"嵊泗","fromName":"嵊泗","fromType":"1"},{"cityName":"舟山","fromName":"嵊泗","fromType":"3","scenicId":"1930062752437448705"}]
     */
    @Test
    public void productInfo() {
        SuZhouBusUtil util = new SuZhouBusUtil("http://open.qa.sqk.com.cn:31005", "lavx0x3fdigzcugxyppxo3axn50uz1jy", "zszyqd");
        StockInfoQueryDTO stockInfoQueryDTO = new StockInfoQueryDTO();
        stockInfoQueryDTO.setTravelDate("2025-06-20");
        stockInfoQueryDTO.setFromName("嵊泗");
        stockInfoQueryDTO.setFromType("5");
        stockInfoQueryDTO.setToName("昆山");
        stockInfoQueryDTO.setToType("5");
        stockInfoQueryDTO.setProductId("78161");
        List<StockInfoQueryRespDTO> stockInfoQueryRespDTOS = util.productStockInfo(stockInfoQueryDTO);
        System.out.println(JSONObject.toJSONString(stockInfoQueryRespDTOS));
    }

    /**
     * [{"minPrice":"0.01","packId":"92170","packName":"去程车票","ticketType":"1"}]
     */
    @Test
    public void parkQuery() {
        SuZhouBusUtil util = new SuZhouBusUtil("http://open.qa.sqk.com.cn:31005", "lavx0x3fdigzcugxyppxo3axn50uz1jy", "zszyqd");
        List<ParkListQueryRespDTO> parkListQueryRespDTOS = util.parkListQuery(new Date(), "78161");
        System.out.println(JSONObject.toJSONString(parkListQueryRespDTOS));
    }

    /**
         * {"productTabInfoDtoList":[{"businessType":"2","fromCityName":"嵊泗","minSalePrice":"0.01","productId":"78161","productName":"嵊泗-昆山","toCityName":"昆山","tourPackName":"去程车票"},{"businessType":"2","fromCityName":"昆山","minSalePrice":"0.01","productId":"78162","productName":"昆山-嵊泗","toCityName":"嵊泗","tourPackName":"去程车票"}],"scenicInfoResponseDto":{"address":"嵊泗","openTime":"全天","scenicName":"嵊泗"}}
     */
    @Test
    public void scenicProductList() {
        SuZhouBusUtil util = new SuZhouBusUtil("http://open.qa.sqk.com.cn:31005", "lavx0x3fdigzcugxyppxo3axn50uz1jy", "zszyqd");
        ScenicProductInfo scenicProductInfo = util.listProduct("", new Date());
        System.out.println(JSONObject.toJSONString(scenicProductInfo));
    }

    @Test
    public void createOrder() {
        SuZhouBusUtil util = new SuZhouBusUtil("http://open.qa.sqk.com.cn:31005", "lavx0x3fdigzcugxyppxo3axn50uz1jy", "zszyqd");
        BusAddOrderReqDTO dto = new BusAddOrderReqDTO();
        dto.setOutOrderNo("20250604150000000001");
        dto.setContactName("夏聪");
        dto.setContactTel("18268731097");
        dto.setProductId("78161");
        dto.setLineId("126947");
        dto.setTravelDate("2025-06-04");
        dto.setGoTime("18:00");
        dto.setPackId("92170");
        dto.setStationUpId("10321033");
        dto.setStationDownId("10320861");
        dto.setOrderPrice("0.01");
        dto.setTicketType("1");
        dto.setPersonNumber("1");
        dto.setTravelPersons(List.of(new TravelPerson("夏聪", "18268731097", "1","330902199303014418")));
        String orderNo = util.addOrder(dto);
        System.out.println(orderNo);
    }

    @Test
    public void orderDetail() {
        SuZhouBusUtil util = new SuZhouBusUtil("http://open.qa.sqk.com.cn:31005", "lavx0x3fdigzcugxyppxo3axn50uz1jy", "zszyqd");
        BusOrderInfoRespDTO busOrderInfoRespDTO = util.orderInfo("DDTC0057083");
        System.out.println(JSONObject.toJSONString(busOrderInfoRespDTO));
    }

    @Test
    public void refundPrice() {
        SuZhouBusUtil util = new SuZhouBusUtil("http://open.qa.sqk.com.cn:31005", "lavx0x3fdigzcugxyppxo3axn50uz1jy", "zszyqd");
        BigDecimal bigDecimal = util.orderRefundPrice("DDTC0057083");
        System.out.println(bigDecimal);
    }

    @Test
    public void refundOrder() {
        SuZhouBusUtil util = new SuZhouBusUtil("http://open.qa.sqk.com.cn:31005", "lavx0x3fdigzcugxyppxo3axn50uz1jy", "zszyqd");
        Boolean b = util.orderRefund("DDTC0057083", "退款测试", new BigDecimal("0.01"));
        System.out.println(b);
    }

    @Test
    public void invoice() {
        SuZhouBusUtil util = new SuZhouBusUtil("http://open.qa.sqk.com.cn:31005", "lavx0x3fdigzcugxyppxo3axn50uz1jy", "zszyqd");
        BusOrderInvoiceReqDTO dto = new BusOrderInvoiceReqDTO();
        dto.setOrderNumber("DDTC0057083");
        dto.setBuyerName("夏聪");
        dto.setEmail("946933678@qq.com");
        dto.setPrice("0.01");
        Boolean b = util.orderInvoice(dto);
        System.out.println(b);
    }
}
