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
public class ParkListQueryRespDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 套餐 ID
     */
    private String packId;

    /**
     * 套餐名字
     */
    private String packName;

    /**
     * 起售价
     */
    private String minPrice;

    /**
     * 票务类型1.去程;2.往返； 3.返程
     */
    private String ticketType;

}
