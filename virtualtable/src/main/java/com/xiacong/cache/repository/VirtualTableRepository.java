package com.xiacong.cache.repository;

import com.xiacong.common.repository.Repository;
import com.xiacong.model.aggreate.VirtualTableAggreate;
import com.xiacong.model.domain.VirtualTable;

import java.util.Collection;
import java.util.List;

/**
 * @author xiacong
 * @Classname VirtualTableRepository
 * @Version 1.0.0
 * @Date 2024/4/17 10:44
 * @Created by xiacong
 */
public interface VirtualTableRepository extends Repository<VirtualTableAggreate> {

    List<VirtualTableAggreate> getAllTable();

    VirtualTable getTableByName(String tableName);

    List<VirtualTable> getTablesByNames(Collection<String> tableNames);
}
