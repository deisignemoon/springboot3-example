package com.xiacong.cache.converter;

import com.xiacong.model.aggreate.VirtualTableAggreate;
import com.xiacong.model.domain.VirtualTable;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiacong
 * @Classname VirtualTableConverter
 * @Version 1.0.0
 * @Date 2024/4/17 10:50
 * @Created by xiacong
 */
@Component
public class VirtualTableConverter {
    public VirtualTableAggreate tableDoToTableAggreate(VirtualTable virtualTable) {
        if (virtualTable == null) {
            return null;
        }
        VirtualTableAggreate virtualTableAggreate = new VirtualTableAggreate();
        BeanUtils.copyProperties(virtualTable, virtualTableAggreate);
        return virtualTableAggreate;
    }

    public VirtualTable tableAggreateToTableDo(VirtualTableAggreate aggregate) {
        if (aggregate == null) {
            return null;
        }
        VirtualTable table = new VirtualTable();
        BeanUtils.copyProperties(aggregate, table);
        return table;
    }

    public List<VirtualTableAggreate> tableDosToTableAggregates(Collection<VirtualTable> list) {
        if (CollectionUtils.isEmpty(list)) {
            return new ArrayList<>();
        }
        return list.stream().map(this::tableDoToTableAggreate).collect(Collectors.toList());
    }
}
