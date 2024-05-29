package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link SysUsrGroupServiceImpl}.
 */
@Generated
public class SysUsrGroupServiceImpl__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static SysUsrGroupServiceImpl apply(RegisteredBean registeredBean,
      SysUsrGroupServiceImpl instance) {
    ResourceElementResolver.forField("mapper").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
