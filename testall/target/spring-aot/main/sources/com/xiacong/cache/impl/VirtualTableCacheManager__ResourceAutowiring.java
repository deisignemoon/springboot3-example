package com.xiacong.cache.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link VirtualTableCacheManager}.
 */
@Generated
public class VirtualTableCacheManager__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static VirtualTableCacheManager apply(RegisteredBean registeredBean,
      VirtualTableCacheManager instance) {
    ResourceElementResolver.forField("virtualTableMapper").resolveAndSet(registeredBean, instance);
    ResourceElementResolver.forField("virtualTableCache").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
