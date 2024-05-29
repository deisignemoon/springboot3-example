package com.xiacong.handler;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link JwtLogoutSuccessHandler}.
 */
@Generated
public class JwtLogoutSuccessHandler__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static JwtLogoutSuccessHandler apply(RegisteredBean registeredBean,
      JwtLogoutSuccessHandler instance) {
    ResourceElementResolver.forField("userInfoRedisUtil").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
