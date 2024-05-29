package com.xiacong.cache.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link VirtualTableIndexCacheManager}.
 */
@Generated
public class VirtualTableIndexCacheManager__BeanDefinitions {
  /**
   * Get the bean definition for 'virtualTableIndexCacheManager'.
   */
  public static BeanDefinition getVirtualTableIndexCacheManagerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(VirtualTableIndexCacheManager.class);
    InstanceSupplier<VirtualTableIndexCacheManager> instanceSupplier = InstanceSupplier.using(VirtualTableIndexCacheManager::new);
    instanceSupplier = instanceSupplier.andThen(VirtualTableIndexCacheManager__ResourceAutowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
