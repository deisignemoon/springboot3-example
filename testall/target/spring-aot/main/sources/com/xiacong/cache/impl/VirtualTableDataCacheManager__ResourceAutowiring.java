package com.xiacong.cache.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link VirtualTableDataCacheManager}.
 */
@Generated
public class VirtualTableDataCacheManager__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static VirtualTableDataCacheManager apply(RegisteredBean registeredBean,
      VirtualTableDataCacheManager instance) {
    ResourceElementResolver.forField("virtualTableDataMapper").resolveAndSet(registeredBean, instance);
    ResourceElementResolver.forField("virtualTableDataCache").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
