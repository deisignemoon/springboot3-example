package com.xiacong.util.suqi;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

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
public class ScenicProductInfo implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 景区信息
     */
    private ScenicInfo scenicInfoResponseDto;

    /**
     * 产品信息列表
     */
    private List<ProductTabInfo> productTabInfoDtoList;
}
