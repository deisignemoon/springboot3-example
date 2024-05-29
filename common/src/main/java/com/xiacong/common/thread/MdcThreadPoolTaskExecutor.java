package com.xiacong.common.thread;

import com.xiacong.common.constant.CommonConstant;
import com.xiacong.common.util.TraceIdUtil;
import lombok.NonNull;
import org.slf4j.MDC;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * 异步线程池，带有MDC的那种
 *
 * @author zhangzhongqiu
 * @version 1.0
 * @since 2022/1/21
 */
public class MdcThreadPoolTaskExecutor extends ThreadPoolTaskExecutor {

    public MdcThreadPoolTaskExecutor() {
    }

    /**
     * @param corePoolSize
     * @param maxPoolSize
     * @param keepAliveTime
     * @param queueCapacity
     * @param poolNamePrefix
     */
    public MdcThreadPoolTaskExecutor(int corePoolSize, int maxPoolSize,
                                     int keepAliveTime, int queueCapacity, String poolNamePrefix) {
        setCorePoolSize(corePoolSize);
        setMaxPoolSize(maxPoolSize);
        setKeepAliveSeconds(keepAliveTime);
        setQueueCapacity(queueCapacity);
        setThreadNamePrefix(poolNamePrefix);
    }

    /**
     * @return
     */
    private Map<String, String> getContextForTask() {
        return MDC.getCopyOfContextMap();
    }

    /**
     * All executions will have MDC injected. {@code ThreadPoolExecutor}'s submission methods ({@code submit()} etc.)
     * all delegate to this.
     */
    @Override
    public void execute(@NonNull Runnable command) {
        super.execute(wrap(command, getContextForTask()));
    }

    @NonNull
    @Override
    public Future<?> submit(@NonNull Runnable task) {
        return super.submit(wrap(task, getContextForTask()));
    }

    @NonNull
    @Override
    public <T> Future<T> submit(@NonNull Callable<T> task) {
        return super.submit(wrap(task, getContextForTask()));
    }

    /**
     * @param task
     * @param context
     * @param <T>
     * @return
     */
    private static <T> Callable<T> wrap(final Callable<T> task, final Map<String, String> context) {
        return () -> {
            if (null != context) {
                if (!context.containsKey(CommonConstant.TRACE_ID)) {
                    context.put(CommonConstant.TRACE_ID, TraceIdUtil.getTraceId());
                }
                MDC.setContextMap(context);
            } else {
                TraceIdUtil.setTraceId();
            }

            try {
                return task.call();
            } finally {
                if (null != context && !context.isEmpty()) {
                    MDC.clear();
                }
            }
        };
    }

    /**
     * @param runnable
     * @param context
     * @return
     */
    private static Runnable wrap(final Runnable runnable, final Map<String, String> context) {
        return () -> {
            if (null != context) {
                if (!context.containsKey(CommonConstant.TRACE_ID)) {
                    context.put(CommonConstant.TRACE_ID, TraceIdUtil.getTraceId());
                }
                MDC.setContextMap(context);
            } else {
                TraceIdUtil.setTraceId();
            }

            try {
                runnable.run();
            } finally {
                if (null != context && !context.isEmpty()) {
                    MDC.clear();
                }
            }
        };
    }

}