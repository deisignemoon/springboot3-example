package com.xiacong.util.suqi;

import lombok.Data;

import java.io.Serializable;

/**
 *
 *
 * @author xiacong
 * @Classname ProductTabInfo
 * @Version 1.0.0
 * @Date 2025/6/3 16:26
 * @Created by xiacong
 */
@Data
public class ProductTabInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 产品 ID
     */
    private String productId;

    /**
     * 业务类型 1:拼车2： 班车 3： 包车
     */
    private String businessType;

    /**
     * 出发城市名称
     */
    private String fromCityName;

    /**
     * 到达城市名称
     */
    private String toCityName;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 套餐名称
     */
    private String tourPackName;

    /**
     * 起售价
     */
    private String minSalePrice;
}
