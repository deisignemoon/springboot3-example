package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link SysUsrRoleServiceImpl}.
 */
@Generated
public class SysUsrRoleServiceImpl__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static SysUsrRoleServiceImpl apply(RegisteredBean registeredBean,
      SysUsrRoleServiceImpl instance) {
    ResourceElementResolver.forField("mapper").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
