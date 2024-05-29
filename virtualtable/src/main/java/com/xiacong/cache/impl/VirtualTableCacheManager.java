package com.xiacong.cache.impl;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xiacong.common.cache.AbstractCacheManager;
import com.xiacong.mapper.VirtualTableMapper;
import com.xiacong.model.domain.VirtualTable;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xiacong
 * @Classname VirtualTableCacheManager
 * @Version 1.0.0
 * @Date 2023/10/19 16:07
 * @Created by xiacong
 */
@Component
@Slf4j
public class VirtualTableCacheManager extends AbstractCacheManager<VirtualTable> {

    @Resource
    private VirtualTableMapper virtualTableMapper;

    @Resource
    private VirtualTableCache virtualTableCache;

    @Override
    public void init() {
        List<VirtualTable> virtualTables = findAll();
        for (VirtualTable virtualTable : virtualTables) {
            log.debug(JSONObject.toJSONString(virtualTable));
            virtualTableCache.add(virtualTable.getTableName(), virtualTable);
        }
    }

    @Override
    public List<VirtualTable> findAll() {
        LambdaQueryWrapper<VirtualTable> wrapper = new LambdaQueryWrapper<>();
        return virtualTableMapper.selectList(wrapper);
    }

    @Override
    public void clear() {
        virtualTableCache.removeAll();
    }
}
