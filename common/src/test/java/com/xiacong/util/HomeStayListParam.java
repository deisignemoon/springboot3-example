package com.xiacong.util;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class HomeStayListParam {
    //yyyy-MM-dd
    private String bgdate;
    //yyyy-MM-dd
    private String eddate;
    private int domainid;
    private int emp_id;
    private int type;
    private String sign;
    private String key;
    //yyyy-MM-dd hh:mm:ss
    private String timestamp;
}
