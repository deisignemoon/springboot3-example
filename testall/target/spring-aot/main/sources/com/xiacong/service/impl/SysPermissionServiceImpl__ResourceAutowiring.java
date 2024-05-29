package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link SysPermissionServiceImpl}.
 */
@Generated
public class SysPermissionServiceImpl__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static SysPermissionServiceImpl apply(RegisteredBean registeredBean,
      SysPermissionServiceImpl instance) {
    ResourceElementResolver.forField("rolePermissionService").resolveAndSet(registeredBean, instance);
    ResourceElementResolver.forField("mapper").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
