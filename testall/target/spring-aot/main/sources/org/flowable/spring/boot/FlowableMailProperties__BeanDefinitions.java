package org.flowable.spring.boot;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link FlowableMailProperties}.
 */
@Generated
public class FlowableMailProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'flowableMailProperties'.
   */
  public static BeanDefinition getFlowableMailPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FlowableMailProperties.class);
    beanDefinition.setInstanceSupplier(FlowableMailProperties::new);
    return beanDefinition;
  }
}
