
package com.xiacong.dubbo.filter;

import com.xiacong.common.constant.CommonConstant;
import com.xiacong.common.util.TraceIdUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;


/**
 * dubbo请求业务流水号处理过滤器
 *
 * @author xiacong
 */

@Activate(group = {CommonConstants.CONSUMER, CommonConstants.PROVIDER}, order = Integer.MAX_VALUE)
@Slf4j
public class RemoteTraceIdFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        //判断是消费者  还是 服务提供者
        if (RpcContext.getCurrentServiceContext().isConsumerSide()) {
            //消费者 将trace_id（业务流水号） set至上下文中
            RpcContext.getCurrentServiceContext().setAttachment(CommonConstant.TRACE_ID, TraceIdUtil.getTraceId());
        } else {
            //取出业务流水号
            String traceId = RpcContext.getCurrentServiceContext().getAttachment(CommonConstant.TRACE_ID);
            if (StringUtils.isEmpty(traceId)) {
                traceId = TraceIdUtil.createTraceId();
            }
            //slf4j 中设置了日志打印格式用作日志链路追踪
            TraceIdUtil.setTraceId(traceId);
        }
        try {
            return invoker.invoke(invocation);
        } finally {
            if (RpcContext.getCurrentServiceContext().isProviderSide()) {
                TraceIdUtil.removeTraceId();
            }
        }
    }
}
