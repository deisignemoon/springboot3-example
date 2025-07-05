package com.xiacong.util.suqi;

import lombok.Data;

import java.io.Serializable;

/**
 *
 *
 * @author xiacong
 * @Classname StockInfoQueryDTO
 * @Version 1.0.0
 * @Date 2025/6/3 16:30
 * @Created by xiacong
 */
@Data
public class StockInfoQueryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 出发城市/站点
     */
    private String fromName;

    /**
     * 到达城市/站点
     */
    private String toName;

    /**
     * 预订日期
     */
    private String travelDate;

    /**
     * 出发类型
     */
    private String fromType;

    /**
     * 到达类型
     */
    private String toType;

    /**
     * 产品 id
     */
    private String productId;
}
