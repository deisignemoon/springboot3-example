package com.xiacong.controller;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.xiacong.flow.FlowEngine;
import com.xiacong.flow.common.content.ApplicationContent;
import com.xiacong.mapper.IsShipOrderMapper;
import com.xiacong.model.domain.IsShipOrder;
import com.xiacong.model.dto.TestDTO;
import com.xiacong.task.LocalTaskExample;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xiacong
 * @Classname TestController
 * @Version 1.0.0
 * @Date 2024/3/8 16:25
 * @Created by xiacong
 */
@RestController
public class TestController {
    @Resource
    private LocalTaskExample taskExample;
    @Resource
    private FlowEngine flowEngine;
    @Resource
    private IsShipOrderMapper isShipOrderMapper;

    @GetMapping("/hello")
    public String hello() throws Exception {
        taskExample.testMDC();
        return "hello";
    }

    @GetMapping("/appFlow/{flowId}")
    public String appFlow(@PathVariable String flowId) {
        ApplicationContent content = new ApplicationContent();
        content.setFlowId(flowId);
        ApplicationContent res = flowEngine.startFlow(content);
        return (String) res.getResponse();
    }

    @PostMapping("/vaild")
    public String test01(@RequestBody @Validated TestDTO dto) throws Exception {
        return "hello";
    }

    @GetMapping("/ship")
    @DS("slave")
    public List<IsShipOrder> ship() throws Exception {
        List<IsShipOrder> all = isShipOrderMapper.findAll();
        return all;
    }

}
