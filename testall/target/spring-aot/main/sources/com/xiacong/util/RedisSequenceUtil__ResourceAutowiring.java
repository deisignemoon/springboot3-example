package com.xiacong.util;

import com.xiacong.repository.RedisRepostory;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link RedisSequenceUtil}.
 */
@Generated
public class RedisSequenceUtil__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static RedisSequenceUtil apply(RegisteredBean registeredBean, RedisSequenceUtil instance) {
    instance.setRedisRepostory(ResourceElementResolver.forMethod("setRedisRepostory", RedisRepostory.class).resolve(registeredBean));
    return instance;
  }
}
