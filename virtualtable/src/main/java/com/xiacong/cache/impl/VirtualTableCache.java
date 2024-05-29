package com.xiacong.cache.impl;

import com.xiacong.common.cache.Cache;
import com.xiacong.model.domain.VirtualTable;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiacong
 * @Classname VirtualTableCache
 * @Version 1.0.0
 * @Date 2023/10/19 16:08
 * @Created by xiacong
 */
@Component
@Data
public class VirtualTableCache implements Cache<VirtualTable> {

    private Map<String, VirtualTable> tableNameMap = new ConcurrentHashMap<String, VirtualTable>();

    @Override
    public VirtualTable get(String key) {
        return tableNameMap.get(key);
    }

    @Override
    public Boolean add(String key, VirtualTable value) {
        tableNameMap.put(key, value);
        return true;
    }

    @Override
    public VirtualTable remove(String key) {
        return tableNameMap.remove(key);
    }

    @Override
    public Boolean update(String key, VirtualTable value) {
        tableNameMap.put(key, value);
        return true;
    }

    @Override
    public Boolean removeAll() {
        tableNameMap.clear();
        return true;
    }

    @Override
    public String getKey(VirtualTable obj) {
        return obj.getTableName();
    }
}
