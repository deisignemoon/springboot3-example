package com.xiacong.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link VirtualTableController}.
 */
@Generated
public class VirtualTableController__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static VirtualTableController apply(RegisteredBean registeredBean,
      VirtualTableController instance) {
    ResourceElementResolver.forField("virtualTableService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
