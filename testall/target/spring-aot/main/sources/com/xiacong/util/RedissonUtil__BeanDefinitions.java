package com.xiacong.util;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link RedissonUtil}.
 */
@Generated
public class RedissonUtil__BeanDefinitions {
  /**
   * Get the bean definition for 'redissonUtil'.
   */
  public static BeanDefinition getRedissonUtilBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RedissonUtil.class);
    InstanceSupplier<RedissonUtil> instanceSupplier = InstanceSupplier.using(RedissonUtil::new);
    instanceSupplier = instanceSupplier.andThen(RedissonUtil__ResourceAutowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
