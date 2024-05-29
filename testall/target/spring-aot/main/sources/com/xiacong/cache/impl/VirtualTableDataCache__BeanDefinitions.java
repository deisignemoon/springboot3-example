package com.xiacong.cache.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link VirtualTableDataCache}.
 */
@Generated
public class VirtualTableDataCache__BeanDefinitions {
  /**
   * Get the bean definition for 'virtualTableDataCache'.
   */
  public static BeanDefinition getVirtualTableDataCacheBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(VirtualTableDataCache.class);
    beanDefinition.setInstanceSupplier(VirtualTableDataCache::new);
    return beanDefinition;
  }
}
