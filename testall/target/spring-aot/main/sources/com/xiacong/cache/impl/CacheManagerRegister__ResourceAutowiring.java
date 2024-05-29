package com.xiacong.cache.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link CacheManagerRegister}.
 */
@Generated
public class CacheManagerRegister__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static CacheManagerRegister apply(RegisteredBean registeredBean,
      CacheManagerRegister instance) {
    ResourceElementResolver.forField("register").resolveAndSet(registeredBean, instance);
    ResourceElementResolver.forField("eventPublisher").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
