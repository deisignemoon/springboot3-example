package com.xiacong.cache.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.xiacong.cache.converter.VirtualTableConverter;
import com.xiacong.cache.repository.VirtualTableRepository;
import com.xiacong.common.constant.CommonConstant;
import com.xiacong.mapper.VirtualTableMapper;
import com.xiacong.model.aggreate.VirtualTableAggreate;
import com.xiacong.model.domain.VirtualTable;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author xiacong
 * @Classname VirtualTableRepositoryImpl
 * @Version 1.0.0
 * @Date 2024/4/17 10:48
 * @Created by xiacong
 */
@Component
public class VirtualTableDbRepositoryImpl implements VirtualTableRepository {
    @Resource
    private VirtualTableMapper mapper;
    @Resource
    private VirtualTableConverter converter;
    @Override
    public VirtualTableAggreate find(String id) {
        VirtualTable table = getTableByName(id);
        return converter.tableDoToTableAggreate(table);
    }

    @Override
    public void remove(VirtualTableAggreate aggregate) {
        String tableName = aggregate.getTableName();
        LambdaUpdateWrapper<VirtualTable> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(VirtualTable::getTableName, tableName).set(VirtualTable::getDeleteSts, CommonConstant.DELETE_STS);
        mapper.update(wrapper);
    }

    @Override
    public void save(VirtualTableAggreate aggregate) {
        VirtualTable table= converter.tableAggreateToTableDo(aggregate);
        String tableName = table.getTableName();
        VirtualTable orgTable = getTableByName(tableName);
        if (orgTable == null) {
            mapper.insert(table);
        }else {
            mapper.update(table,new LambdaQueryWrapper<VirtualTable>().eq(VirtualTable::getTableName, tableName));
        }
    }

    @Override
    public VirtualTable getTableByName(String tableName){
        LambdaQueryWrapper<VirtualTable> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(VirtualTable::getTableName, tableName).eq(VirtualTable::getDeleteSts, CommonConstant.NO_DELETE_STS);
        List<VirtualTable> tables = mapper.selectList(wrapper);
        if (CollectionUtils.isEmpty(tables)) {
            return null;
        }
        return tables.get(0);
    }

    @Override
    public List<VirtualTable> getTablesByNames(Collection<String> tableNames) {
        LambdaQueryWrapper<VirtualTable> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(VirtualTable::getTableName, tableNames).eq(VirtualTable::getDeleteSts, CommonConstant.NO_DELETE_STS);
        List<VirtualTable> tables = mapper.selectList(wrapper);
        if (CollectionUtils.isEmpty(tables)) {
            return new ArrayList<>();
        }
        return tables;
    }

    @Override
    //@DS("master")
    public List<VirtualTableAggreate> getAllTable() {
        // 手动切换数据库数据源 DynamicDataSourceContextHolder push poll
        LambdaQueryWrapper<VirtualTable> wrapper = new LambdaQueryWrapper<>();
        List<VirtualTable> virtualTables = mapper.selectList(wrapper);
        return converter.tableDosToTableAggregates(virtualTables);
    }
}
