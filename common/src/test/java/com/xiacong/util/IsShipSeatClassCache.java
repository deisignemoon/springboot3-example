package com.xiacong.util;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 *
 *
 * @author xiacong
 * @Classname IsShipSeatClassCache
 * @Version 1.0.0
 * @Date 2025/2/24 16:05
 * @Created by xiacong
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class IsShipSeatClassCache {

    /**
     * id
     */
    private Long id;

    /**
     * 航线缓存id
     */
    private Long lineId;

    /**
     * 船票类型：1、客，2、车
     */
    private Integer ticketType;

    /**
     * 舱位等级号
     */
    public Integer classNum;

    /**
     * 舱位等级名
     */
    public String className;

    /**
     * 当前舱位等级剩余票数
     */
    public Integer totalCount;

    /**
     * 原票价
     */
    public BigDecimal originPrice;
    /**
     * 船票实际价格，此价格为实际售票价格
     */
    public BigDecimal totalPrice;

    /**
     * 儿童票价格，半价
     */
    public BigDecimal halfPrice;

    /**
     * 舱位状态，对应tm2 w_hxzt
     */
    private Integer seatState;

    /**
     * 舱位状态名，对应tm2 w_hxztm
     */
    private String seatStateName;

    /**
     * 当前舱位候补票数
     */
    private int candidateCount;

    /**
     * 是否可见 0 不可见 1 可见
     */
    private Integer isVisible;
    private Integer pubCurrentCount;
    private Integer localCurrentCount;
    private Integer ferryPassTotalCount;
    private BigDecimal localPrice;
    private BigDecimal localHalfPrice;
    private Integer totalOriginCount;

}
