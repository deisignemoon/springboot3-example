package com.xiacong.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiacong.model.domain.IsShipOrder;

import java.util.List;

/**
 *
 *
 * @author xiacong
 * @Classname IsShipOrderMapper
 * @Version 1.0.0
 * @Date 2025/1/22 16:17
 * @Created by xiacong
 */
public interface IsShipOrderMapper extends BaseMapper<IsShipOrder> {

    List<IsShipOrder> findAll();
}
