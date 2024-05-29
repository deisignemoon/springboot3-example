package com.xiacong.cache.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link VirtualTableCache}.
 */
@Generated
public class VirtualTableCache__BeanDefinitions {
  /**
   * Get the bean definition for 'virtualTableCache'.
   */
  public static BeanDefinition getVirtualTableCacheBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(VirtualTableCache.class);
    beanDefinition.setInstanceSupplier(VirtualTableCache::new);
    return beanDefinition;
  }
}
