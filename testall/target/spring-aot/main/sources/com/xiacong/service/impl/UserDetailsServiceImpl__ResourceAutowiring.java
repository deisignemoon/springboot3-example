package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link UserDetailsServiceImpl}.
 */
@Generated
public class UserDetailsServiceImpl__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static UserDetailsServiceImpl apply(RegisteredBean registeredBean,
      UserDetailsServiceImpl instance) {
    ResourceElementResolver.forField("usrService").resolveAndSet(registeredBean, instance);
    ResourceElementResolver.forField("groupService").resolveAndSet(registeredBean, instance);
    ResourceElementResolver.forField("roleService").resolveAndSet(registeredBean, instance);
    ResourceElementResolver.forField("permissionService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
