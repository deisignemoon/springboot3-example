package com.xiacong.listener;

import com.xiacong.cache.impl.VirtualTableDataCache;
import com.xiacong.cache.impl.VirtualTableDataCacheManager;
import com.xiacong.event.VirtualTableCacheRefershFinishEvent;
import com.xiacong.flow.FlowFactory;
import com.xiacong.flow.model.domain.Flow;
import com.xiacong.flow.model.domain.NormalFlowNode;
import com.xiacong.model.domain.VirtualTableData;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.List;

/**
 * @author xiacong
 * @Classname NuoNuoConfig
 * @Version 1.0.0
 * @Date 2023/12/28 13:10
 * @Created by xiacong
 */
@Component
@Slf4j
public class FlowDataLoadListener {
    @Resource
    private FlowFactory flowFactory;
    @Resource
    private VirtualTableDataCache tableDataCache;

    @Async("controlAsync")
    @TransactionalEventListener(
            //监听事件
            classes = VirtualTableCacheRefershFinishEvent.class,
            //前置事务提交后执行
            phase = TransactionPhase.AFTER_COMMIT,
            //无事务同样执行
            fallbackExecution = true)
    public void init(VirtualTableCacheRefershFinishEvent event) {
        List<VirtualTableData> flowDatas = tableDataCache.findTableDatas("flow");
        List<VirtualTableData> flowNodeDatas = tableDataCache.findTableDatas("flowNode");
        for (VirtualTableData flowData : flowDatas) {
            Flow flow = flowFactory.initFlow(flowData.getFieldValue());
        }
        log.debug("缓存流程：{}",flowDatas.size());
        for (VirtualTableData flowNodeData : flowNodeDatas) {
            NormalFlowNode node = flowFactory.initFlowNode(flowNodeData.getFieldValue());
        }
        log.debug("缓存流程节点：{}",flowNodeDatas.size());
    }

}
