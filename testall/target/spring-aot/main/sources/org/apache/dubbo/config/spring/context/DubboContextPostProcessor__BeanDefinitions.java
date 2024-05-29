package org.apache.dubbo.config.spring.context;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DubboContextPostProcessor}.
 */
@Generated
public class DubboContextPostProcessor__BeanDefinitions {
  /**
   * Get the bean definition for 'dubboContextPostProcessor'.
   */
  public static BeanDefinition getDubboContextPostProcessorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DubboContextPostProcessor.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(DubboContextPostProcessor::new);
    return beanDefinition;
  }
}
