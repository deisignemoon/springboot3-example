package com.xiacong.cache.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link VirtualTableIndexCacheManager}.
 */
@Generated
public class VirtualTableIndexCacheManager__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static VirtualTableIndexCacheManager apply(RegisteredBean registeredBean,
      VirtualTableIndexCacheManager instance) {
    ResourceElementResolver.forField("virtualTableIndexCache").resolveAndSet(registeredBean, instance);
    ResourceElementResolver.forField("virtualTableIndexMapper").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
