package com.xiacong.controller;

import cn.hutool.json.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author xiacong
 * @Classname HelloController
 * @Version 1.0.0
 * @Date 2025/3/26 8:34
 * @Created by xiacong
 */
@RestController
@RequestMapping("")
@Slf4j
public class HelloController {

    @GetMapping(value = "/hello", produces = "application/json")
    public String merrefundV1() {
        JSONObject object = new JSONObject();
        object.set("return_code", "0");
        return object.toString();
    }
}
