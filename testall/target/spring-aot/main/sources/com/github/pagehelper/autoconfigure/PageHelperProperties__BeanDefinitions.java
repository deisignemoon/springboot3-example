package com.github.pagehelper.autoconfigure;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link PageHelperProperties}.
 */
@Generated
public class PageHelperProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'pageHelperProperties'.
   */
  public static BeanDefinition getPageHelperPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PageHelperProperties.class);
    beanDefinition.setInstanceSupplier(PageHelperProperties::new);
    return beanDefinition;
  }
}
