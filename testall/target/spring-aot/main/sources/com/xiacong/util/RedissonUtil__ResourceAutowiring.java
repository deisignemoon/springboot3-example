package com.xiacong.util;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link RedissonUtil}.
 */
@Generated
public class RedissonUtil__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static RedissonUtil apply(RegisteredBean registeredBean, RedissonUtil instance) {
    ResourceElementResolver.forField("redisson").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
