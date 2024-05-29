package com.xiacong.cache.impl;

import com.xiacong.common.cache.Cache;
import com.xiacong.model.domain.VirtualTableData;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiacong
 * @Classname VirtualTableDataCache
 * @Version 1.0.0
 * @Date 2023/10/19 16:37
 * @Created by xiacong
 */
@Component
public class VirtualTableDataCache implements Cache<VirtualTableData> {

    private Map<String, VirtualTableData> dataMap = new ConcurrentHashMap<>();
    private Map<String, Set<String>> tableMap = new ConcurrentHashMap<>();

    @Override
    public VirtualTableData get(String key) {
        return dataMap.get(key);
    }

    @Override
    public Boolean add(String key, VirtualTableData value) {
        dataMap.put(key, value);
        String tableName = value.getTableName();
        if (!tableMap.containsKey(tableName)) {
            tableMap.put(tableName,new HashSet<>());
        }
        tableMap.get(tableName).add(key);
        return true;
    }

    public List<VirtualTableData> findTableDatas(String tableName) {
        Set<String> keys = tableMap.get(tableName);
        List<VirtualTableData> list = new ArrayList<>();
        if (!CollectionUtils.isEmpty(keys)) {
            for (String key : keys) {
                VirtualTableData data = dataMap.get(key);
                if (data != null) {
                    list.add(data);
                }
            }
        }
        return list;
    }

    @Override
    public VirtualTableData remove(String key) {
        VirtualTableData data = dataMap.remove(key);
        if (data != null) {
            String tableName = data.getTableName();
            Set<String> keys = tableMap.get(tableName);
            if (keys != null) {
                keys.remove(key);
            }
        }
        return data;
    }

    @Override
    public Boolean update(String key, VirtualTableData value) {
        dataMap.put(key, value);
        return true;
    }

    @Override
    public Boolean removeAll() {
        dataMap.clear();
        tableMap.clear();
        return true;
    }

    @Override
    public String getKey(VirtualTableData obj) {
        return obj.getPkValue();
/*        List<VirtualTableColumns> virtualTableColumns = columnsCache.get(obj.getTableName());
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(obj);
        StringJoiner joiner = new StringJoiner(CommonConstant.AEPARATOR1);
        List<String> indexColumns = columnsCache.getIndexColumns(virtualTableColumns);
        if (CollectionUtils.isEmpty(indexColumns)) {
            return null;
        }
        for (String indexColumn : indexColumns) {
            String value = jsonObject.getString(indexColumn);
            joiner.add(value);
        }
        return indexCache.get(obj.getTableName(),joiner.toString()).getPkValue();*/
    }
}
