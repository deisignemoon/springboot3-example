package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link SysUsrServiceImpl}.
 */
@Generated
public class SysUsrServiceImpl__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static SysUsrServiceImpl apply(RegisteredBean registeredBean, SysUsrServiceImpl instance) {
    ResourceElementResolver.forField("mapper").resolveAndSet(registeredBean, instance);
    ResourceElementResolver.forField("usrGroupService").resolveAndSet(registeredBean, instance);
    ResourceElementResolver.forField("usrRoleService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
