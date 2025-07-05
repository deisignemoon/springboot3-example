package com.xiacong.util.suqi;

import lombok.Data;

import java.io.Serializable;

/**
 * 出发城市/景区/演出
 *
 * @author xiacong
 * @Classname GoCityOrStation
 * @Version 1.0.0
 * @Date 2025/6/3 14:30
 * @Created by xiacong
 */
@Data
public class GoCityOrStation implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 出发城市/景区/演出名称
     */
    private String fromName;

    /**
     * 出发类型 1:城市, 3:景区 4:明星 5:场馆
     */
    private String fromType;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 景区/演出 id
     */
    private String scenicId;

    /**
     * 场馆/城市名称
     */
    private String showVenueOrCityName;
}
