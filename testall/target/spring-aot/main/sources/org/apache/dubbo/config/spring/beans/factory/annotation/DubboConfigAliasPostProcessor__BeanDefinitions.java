package org.apache.dubbo.config.spring.beans.factory.annotation;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DubboConfigAliasPostProcessor}.
 */
@Generated
public class DubboConfigAliasPostProcessor__BeanDefinitions {
  /**
   * Get the bean definition for 'dubboConfigAliasPostProcessor'.
   */
  public static BeanDefinition getDubboConfigAliasPostProcessorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DubboConfigAliasPostProcessor.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(DubboConfigAliasPostProcessor::new);
    return beanDefinition;
  }
}
