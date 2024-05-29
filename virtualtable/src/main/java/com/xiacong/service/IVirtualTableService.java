package com.xiacong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiacong.model.domain.VirtualTable;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 虚拟表定义表 服务类
 * </p>
 *
 * @author xiacong
 * @since 2023-10-19
 */
public interface IVirtualTableService extends IService<VirtualTable> {

    String getAll();

    VirtualTable getTableByName(String tableName);

    List<VirtualTable> getTablesByNames(Collection<String> tableNames);

}
