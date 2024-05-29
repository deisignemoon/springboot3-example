package com.xiacong.common.converter;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link RedissionConverter}.
 */
@Generated
public class RedissionConverter__BeanDefinitions {
  /**
   * Get the bean definition for 'redissionConverter'.
   */
  public static BeanDefinition getRedissionConverterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RedissionConverter.class);
    beanDefinition.setInstanceSupplier(RedissionConverter::new);
    return beanDefinition;
  }
}
