package com.xiacong.cache.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link CacheManagerRegister}.
 */
@Generated
public class CacheManagerRegister__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static CacheManagerRegister apply(RegisteredBean registeredBean,
      CacheManagerRegister instance) {
    AutowiredFieldValueResolver.forRequiredField("refershCacheName").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
