package com.xiacong.provider;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TestProviderImpl}.
 */
@Generated
public class TestProviderImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'testProviderImpl'.
   */
  public static BeanDefinition getTestProviderImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TestProviderImpl.class);
    beanDefinition.setInstanceSupplier(TestProviderImpl::new);
    return beanDefinition;
  }
}
