package org.flowable.spring.boot;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link FlowableAutoDeploymentProperties}.
 */
@Generated
public class FlowableAutoDeploymentProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'flowableAutoDeploymentProperties'.
   */
  public static BeanDefinition getFlowableAutoDeploymentPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FlowableAutoDeploymentProperties.class);
    beanDefinition.setInstanceSupplier(FlowableAutoDeploymentProperties::new);
    return beanDefinition;
  }
}
