package com.xiacong.controller;

import com.tencentcloudapi.lke.v20231130.models.MsgRecord;
import com.xiacong.service.TencentLkeService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 *
 * @author xiacong
 * @Classname TencentLkeController
 * @Version 1.0.0
 * @Date 2025/4/17 14:06
 * @Created by xiacong
 */
@RestController
@RequestMapping("/ai")
@Slf4j
public class TencentLkeController {

    @Resource
    private TencentLkeService service;

    @GetMapping("/chat")
    public void completion(@RequestParam(value = "message") String message, @RequestParam(value = "sessionid") String sessionId, HttpServletResponse rp) {
        service.completion(message, sessionId, rp);
    }

    @GetMapping("/history")
    public List<MsgRecord> history(@RequestParam(value = "sessionId") String sessionId) {
        return service.history(sessionId);
    }
}
