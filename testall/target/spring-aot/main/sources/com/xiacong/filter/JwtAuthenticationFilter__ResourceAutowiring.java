package com.xiacong.filter;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link JwtAuthenticationFilter}.
 */
@Generated
public class JwtAuthenticationFilter__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static JwtAuthenticationFilter apply(RegisteredBean registeredBean,
      JwtAuthenticationFilter instance) {
    ResourceElementResolver.forField("userInfoRedisUtil").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
