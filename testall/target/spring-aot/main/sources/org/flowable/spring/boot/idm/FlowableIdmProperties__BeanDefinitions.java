package org.flowable.spring.boot.idm;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link FlowableIdmProperties}.
 */
@Generated
public class FlowableIdmProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'flowableIdmProperties'.
   */
  public static BeanDefinition getFlowableIdmPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FlowableIdmProperties.class);
    beanDefinition.setInstanceSupplier(FlowableIdmProperties::new);
    return beanDefinition;
  }
}
