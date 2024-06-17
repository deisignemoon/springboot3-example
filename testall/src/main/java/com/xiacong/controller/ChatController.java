package com.xiacong.controller;

import com.xiacong.service.AbstractTongYiServiceImpl;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiacong
 * @Classname ChatController
 * @Version 1.0.0
 * @Date 2024/6/17 15:18
 * @Created by xiacong
 */
//@RestController("/chat")
@Slf4j
public class ChatController {
    @Resource
    private AbstractTongYiServiceImpl tongYiService;

    @GetMapping(value = "/{message}", produces = "application/json")
    public String findById(@PathVariable String message) {
        return tongYiService.completion(message);
    }
}
