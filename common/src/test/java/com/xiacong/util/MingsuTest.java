package com.xiacong.util;

import com.alibaba.fastjson2.JSONArray;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 *
 * @author xiacong
 * @Classname MingsuTest
 * @Version 1.0.0
 * @Date 2024/12/25 9:32
 * @Created by xiacong
 */
public class MingsuTest {

    String req = "{\"bgdate\":\"2024-12-25\",\"eddate\":\"2024-12-25\",\"domainid\":83,\"emp_id\":166,\"type\":2,\"sign\":\"5349902d23819bbb94bbb74d6d112de6\",\"key\":\"787633B1\",\"timestamp\":\"2024-12-25 09:30:37\"}\"";
    String threeResp = "[{\"ticketList\":null,\"ticket_id\":0,\"id\":751,\"domainid\":113,\"letway\":\"独立房间\",\"same_housing_resources_no\":\"1\",\"housing_resources_type\":\"客栈\",\"housing_resources_place\":\"舟山市嵊泗县菜园镇基湖村方姜南弄1号\",\"housing_resources_address\":\"舟山市嵊泗县菜园镇基湖村方姜南弄1号\",\"explain\":\"13867230969\\n\",\"village_name\":\"\",\"building_door\":\"\",\"village_x\":\"122.469538\",\"village_y\":\"30.71149\",\"spot_name\":\"浙江省舟山市嵊泗县菜园镇海通路22号舟山嵊泗列岛风景名胜区\",\"housetype\":null,\"housearea\":\"35\",\"server\":\"无线网络,空调,电视,拖鞋\",\"bedtype\":\"\\\"家庭房(1.5×2米) *1\\n           (1.2×2米) *1\\\"\\n\",\"bathroomtype\":\"独卫\",\"housing_resources_view\":\"民宿坐落于嵊泗县基湖沙滩景区旁边，由一座80年代的海岛老房子改建而成，民宿有一个大大的院落，坐北朝南阳光充足，院落两角的两颗百年古树，院落及室内装修为北欧、摩洛哥风格。整个院落和房间的设计、装修都是由民宿主人独自完成的。\",\"room_name\":\"几静民宿\",\"room_smallname\":\"几静民宿\",\"housing_resources_characteristic\":\"民宿坐落于嵊泗县基湖沙滩景区旁边，由一座80年代的海岛老房子改建而成，民宿有一个大大的院落，坐北朝南阳光充足，院落两角的两颗百年古树，院落及室内装修为北欧、摩洛哥风格。整个院落和房间的设计、装修都是由民宿主人独自完成的。\\n\",\"traffic_location\":\"舟山市嵊泗县菜园镇基湖村方姜南弄1号\\n\",\"area_introduce\":\"民宿坐落于嵊泗县基湖沙滩景区旁边，由一座80年代的海岛老房子改建而成，民宿有一个大大的院落，坐北朝南阳光充足，院落两角的两颗百年古树，院落及室内装修为北欧、摩洛哥风格。整个院落和房间的设计、装修都是由民宿主人独自完成的。\\n\",\"start_time\":\"00:00:00\",\"end_time\":\"23:59:00\",\"sex\":\"不限\",\"clean_way\":\"一客一换/一天一换\",\"requirement\":null,\"price\":null,\"iscleanmoney\":null,\"cleanmoney\":\"0\",\"people_no\":\"2\",\"isaddpeople\":null,\"addmoney\":\"0\",\"isgetmoney\":\"0\",\"whereday\":\"14:00\",\"percentage\":\"0\",\"mindays\":\"1\",\"maxdays\":\"0\",\"starttime2\":\"00:00:00\",\"endtime2\":\"23:59:00\",\"exittime\":\"12:00:00\",\"updatebed\":\"一客一换/一天一换\",\"giveteeth\":\"一客一换/一天一换\",\"givetowel\":\"一客一换/一天一换\",\"smoking\":\"0\",\"partying\":\"1\",\"cooking\":\"0\",\"dog\":\"0\",\"children\":\"1\",\"kids\":\"1\",\"oldpeople\":\"1\",\"photo\":\"1\",\"bathroom\":\"1\",\"wc\":\"1\",\"saloon\":\"0\",\"kitchen\":\"0\",\"study\":\"0\",\"balcony\":\"0\",\"cover\":\"picture/8cde8bf4c7e3420c99c010e44aacc34a.png,picture/b2e946976c514c29a8b5579c538955e9.png\",\"bathroom_pic\":\"picture/0af7fe2174944006b603ce8287d9425b.png\",\"saloon_pic\":\"\",\"kitchen_pic\":\"\",\"wc_pic\":\"\",\"other_pic\":\"picture/f0fc7b6b5ea34c4da3cc7028a162c1fd.png\",\"status\":null,\"did\":0,\"domain_name\":null,\"address\":null,\"iphone\":null,\"ticketname\":null,\"contact\":null,\"sheng\":\"浙江省\",\"shi\":\"舟山市\",\"qu\":\"嵊泗县\",\"marketprice\":null,\"sellingprice\":null,\"settlementprice\":null,\"num\":0,\"list\":null,\"minprice\":0,\"typename\":\"几静民宿\",\"shoucangstatus\":0,\"selltickets\":[{\"id\":796,\"t_id\":884,\"ticketname\":\"柴\",\"employee_id\":166,\"info\":null},{\"id\":797,\"t_id\":884,\"ticketname\":\"米\",\"employee_id\":166,\"info\":null},{\"id\":798,\"t_id\":884,\"ticketname\":\"油\",\"employee_id\":166,\"info\":null},{\"id\":800,\"t_id\":884,\"ticketname\":\"盐\",\"employee_id\":166,\"info\":null},{\"id\":801,\"t_id\":884,\"ticketname\":\"酱\",\"employee_id\":166,\"info\":null},{\"id\":802,\"t_id\":884,\"ticketname\":\"茶\",\"employee_id\":166,\"info\":null}]}]";

