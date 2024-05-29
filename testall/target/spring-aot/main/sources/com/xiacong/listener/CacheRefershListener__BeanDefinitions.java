package com.xiacong.listener;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CacheRefershListener}.
 */
@Generated
public class CacheRefershListener__BeanDefinitions {
  /**
   * Get the bean definition for 'cacheRefershListener'.
   */
  public static BeanDefinition getCacheRefershListenerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CacheRefershListener.class);
    InstanceSupplier<CacheRefershListener> instanceSupplier = InstanceSupplier.using(CacheRefershListener::new);
    instanceSupplier = instanceSupplier.andThen(CacheRefershListener__ResourceAutowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
