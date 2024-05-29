package org.flowable.spring.boot.eventregistry;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link FlowableEventRegistryProperties}.
 */
@Generated
public class FlowableEventRegistryProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'flowableEventRegistryProperties'.
   */
  public static BeanDefinition getFlowableEventRegistryPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FlowableEventRegistryProperties.class);
    beanDefinition.setInstanceSupplier(FlowableEventRegistryProperties::new);
    return beanDefinition;
  }
}
