package org.flowable.spring.boot.process;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link FlowableProcessProperties}.
 */
@Generated
public class FlowableProcessProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'flowableProcessProperties'.
   */
  public static BeanDefinition getFlowableProcessPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FlowableProcessProperties.class);
    beanDefinition.setInstanceSupplier(FlowableProcessProperties::new);
    return beanDefinition;
  }
}
