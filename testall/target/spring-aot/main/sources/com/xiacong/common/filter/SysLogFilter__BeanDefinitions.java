package com.xiacong.common.filter;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SysLogFilter}.
 */
@Generated
public class SysLogFilter__BeanDefinitions {
  /**
   * Get the inner-bean definition for 'filter'.
   */
  public static BeanDefinition getFilterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SysLogFilter.class);
    beanDefinition.setInstanceSupplier(SysLogFilter::new);
    return beanDefinition;
  }
}
