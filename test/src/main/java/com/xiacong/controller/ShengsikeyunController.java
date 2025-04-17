package com.xiacong.controller;

import com.alibaba.fastjson2.JSONObject;
import com.xiacong.model.LineSearchDTO;
import com.xiacong.service.ShengsikeyunService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author xiacong
 * @Classname ShengsikeyunController
 * @Version 1.0.0
 * @Date 2025/3/4 8:39
 * @Created by xiacong
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class ShengsikeyunController {
    @Resource
    private ShengsikeyunService service;

    @PostMapping("/api/foreign/line/ship/enq")
    public String queryLine(@RequestBody LineSearchDTO dto) {
        log.info("dto:{}", JSONObject.toJSONString(dto));
        return null;
    }

    @PostMapping("/api/foreign/line/ferry/enq")
    public String ferryLine(@RequestBody LineSearchDTO dto) {
        log.info("dto:{}", JSONObject.toJSONString(dto));
        return service.queryLine(dto);
    }
}
