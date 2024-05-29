package com.xiacong.event;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * @author xiacong
 * @Classname VirtualTableCacheRefershFinishEvent
 * @Version 1.0.0
 * @Date 2024/5/28 14:40
 * @Created by xiacong
 */
public class VirtualTableCacheRefershFinishEvent extends ApplicationEvent {
    public VirtualTableCacheRefershFinishEvent(Object source) {
        super(source);
    }
}
