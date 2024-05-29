package com.xiacong.config;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link MyBeanFactoryPostProcessor}.
 */
@Generated
public class MyBeanFactoryPostProcessor__BeanDefinitions {
  /**
   * Get the bean definition for 'myBeanFactoryPostProcessor'.
   */
  public static BeanDefinition getMyBeanFactoryPostProcessorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MyBeanFactoryPostProcessor.class);
    beanDefinition.setInstanceSupplier(MyBeanFactoryPostProcessor::new);
    return beanDefinition;
  }
}
