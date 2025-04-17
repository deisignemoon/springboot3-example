package com.xiacong.controller;

import cn.hutool.json.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * icbc
 *
 * @author xiacong
 * @Classname IcbcMockController
 * @Version 1.0.0
 * @Date 2025/3/21 14:06
 * @Created by xiacong
 */
@RestController
@RequestMapping("/api/cardbusiness/aggregatepay/b2c/online")
@Slf4j
public class IcbcMockController {

    @PostMapping(value = "/merrefund/V1", produces = "application/json")
    public String merrefundV1() {
        JSONObject object = new JSONObject();
        object.set("return_code", "0");
        return object.toString();
    }
}
