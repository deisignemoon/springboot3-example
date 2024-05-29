package org.apache.dubbo.config.spring.beans.factory.config;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DubboConfigDefaultPropertyValueBeanPostProcessor}.
 */
@Generated
public class DubboConfigDefaultPropertyValueBeanPostProcessor__BeanDefinitions {
  /**
   * Get the bean definition for 'dubboConfigDefaultPropertyValueBeanPostProcessor'.
   */
  public static BeanDefinition getDubboConfigDefaultPropertyValueBeanPostProcessorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DubboConfigDefaultPropertyValueBeanPostProcessor.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(DubboConfigDefaultPropertyValueBeanPostProcessor::new);
    return beanDefinition;
  }
}
