package org.apache.dubbo.config.spring.context;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DubboConfigBeanInitializer}.
 */
@Generated
public class DubboConfigBeanInitializer__BeanDefinitions {
  /**
   * Get the bean definition for 'dubboConfigBeanInitializer'.
   */
  public static BeanDefinition getDubboConfigBeanInitializerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DubboConfigBeanInitializer.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(DubboConfigBeanInitializer::new);
    return beanDefinition;
  }
}
