package com.xiacong.common.converter;

import com.xiacong.model.aggreate.RedisAggreate;
import org.springframework.stereotype.Component;

/**
 * @author xiacong
 * @Classname RedisConverter
 * @Version 1.0.0
 * @Date 2024/4/19 10:28
 * @Created by xiacong
 */
@Component
public class RedissionConverter {
    public RedisAggreate<Object> convert(String id, Object value) {
        RedisAggreate<Object> aggreate = new RedisAggreate<>();
        aggreate.setKey(id);
        aggreate.setValue(value);
        return aggreate;
    }
}
