package com.xiacong.repository.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link RedisRepositoryImpl}.
 */
@Generated
public class RedisRepositoryImpl__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static RedisRepositoryImpl apply(RegisteredBean registeredBean,
      RedisRepositoryImpl instance) {
    ResourceElementResolver.forField("redissonUtil").resolveAndSet(registeredBean, instance);
    ResourceElementResolver.forField("converter").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
