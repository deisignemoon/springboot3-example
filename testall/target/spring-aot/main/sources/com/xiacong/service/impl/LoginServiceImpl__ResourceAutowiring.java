package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link LoginServiceImpl}.
 */
@Generated
public class LoginServiceImpl__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static LoginServiceImpl apply(RegisteredBean registeredBean, LoginServiceImpl instance) {
    ResourceElementResolver.forField("authenticationProvider").resolveAndSet(registeredBean, instance);
    ResourceElementResolver.forField("jwtUtil").resolveAndSet(registeredBean, instance);
    ResourceElementResolver.forField("userInfoRedisUtil").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
