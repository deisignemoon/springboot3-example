package com.xiacong.model.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 *
 *
 * @author xiacong
 * @Classname IsShipOrder
 * @Version 1.0.0
 * @Date 2025/1/22 16:18
 * @Created by xiacong
 */
@TableName(value ="book")
@Data
public class IsShipOrder {

    private Long id;

    private Long orderId;
}
