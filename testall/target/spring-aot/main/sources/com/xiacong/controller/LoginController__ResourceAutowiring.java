package com.xiacong.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link LoginController}.
 */
@Generated
public class LoginController__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static LoginController apply(RegisteredBean registeredBean, LoginController instance) {
    ResourceElementResolver.forField("loginService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
