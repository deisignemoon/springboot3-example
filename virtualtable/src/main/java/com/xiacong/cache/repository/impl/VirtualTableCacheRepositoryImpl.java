package com.xiacong.cache.repository.impl;

import com.xiacong.cache.converter.VirtualTableConverter;
import com.xiacong.cache.impl.VirtualTableCache;
import com.xiacong.cache.repository.VirtualTableRepository;
import com.xiacong.model.aggreate.VirtualTableAggreate;
import com.xiacong.model.domain.VirtualTable;
import jakarta.annotation.Resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author xiacong
 * @Classname VirtualTableRepositoryImpl
 * @Version 1.0.0
 * @Date 2024/4/17 10:48
 * @Created by xiacong
 */
//@Component
public class VirtualTableCacheRepositoryImpl implements VirtualTableRepository {
    @Resource
    private VirtualTableCache virtualTableCache;
    @Resource
    private VirtualTableConverter converter;

    @Override
    public VirtualTableAggreate find(String id) {
        VirtualTable virtualTable = virtualTableCache.get(id);
        return converter.tableDoToTableAggreate(virtualTable);
    }

    @Override
    public void remove(VirtualTableAggreate aggregate) {
        String tableName = aggregate.getTableName();
        virtualTableCache.remove(tableName);
    }

    @Override
    public void save(VirtualTableAggreate aggregate) {
        VirtualTable table = converter.tableAggreateToTableDo(aggregate);
        String tableName = table.getTableName();
        VirtualTable virtualTable = virtualTableCache.get(tableName);
        if (virtualTable == null) {
            virtualTableCache.add(tableName, table);
        } else {
            virtualTableCache.update(tableName, table);
        }
    }

    @Override
    public List<VirtualTableAggreate> getAllTable() {
        Map<String, VirtualTable> tableNameMap = virtualTableCache.getTableNameMap();
        Collection<VirtualTable> values = tableNameMap.values();
        return converter.tableDosToTableAggregates(values);
    }

    @Override
    public VirtualTable getTableByName(String tableName) {
        return virtualTableCache.get(tableName);
    }

    @Override
    public List<VirtualTable> getTablesByNames(Collection<String> tableNames) {
        List<VirtualTable> res = new ArrayList<>();
        for (String tableName : tableNames) {
            VirtualTable virtualTable = virtualTableCache.get(tableName);
            if (virtualTable != null) {
                res.add(virtualTable);
            }
        }
        return res;
    }
}
