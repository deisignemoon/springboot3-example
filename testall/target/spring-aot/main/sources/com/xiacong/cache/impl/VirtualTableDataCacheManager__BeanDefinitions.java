package com.xiacong.cache.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link VirtualTableDataCacheManager}.
 */
@Generated
public class VirtualTableDataCacheManager__BeanDefinitions {
  /**
   * Get the bean definition for 'virtualTableDataCacheManager'.
   */
  public static BeanDefinition getVirtualTableDataCacheManagerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(VirtualTableDataCacheManager.class);
    InstanceSupplier<VirtualTableDataCacheManager> instanceSupplier = InstanceSupplier.using(VirtualTableDataCacheManager::new);
    instanceSupplier = instanceSupplier.andThen(VirtualTableDataCacheManager__ResourceAutowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
