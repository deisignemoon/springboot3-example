package com.xiacong.cache.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CacheManagerRegister}.
 */
@Generated
public class CacheManagerRegister__BeanDefinitions {
  /**
   * Get the bean definition for 'cacheManagerRegister'.
   */
  public static BeanDefinition getCacheManagerRegisterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CacheManagerRegister.class);
    InstanceSupplier<CacheManagerRegister> instanceSupplier = InstanceSupplier.using(CacheManagerRegister::new);
    instanceSupplier = instanceSupplier.andThen(CacheManagerRegister__ResourceAutowiring::apply);
    instanceSupplier = instanceSupplier.andThen(CacheManagerRegister__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
