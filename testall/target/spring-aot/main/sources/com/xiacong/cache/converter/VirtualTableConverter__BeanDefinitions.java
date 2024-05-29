package com.xiacong.cache.converter;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link VirtualTableConverter}.
 */
@Generated
public class VirtualTableConverter__BeanDefinitions {
  /**
   * Get the bean definition for 'virtualTableConverter'.
   */
  public static BeanDefinition getVirtualTableConverterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(VirtualTableConverter.class);
    beanDefinition.setInstanceSupplier(VirtualTableConverter::new);
    return beanDefinition;
  }
}
