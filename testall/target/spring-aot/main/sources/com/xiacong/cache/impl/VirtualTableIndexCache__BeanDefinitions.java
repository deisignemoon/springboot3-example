package com.xiacong.cache.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link VirtualTableIndexCache}.
 */
@Generated
public class VirtualTableIndexCache__BeanDefinitions {
  /**
   * Get the bean definition for 'virtualTableIndexCache'.
   */
  public static BeanDefinition getVirtualTableIndexCacheBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(VirtualTableIndexCache.class);
    beanDefinition.setInstanceSupplier(VirtualTableIndexCache::new);
    return beanDefinition;
  }
}
