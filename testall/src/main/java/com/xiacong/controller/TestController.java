package com.xiacong.controller;


import com.xiacong.flow.FlowEngine;
import com.xiacong.flow.common.content.ApplicationContent;
import com.xiacong.task.LocalTaskExample;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

}
