package com.xiacong.cache.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link VirtualTableCacheManager}.
 */
@Generated
public class VirtualTableCacheManager__BeanDefinitions {
  /**
   * Get the bean definition for 'virtualTableCacheManager'.
   */
  public static BeanDefinition getVirtualTableCacheManagerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(VirtualTableCacheManager.class);
    InstanceSupplier<VirtualTableCacheManager> instanceSupplier = InstanceSupplier.using(VirtualTableCacheManager::new);
    instanceSupplier = instanceSupplier.andThen(VirtualTableCacheManager__ResourceAutowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
