package com.xiacong.task;

import cn.hutool.core.date.StopWatch;
import com.xiacong.util.CycleSeqNumUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/**
 * 本地任务示例
 *
 * @author xiacong
 * @Classname LocalTaskExample
 * @Version 1.0.0
 * @Date 2024/3/8 16:24
 * @Created by xiacong
 */
@Component
@Slf4j
public class LocalTaskExample {

    @Resource(name = "controlAsync")
    private Executor executor;
    @Resource
    private CycleSeqNumUtil cycleSeqNumUtil;

    public void testMDC() throws Exception {
        log.info("MDC OUT method has been called {}", Thread.currentThread());
        executor.execute(() -> {
            log.info("MDC IN method has been called {}", Thread.currentThread());
        });
        StopWatch stopWatch = StopWatch.create("");
        stopWatch.start();
        //@Async的代理对象并不是由自动代理创建器来创建的，而是由AsyncAnnotationBeanPostProcessor一个单纯的BeanPostProcessor实现的。
        //@Async要想顺利使用AopContext.currentProxy()获取当前代理对象来调用本类方法，需要确保你本Bean已经被自动代理创建器提前代理
        Future<String> stringFuture = ((LocalTaskExample) AopContext.currentProxy()).sayHello1();
        Future<String> stringFuture2 = ((LocalTaskExample) AopContext.currentProxy()).sayHello2();
        Future<String> stringFuture3 = ((LocalTaskExample) AopContext.currentProxy()).sayHello3();
        System.out.println(stringFuture.get() + "\n" + stringFuture2.get() + "\n" + stringFuture3.get());
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeSeconds());
    }

    @Async("controlAsync")
    public Future<String> sayHello1() throws InterruptedException {
        int thinking = 1;
        Thread.sleep(thinking * 2000);//网络连接中 。。。消息发送中。。。
        return new AsyncResult<String>("发送消息用了" + thinking + "秒");
    }

    @Async("controlAsync")
    public Future<String> sayHello2() throws InterruptedException {
        int thinking = 1;
        Thread.sleep(thinking * 1000);//网络连接中 。。。消息发送中。。。
        //int i=1/0;
        return new AsyncResult<String>("发送消息用了" + thinking + "秒");
    }

    @Async("controlAsync")
    public Future<String> sayHello3() throws InterruptedException {
        int thinking = 1;
        Thread.sleep(thinking * 5000);//网络连接中 。。。消息发送中。。。
        return new AsyncResult<String>("发送消息用了" + thinking + "秒");
    }


    /**
     * 虚拟线程
     */
    @Scheduled(cron = "0/1 * * * * ?")
    @Async("controlAsync")
    public void testMDC2() {
        String cycleSeqNum = cycleSeqNumUtil.getCycleSeqNum();
        log.info("序列号，{}",cycleSeqNum);
    }
}
