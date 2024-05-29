package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link SysRolePermissionServiceImpl}.
 */
@Generated
public class SysRolePermissionServiceImpl__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static SysRolePermissionServiceImpl apply(RegisteredBean registeredBean,
      SysRolePermissionServiceImpl instance) {
    ResourceElementResolver.forField("mapper").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
