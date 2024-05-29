package org.flowable.spring.boot.dmn;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link FlowableDmnProperties}.
 */
@Generated
public class FlowableDmnProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'flowableDmnProperties'.
   */
  public static BeanDefinition getFlowableDmnPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FlowableDmnProperties.class);
    beanDefinition.setInstanceSupplier(FlowableDmnProperties::new);
    return beanDefinition;
  }
}
