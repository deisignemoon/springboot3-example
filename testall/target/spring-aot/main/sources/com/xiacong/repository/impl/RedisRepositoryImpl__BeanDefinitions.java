package com.xiacong.repository.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link RedisRepositoryImpl}.
 */
@Generated
public class RedisRepositoryImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'redisRepositoryImpl'.
   */
  public static BeanDefinition getRedisRepositoryImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RedisRepositoryImpl.class);
    InstanceSupplier<RedisRepositoryImpl> instanceSupplier = InstanceSupplier.using(RedisRepositoryImpl::new);
    instanceSupplier = instanceSupplier.andThen(RedisRepositoryImpl__ResourceAutowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
