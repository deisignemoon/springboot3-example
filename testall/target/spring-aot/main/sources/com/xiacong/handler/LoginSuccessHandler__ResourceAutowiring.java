package com.xiacong.handler;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link LoginSuccessHandler}.
 */
@Generated
public class LoginSuccessHandler__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static LoginSuccessHandler apply(RegisteredBean registeredBean,
      LoginSuccessHandler instance) {
    ResourceElementResolver.forField("jwtUtil").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