    @Test
    public void test01() {
        HomeStayListDTO dto = new HomeStayListDTO();
        dto.setBeginDate(1735090237367L);
        dto.setEndDate(1735176637367L);
        dto.setMinPrice(0);
        dto.setMaxPrice(1600);
        //HomeStayListParam param =JSONObject.parseObject(req, HomeStayListParam.class);
        List<HomeStayRes> list = JSONArray.parseArray(threeResp, HomeStayRes.class);
        Stream<HomeStayRes> stream = list.stream();
        //区 筛选
        if (dto.getDistrict() != null && !dto.getDistrict().equals("")) {
            stream = stream.filter(homeStayRes -> homeStayRes.getQu().equals(dto.getDistrict()));
        }
        //名 筛选
        if (dto.getName() != null && !dto.getName().equals("")) {
            stream = stream.filter(homeStayRes -> homeStayRes.getRoom_name().contains(dto.getName()));
        }
        //内层minPrice 赋值
        stream = stream.peek(homeStayRes -> homeStayRes.getSelltickets()
                .forEach(selltickets -> selltickets.setMinprice(
                        selltickets.getInfo() == null ? null : selltickets.getInfo().stream()
                                .map(TicketInfo::getSellingprice)
                                .min(Comparator.naturalOrder())
                                .get()
                )));
        //外层 minPrice maxPrice 赋值
        stream = stream
                .peek(homeStayRes -> {
                            Optional<BigDecimal> min = homeStayRes.getSelltickets().stream()
                                    .map(Selltickets::getMinprice).filter(Objects::nonNull)
                                    .min(Comparator.naturalOrder());
                            if (!min.isPresent()) {
                                homeStayRes.setMinprice(BigDecimal.ZERO);
                            } else {
                                homeStayRes.setMinprice(min.get());
                            }
                        }
                ).peek(homeStayRes -> {
                            Optional<BigDecimal> max = homeStayRes.getSelltickets().stream()
                                    .map(Selltickets::getMinprice).filter(Objects::nonNull)
                                    .max(Comparator.naturalOrder());
                            if (!max.isPresent()) {
                                homeStayRes.setMaxprice(BigDecimal.ZERO);
                            } else {
                                homeStayRes.setMaxprice(max.get());
                            }
                        }
                );
        //最低价筛选
        if (dto.getMinPrice() != null) {
            stream = stream.filter(homeStayRes -> homeStayRes.getMinprice() != null &&
                    homeStayRes.getMinprice().compareTo(new BigDecimal(dto.getMinPrice())) >= 0);
        }
        //最高价筛选
        if (dto.getMaxPrice() != null) {
            stream = stream.filter(homeStayRes -> homeStayRes.getMaxprice() != null &&
                    homeStayRes.getMaxprice().compareTo(new BigDecimal(dto.getMaxPrice())) <= 0);
        }

        //距离排序
        if (dto.getLatitude() != null && !dto.getLatitude().equals("") &&
                dto.getLongitude() != null && !dto.getLongitude().equals("")) {
            stream = stream.peek(hs -> hs.setDistance(
                    LocationUtils.getDistance(Double.valueOf(hs.getVillage_y()), Double.valueOf(hs.getVillage_x()),
                            Double.valueOf(dto.getLatitude()), Double.valueOf(dto.getLongitude())))
            ).sorted(Comparator.comparing(HomeStayRes::getDistance));
        }
        System.out.println(stream.collect(Collectors.toList()));
    }
}
