package com.xiacong.controller;

import com.xiacong.service.SendMsg;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Resource
    private SendMsg sendMsg;

    @GetMapping("/add/{storeId}")
    public Boolean add(@PathVariable("storeId") Long storeId) {
        sendMsg.testSendDelayMessage();
        return true;
    }
}
