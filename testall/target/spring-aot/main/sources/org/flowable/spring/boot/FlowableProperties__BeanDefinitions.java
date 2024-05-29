package org.flowable.spring.boot;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link FlowableProperties}.
 */
@Generated
public class FlowableProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'flowableProperties'.
   */
  public static BeanDefinition getFlowablePropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FlowableProperties.class);
    beanDefinition.setInstanceSupplier(FlowableProperties::new);
    return beanDefinition;
  }
}
