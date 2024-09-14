package com.xiacong.common.request;

import lombok.Data;

import java.util.List;

/**
 * @author xiacong
 * @Classname QrCodeInfoDTO
 * @Version 1.0.0
 * @Date 2024/7/2 14:05
 * @Created by xiacong
 */
@Data
public class QrCodeInfoDTO {

    private Integer id;

    private String name;

    private String no;

    private String route;

    private String method;

    private String uri;

    private String params;

    private List<String> drawText;

    public QrCodeInfoDTO() {
    }

    public QrCodeInfoDTO(String name, String no, String route, String method, String uri, String params) {
        this.name = name;
        this.no = no;
        this.route = route;
        this.method = method;
        this.uri = uri;
        this.params = params;
    }
}
