package com.xiacong.service;

import com.tencentcloudapi.lke.v20231130.models.MsgRecord;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.PrintWriter;
import java.util.List;

/**
 *
 *
 * @author xiacong
 * @Classname TencentLkeService
 * @Version 1.0.0
 * @Date 2025/4/17 15:20
 * @Created by xiacong
 */
public interface TencentLkeService {

    void completion(String message, String sessionId, SseEmitter sseEmitter);
    List<MsgRecord> history(String sessionId);

    void completion2(String message, String sessionId, PrintWriter writer);
}
