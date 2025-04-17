package com.xiacong.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
public class LineSearchDTO implements Serializable {

    @NotNull
    private Integer startPortNo;
    @NotNull
    private Integer endPortNo;
    @NotBlank
    private String startDate;

    private String searchBox;

    /**
     * 供船舶实时位置跳转h5获取船票信息使用
     */
    private Integer index;

    /**
     * 航线号
     */
    private Integer lineNum;

    /**
     * 时序
     */
    private Integer sx;
}
