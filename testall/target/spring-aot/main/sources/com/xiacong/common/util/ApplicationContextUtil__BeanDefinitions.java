package com.xiacong.common.util;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ApplicationContextUtil}.
 */
@Generated
public class ApplicationContextUtil__BeanDefinitions {
  /**
   * Get the bean definition for 'applicationContextUtil'.
   */
  public static BeanDefinition getApplicationContextUtilBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ApplicationContextUtil.class);
    beanDefinition.setInstanceSupplier(ApplicationContextUtil::new);
    return beanDefinition;
  }
}
