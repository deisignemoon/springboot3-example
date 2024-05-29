package org.flowable.spring.boot;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link FlowableHttpProperties}.
 */
@Generated
public class FlowableHttpProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'flowableHttpProperties'.
   */
  public static BeanDefinition getFlowableHttpPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FlowableHttpProperties.class);
    beanDefinition.setInstanceSupplier(FlowableHttpProperties::new);
    return beanDefinition;
  }
}
