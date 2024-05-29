package com.xiacong.cache.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xiacong.common.cache.AbstractCacheManager;
import com.xiacong.mapper.VirtualTableIndexMapper;
import com.xiacong.model.domain.VirtualTableIndex;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xiacong
 * @Classname VirtualTableIndexCacheManager
 * @Version 1.0.0
 * @Date 2023/10/19 16:38
 * @Created by xiacong
 */
@Component
@Slf4j
public class VirtualTableIndexCacheManager extends AbstractCacheManager<VirtualTableIndex> {

    @Resource
    private VirtualTableIndexCache virtualTableIndexCache;
    @Resource
    private VirtualTableIndexMapper virtualTableIndexMapper;

    @Override
    public void init() {
        List<VirtualTableIndex> all = findAll();
        for (VirtualTableIndex virtualTableIndex : all) {
            virtualTableIndexCache.add(virtualTableIndex.getIndexValue(), virtualTableIndex);
        }
    }

    @Override
    public List<VirtualTableIndex> findAll() {
        LambdaQueryWrapper<VirtualTableIndex> wrapper = new LambdaQueryWrapper<>();
        return virtualTableIndexMapper.selectList(wrapper);
    }

    @Override
    public void clear() {
        virtualTableIndexCache.removeAll();
    }
}
