package com.xiacong.controller;

import com.xiacong.service.TongYiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * TongYi models Spring Cloud Alibaba Controller.
 *
 * @author yuluo
 * @author <a href="mailto:yuluo08290126@gmail.com">yuluo</a>
 * @since 2023.0.0.0
 */

@RestController
@RequestMapping("/ai")
@CrossOrigin
public class TongYiController {

    @Autowired
    @Qualifier("tongYiSimpleServiceImpl")
    private TongYiService tongYiSimpleService;

    @GetMapping("/example")
    public String completion(
            @RequestParam(value = "message", defaultValue = "Tell me a joke")
            String message
    ) {
        return tongYiSimpleService.completion(message);
    }

    @GetMapping("/stream")
    public Map<String, String> streamCompletion(
            @RequestParam(value = "message", defaultValue = "请告诉我西红柿炖牛腩怎么做？")
            String message
    ) {

        return tongYiSimpleService.streamCompletion(message);
    }

}