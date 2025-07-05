package com.xiacong.util.suqi;

import lombok.Data;

import java.io.Serializable;

/**
 *
 *
 * @author xiacong
 * @Classname CityStation
 * @Version 1.0.0
 * @Date 2025/6/3 16:01
 * @Created by xiacong
 */
@Data
public class CityStation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 到达城市/景区/演出名称
     */
    private String name;

    /**
     * 到达类型 1:城市, 2:景区 3:明星 4:场馆 5:机场
     */
    private String type;
}
