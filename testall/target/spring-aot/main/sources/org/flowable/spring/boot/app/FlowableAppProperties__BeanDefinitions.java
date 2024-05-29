package org.flowable.spring.boot.app;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link FlowableAppProperties}.
 */
@Generated
public class FlowableAppProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'flowableAppProperties'.
   */
  public static BeanDefinition getFlowableAppPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FlowableAppProperties.class);
    beanDefinition.setInstanceSupplier(FlowableAppProperties::new);
    return beanDefinition;
  }
}
