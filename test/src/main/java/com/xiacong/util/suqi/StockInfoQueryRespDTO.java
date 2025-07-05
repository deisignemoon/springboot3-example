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
public class StockInfoQueryRespDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 出发站点 ID
     */
    private String fromStationId;

    /**
     *  出发站点名称
     */
    private String fromStationName;

    /**
     * 出发时间 HH:mm
     */
    private String fromTime;

    /**
     * 到达站点 ID
     */
    private String toStationId;

    /**
     *  到达站点名字
     */
    private String toStationName;

    /**
     * 路程耗时(分钟
     */
    private String costTime;

    /**
     * 车型
     */
    private String model;

    /**
     * 产品 id
     */
    private String scenicBusId;

    /**
     * 线路 ID
     */
    private String busLineId;

    /**
     * 库存
     */
    private String stockRemain;

    /**
     * 售价
     */
    private String salePrice;
}
