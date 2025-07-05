package com.xiacong.util.suqi;

import lombok.Data;

import java.io.Serializable;

/**
 *
 *
 * @author xiacong
 * @Classname ScenicInfo
 * @Version 1.0.0
 * @Date 2025/6/3 16:22
 * @Created by xiacong
 */
@Data
public class ScenicInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 景区名称
     */
    private String scenicName;

    /**
     * 开放时间
     */
    private String openTime;

    /**
     * 景区地址
     */
    private String address;
}
