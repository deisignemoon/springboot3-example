package com.xiacong.cache.impl;

import com.xiacong.common.cache.Cache;
import com.xiacong.model.domain.VirtualTableColumns;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author xiacong
 * @Classname VirtualTableColumnsCache
 * @Version 1.0.0
 * @Date 2023/10/19 16:34
 * @Created by xiacong
 */
@Component
public class VirtualTableColumnsCache implements Cache<List<VirtualTableColumns>> {

    private Map<String, List<VirtualTableColumns>> tableNameMap = new ConcurrentHashMap<>();

    @Override
    public List<VirtualTableColumns> get(String key) {
        return tableNameMap.get(key);
    }

    @Override
    public Boolean add(String key, List<VirtualTableColumns> value) {
        tableNameMap.put(key, value);
        return true;
    }

    public Boolean add(String key, VirtualTableColumns value) {
        if (!tableNameMap.containsKey(key)) {
            List<VirtualTableColumns> list = new ArrayList<>();
            tableNameMap.put(key, list);
        }
        return tableNameMap.get(key).add(value);
    }

    @Override
    public List<VirtualTableColumns> remove(String key) {
        return tableNameMap.remove(key);
    }

    @Override
    public Boolean update(String key, List<VirtualTableColumns> value) {
        if (tableNameMap.containsKey(key)) {
            List<VirtualTableColumns> virtualTableColumns = tableNameMap.get(key);
            virtualTableColumns.addAll(value);
            value = virtualTableColumns.stream()
                    .sorted(Comparator.comparingInt(VirtualTableColumns::getSort))
                    .collect(Collectors.toList());
        }
        tableNameMap.put(key, value);
        return true;
    }

    @Override
    public Boolean removeAll() {
        tableNameMap.clear();
        return true;
    }

    @Override
    public String getKey(List<VirtualTableColumns> obj) {
        return obj.get(0).getTableName();
    }

    public List<String> getIndexColumns(List<VirtualTableColumns> list) {
        List<String> res = new ArrayList<>();
        for (VirtualTableColumns virtualTableColumn : list) {
            if (StringUtils.equals(virtualTableColumn.getKeySts(), "0")) {
                String columnName = virtualTableColumn.getColumnName();
                res.add(columnName);
            }
        }
        return res;
    }
}