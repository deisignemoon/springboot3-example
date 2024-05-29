package com.xiacong.cache.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xiacong.common.cache.AbstractCacheManager;
import com.xiacong.mapper.VirtualTableColumnsMapper;
import com.xiacong.model.domain.VirtualTableColumns;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xiacong
 * @Classname VirtualTableColumnsCacheManager
 * @Version 1.0.0
 * @Date 2023/10/19 16:36
 * @Created by xiacong
 */
@Component
@Slf4j
public class VirtualTableColumnsCacheManager extends AbstractCacheManager<VirtualTableColumns> {

    @Resource
    private VirtualTableColumnsMapper virtualTableColumnsMapper;

    @Resource
    private VirtualTableColumnsCache virtualTableColumnsCache;

    @Override
    public void init() {
        List<VirtualTableColumns> all = findAll();
        for (VirtualTableColumns columns : all) {
            virtualTableColumnsCache.add(columns.getTableName(), columns);
        }
    }

    @Override
    public List<VirtualTableColumns> findAll() {
        LambdaQueryWrapper<VirtualTableColumns> wrapper = new LambdaQueryWrapper<>();
        return virtualTableColumnsMapper.selectList(wrapper);
    }

    @Override
    public void clear() {
        virtualTableColumnsCache.removeAll();
    }
}
