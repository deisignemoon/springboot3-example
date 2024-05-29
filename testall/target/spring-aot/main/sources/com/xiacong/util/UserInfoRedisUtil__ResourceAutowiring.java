package com.xiacong.util;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link UserInfoRedisUtil}.
 */
@Generated
public class UserInfoRedisUtil__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static UserInfoRedisUtil apply(RegisteredBean registeredBean, UserInfoRedisUtil instance) {
    ResourceElementResolver.forField("redissonUtil").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
