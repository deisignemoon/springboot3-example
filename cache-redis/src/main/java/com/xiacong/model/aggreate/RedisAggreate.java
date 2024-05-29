package com.xiacong.model.aggreate;

import com.xiacong.common.repository.Aggregate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author xiacong
 * @Classname RedisAggreate
 * @Version 1.0.0
 * @Date 2024/4/19 10:20
 * @Created by xiacong
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RedisAggreate<T> implements Aggregate {
    private static final long serialVersionUID = 1L;


    private String key;

    private T value;
}
