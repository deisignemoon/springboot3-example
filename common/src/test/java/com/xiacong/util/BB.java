package com.xiacong.util;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 *
 *
 * @author xiacong
 * @Classname BB
 * @Version 1.0.0
 * @Date 2024/8/13 17:17
 * @Created by xiacong
 */
@Data
public class BB {
    @JSONField(name = "Bookname")
    private String Bookname;
    private String Price;
}
