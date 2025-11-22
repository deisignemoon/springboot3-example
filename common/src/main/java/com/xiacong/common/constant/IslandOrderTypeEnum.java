package com.xiacong.common.constant;

/**
 *
 *
 * @author xiacong
 * @Classname IslandOrderTypeEnum
 * @Version 1.0.0
 * @Date 2025/9/15 9:07
 * @Created by xiacong
 */
public enum IslandOrderTypeEnum {
    SCENIC(1, "景点"),
    JH_SCENIC(95, "基湖门票"),
    HN_SCENIC(96, "花鸟门票"),
    NCT_SCENIC(97, "南长涂门票"),
    HOTEL(2, "酒店"),
    HOTEL_REPAST(201, "民宿餐饮"),
    HOTEL_CHANGE_DATE(202, "民宿改期"),
    SHIP(3, "船票"),
    FOOD(4, "餐饮"),
    SHIP_RETURN(9, "船票往返"),
    FISHERMAN(10, "渔家乐"),
    SHIP_TRAVEL_PLAN(22, "船票出行规划多订单"),
    SHIP_REAER(23, "候补船票"),
    SUQU_BUS(25, "苏汽车票"),
    FB_SHIP(26, "花鸟直达船"),
    ;

    private Integer code;
    private String name;

    IslandOrderTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getNameByCode(Integer code) {
        for (IslandOrderTypeEnum value : IslandOrderTypeEnum.values()) {
            if (value.code.equals(code)) {
                return value.name;
            }
        }
        return "其它";
    }
}
