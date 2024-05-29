package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link VirtualTableServiceImpl}.
 */
@Generated
public class VirtualTableServiceImpl__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static VirtualTableServiceImpl apply(RegisteredBean registeredBean,
      VirtualTableServiceImpl instance) {
    ResourceElementResolver.forField("repository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
