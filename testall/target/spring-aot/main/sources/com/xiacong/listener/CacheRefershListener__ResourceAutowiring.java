package com.xiacong.listener;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link CacheRefershListener}.
 */
@Generated
public class CacheRefershListener__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static CacheRefershListener apply(RegisteredBean registeredBean,
      CacheRefershListener instance) {
    ResourceElementResolver.forField("cacheManagerRegister").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
