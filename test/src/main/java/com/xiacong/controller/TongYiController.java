package com.xiacong.controller;

import com.xiacong.model.TestModelDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TongYi models Spring Cloud Alibaba Controller.
 *
 * @author yuluo
 * @author <a href="mailto:yuluo08290126@gmail.com">yuluo</a>
 * @since 2023.0.0.0
 */

@RestController
@RequestMapping("/test")
@Slf4j
public class TongYiController {

    @PostMapping("/t1")
    public String t1(@RequestBody @Validated String message) {
        log.info("message:{}", message);
        return message;
    }

    @PostMapping("/t2")
    public String t2(@RequestBody TestModelDTO dto) {
        log.info("message:{}", dto.getContent());
        return dto.getContent();
    }
}