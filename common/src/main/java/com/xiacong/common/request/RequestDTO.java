package com.xiacong.common.request;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xiacong
 * @Classname RequestDTO
 * @Version 1.0.0
 * @Date 2024/5/29 10:41
 * @Created by xiacong
 */
@Data
public class RequestDTO<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 请求方式
     */
    private String method;

    /**
     * 请求接口
     */
    private String path;

    /**
     * 请求来源
     */
    private String source;

    /**
     * 请求目标
     */
    private String destination;

    /**
     * 时间戳
     */
    private LocalDateTime timestamp;

    /**
     * 请求报文
     */
    private T data;

    public RequestDTO(String method, String path, T data) {
        this.method = method;
        this.path = path;
        this.data = data;
    }

    public RequestDTO(String method, String path, String source, String destination, LocalDateTime timestamp, T data) {
        this.method = method;
        this.path = path;
        this.source = source;
        this.destination = destination;
        this.timestamp = timestamp;
        this.data = data;
    }
}
