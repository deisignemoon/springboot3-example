package com.xiacong.cache.repository.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link VirtualTableDbRepositoryImpl}.
 */
@Generated
public class VirtualTableDbRepositoryImpl__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static VirtualTableDbRepositoryImpl apply(RegisteredBean registeredBean,
      VirtualTableDbRepositoryImpl instance) {
    ResourceElementResolver.forField("mapper").resolveAndSet(registeredBean, instance);
    ResourceElementResolver.forField("converter").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
