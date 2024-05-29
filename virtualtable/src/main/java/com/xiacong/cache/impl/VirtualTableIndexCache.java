package com.xiacong.cache.impl;

import com.xiacong.common.cache.Cache;
import com.xiacong.model.domain.VirtualTableIndex;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiacong
 * @Classname VirtualTableIndexCache
 * @Version 1.0.0
 * @Date 2023/10/19 16:38
 * @Created by xiacong
 */
@Component
public class VirtualTableIndexCache implements Cache<VirtualTableIndex> {

    private Map<String, Map<String, VirtualTableIndex>> indexMap = new ConcurrentHashMap<>();

    @Override
    public VirtualTableIndex get(String key) {
        return null;
    }

    public VirtualTableIndex get(String tableName, String key) {
        return indexMap.get(tableName).get(key);
    }

    @Override
    public Boolean add(String key, VirtualTableIndex value) {
        String tabelName = value.getTabelName();
        if (!indexMap.containsKey(tabelName)) {
            indexMap.put(tabelName, new ConcurrentHashMap<>());
        }
        indexMap.get(tabelName).put(key, value);
        return true;
    }

    @Override
    public VirtualTableIndex remove(String key) {
        return null;
    }

    @Override
    public Boolean update(String key, VirtualTableIndex value) {
        return add(key, value);
    }

    @Override
    public Boolean removeAll() {
        indexMap.clear();
        return true;
    }

    @Override
    public String getKey(VirtualTableIndex obj) {
        return obj.getIndexValue();
    }
}
