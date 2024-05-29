package com.xiacong.cache.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link VirtualTableColumnsCacheManager}.
 */
@Generated
public class VirtualTableColumnsCacheManager__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static VirtualTableColumnsCacheManager apply(RegisteredBean registeredBean,
      VirtualTableColumnsCacheManager instance) {
    ResourceElementResolver.forField("virtualTableColumnsMapper").resolveAndSet(registeredBean, instance);
    ResourceElementResolver.forField("virtualTableColumnsCache").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
