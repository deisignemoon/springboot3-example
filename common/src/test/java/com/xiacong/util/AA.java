package com.xiacong.util;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 *
 *
 * @author xiacong
 * @Classname AA
 * @Version 1.0.0
 * @Date 2024/8/13 17:17
 * @Created by xiacong
 */
@Data
public class AA {
    //@JSONField(name = "Name")
    private String Name;
    private String Age;
    //@JSONField(name = "Bb")
    private BB Bb;

    public AA() {
    }

    public AA(String name, String age, BB bb) {
        Name = name;
        Age = age;
        Bb = bb;
    }
}
