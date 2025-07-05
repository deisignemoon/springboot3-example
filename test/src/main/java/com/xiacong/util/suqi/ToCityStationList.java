package com.xiacong.util.suqi;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 到达城市或景区/演出列表
 *
 * @author xiacong
 * @Classname ToCityStationList
 * @Version 1.0.0
 * @Date 2025/6/3 16:01
 * @Created by xiacong
 */
@Data
public class ToCityStationList  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 城市编码
     */
    private String cityCode;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 城市景区/演出列表
     */
    private List<CityStation> cityStationList;
}
