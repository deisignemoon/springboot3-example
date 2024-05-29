package org.redisson.spring.starter;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link RedissonAutoConfigurationV2}.
 */
@Generated
public class RedissonAutoConfigurationV2__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static RedissonAutoConfigurationV2 apply(RegisteredBean registeredBean,
      RedissonAutoConfigurationV2 instance) {
    AutowiredFieldValueResolver.forField("redissonAutoConfigurationCustomizers").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("redissonProperties").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("redisProperties").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("ctx").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
