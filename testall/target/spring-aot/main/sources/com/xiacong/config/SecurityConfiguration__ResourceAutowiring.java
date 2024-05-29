package com.xiacong.config;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link SecurityConfiguration}.
 */
@Generated
public class SecurityConfiguration__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static SecurityConfiguration apply(RegisteredBean registeredBean,
      SecurityConfiguration instance) {
    ResourceElementResolver.forField("jwtAuthenticationFilter").resolveAndSet(registeredBean, instance);
    ResourceElementResolver.forField("jwtLogoutSuccessHandler").resolveAndSet(registeredBean, instance);
    ResourceElementResolver.forField("jwtAccessDeniedHandler").resolveAndSet(registeredBean, instance);
    ResourceElementResolver.forField("loginSuccessHandler").resolveAndSet(registeredBean, instance);
    ResourceElementResolver.forField("loginFailureHandler").resolveAndSet(registeredBean, instance);
    ResourceElementResolver.forField("jwtAuthenticationEntryPoint").resolveAndSet(registeredBean, instance);
    ResourceElementResolver.forField("authenticationProvider").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
