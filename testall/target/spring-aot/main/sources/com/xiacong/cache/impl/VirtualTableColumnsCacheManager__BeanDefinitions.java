package com.xiacong.cache.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link VirtualTableColumnsCacheManager}.
 */
@Generated
public class VirtualTableColumnsCacheManager__BeanDefinitions {
  /**
   * Get the bean definition for 'virtualTableColumnsCacheManager'.
   */
  public static BeanDefinition getVirtualTableColumnsCacheManagerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(VirtualTableColumnsCacheManager.class);
    InstanceSupplier<VirtualTableColumnsCacheManager> instanceSupplier = InstanceSupplier.using(VirtualTableColumnsCacheManager::new);
    instanceSupplier = instanceSupplier.andThen(VirtualTableColumnsCacheManager__ResourceAutowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
