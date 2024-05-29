package com.xiacong.cache.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link VirtualTableColumnsCache}.
 */
@Generated
public class VirtualTableColumnsCache__BeanDefinitions {
  /**
   * Get the bean definition for 'virtualTableColumnsCache'.
   */
  public static BeanDefinition getVirtualTableColumnsCacheBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(VirtualTableColumnsCache.class);
    beanDefinition.setInstanceSupplier(VirtualTableColumnsCache::new);
    return beanDefinition;
  }
}
