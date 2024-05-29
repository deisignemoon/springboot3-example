package com.xiacong.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiacong.cache.repository.VirtualTableRepository;
import com.xiacong.mapper.VirtualTableMapper;
import com.xiacong.model.aggreate.VirtualTableAggreate;
import com.xiacong.model.domain.VirtualTable;
import com.xiacong.service.IVirtualTableService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 虚拟表定义表 服务实现类
 * </p>
 *
 * @author xiacong
 * @since 2023-10-19
 */
@Service
public class VirtualTableServiceImpl extends ServiceImpl<VirtualTableMapper, VirtualTable> implements IVirtualTableService {

    @Resource
    private VirtualTableRepository repository;

    @Override
    public String getAll() {
        List<VirtualTableAggreate> allTable = repository.getAllTable();
        return JSONObject.toJSONString(allTable);
    }

    @Override
    public VirtualTable getTableByName(String tableName) {
        return repository.getTableByName(tableName);
    }

    @Override
    public List<VirtualTable> getTablesByNames(Collection<String> tableNames) {
        return repository.getTablesByNames(tableNames);
    }
}
