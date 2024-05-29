package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link SysGroupRoleServiceImpl}.
 */
@Generated
public class SysGroupRoleServiceImpl__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static SysGroupRoleServiceImpl apply(RegisteredBean registeredBean,
      SysGroupRoleServiceImpl instance) {
    ResourceElementResolver.forField("mapper").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
