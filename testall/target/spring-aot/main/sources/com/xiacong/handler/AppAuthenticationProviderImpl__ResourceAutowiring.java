package com.xiacong.handler;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link AppAuthenticationProviderImpl}.
 */
@Generated
public class AppAuthenticationProviderImpl__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static AppAuthenticationProviderImpl apply(RegisteredBean registeredBean,
      AppAuthenticationProviderImpl instance) {
    ResourceElementResolver.forField("userDetailsService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
