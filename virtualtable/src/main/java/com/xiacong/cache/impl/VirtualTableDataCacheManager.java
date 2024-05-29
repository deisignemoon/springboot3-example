package com.xiacong.cache.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xiacong.common.cache.AbstractCacheManager;
import com.xiacong.mapper.VirtualTableDataMapper;
import com.xiacong.model.domain.VirtualTableData;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xiacong
 * @Classname VirtualTableDataCacheManager
 * @Version 1.0.0
 * @Date 2023/10/19 16:37
 * @Created by xiacong
 */
@Component
@Slf4j
public class VirtualTableDataCacheManager extends AbstractCacheManager<VirtualTableData> {

    @Resource
    private VirtualTableDataMapper virtualTableDataMapper;

    @Resource
    private VirtualTableDataCache virtualTableDataCache;

    @Override
    public void init() {
        List<VirtualTableData> all = findAll();
        for (VirtualTableData virtualTableData : all) {
            virtualTableDataCache.add(virtualTableData.getPkValue(), virtualTableData);
        }
    }

    @Override
    public List<VirtualTableData> findAll() {
        LambdaQueryWrapper<VirtualTableData> wrapper = new LambdaQueryWrapper<>();
        return virtualTableDataMapper.selectList(wrapper);
    }

    @Override
    public void clear() {
        virtualTableDataCache.removeAll();
    }
}
