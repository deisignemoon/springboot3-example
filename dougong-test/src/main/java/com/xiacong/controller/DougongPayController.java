package com.xiacong.controller;

import com.alibaba.fastjson.JSONObject;
import com.xiacong.utils.DougongUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 *
 *
 * @author xiacong
 * @Classname DougongPayController
 * @Version 1.0.0
 * @Date 2025/4/25 13:35
 * @Created by xiacong
 */
@RestController
@Slf4j
@RequestMapping("/dougong/pay")
public class DougongPayController {

    @Resource
    private DougongUtil dougongUtil;

    @GetMapping(value = "/create", produces = "application/json")
    public String create() {
        Map<String, Object> map = dougongUtil.orderCreate();
        return JSONObject.toJSONString(map);
    }

    @GetMapping(value = "/queryConfig", produces = "application/json")
    public String queryConfig() {
        Map<String, Object> map = dougongUtil.merchantConfigQuery();
        return JSONObject.toJSONString(map);
    }

    @GetMapping(value = "/userEnt", produces = "application/json")
    public String userEnt() {
        Map<String, Object> map = dougongUtil.companyUserEnt();
        return JSONObject.toJSONString(map);
    }
}
