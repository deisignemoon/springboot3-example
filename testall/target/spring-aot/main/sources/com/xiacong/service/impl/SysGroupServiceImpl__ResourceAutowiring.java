package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link SysGroupServiceImpl}.
 */
@Generated
public class SysGroupServiceImpl__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static SysGroupServiceImpl apply(RegisteredBean registeredBean,
      SysGroupServiceImpl instance) {
    ResourceElementResolver.forField("usrGroupService").resolveAndSet(registeredBean, instance);
    ResourceElementResolver.forField("groupRoleService").resolveAndSet(registeredBean, instance);
    ResourceElementResolver.forField("mapper").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
