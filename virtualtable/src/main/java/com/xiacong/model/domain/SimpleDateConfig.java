package com.xiacong.model.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author xiacong
 * @Classname SimpleDateConfig
 * @Version 1.0.0
 * @Date 2024/5/27 10:12
 * @Created by xiacong
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SimpleDateConfig  implements Serializable {

    private static final long serialVersionUID = 1L;

    private String beanName;
    private String colName;
    private String colMemo;
}
