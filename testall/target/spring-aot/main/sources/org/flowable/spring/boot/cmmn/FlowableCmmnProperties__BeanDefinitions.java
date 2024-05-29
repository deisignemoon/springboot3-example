package org.flowable.spring.boot.cmmn;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link FlowableCmmnProperties}.
 */
@Generated
public class FlowableCmmnProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'flowableCmmnProperties'.
   */
  public static BeanDefinition getFlowableCmmnPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FlowableCmmnProperties.class);
    beanDefinition.setInstanceSupplier(FlowableCmmnProperties::new);
    return beanDefinition;
  }
}
