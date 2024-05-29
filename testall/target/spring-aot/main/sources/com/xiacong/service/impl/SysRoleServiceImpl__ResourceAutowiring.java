package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link SysRoleServiceImpl}.
 */
@Generated
public class SysRoleServiceImpl__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static SysRoleServiceImpl apply(RegisteredBean registeredBean,
      SysRoleServiceImpl instance) {
    ResourceElementResolver.forField("groupRoleService").resolveAndSet(registeredBean, instance);
    ResourceElementResolver.forField("usrRoleService").resolveAndSet(registeredBean, instance);
    ResourceElementResolver.forField("mapper").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
