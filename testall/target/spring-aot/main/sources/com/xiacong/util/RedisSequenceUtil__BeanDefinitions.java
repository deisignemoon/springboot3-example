package com.xiacong.util;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link RedisSequenceUtil}.
 */
@Generated
public class RedisSequenceUtil__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'redisSequenceUtil'.
   */
  private static BeanInstanceSupplier<RedisSequenceUtil> getRedisSequenceUtilInstanceSupplier() {
    return BeanInstanceSupplier.<RedisSequenceUtil>forConstructor();
  }

  /**
   * Get the bean definition for 'redisSequenceUtil'.
   */
  public static BeanDefinition getRedisSequenceUtilBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RedisSequenceUtil.class);
    InstanceSupplier<RedisSequenceUtil> instanceSupplier = getRedisSequenceUtilInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(RedisSequenceUtil__ResourceAutowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
