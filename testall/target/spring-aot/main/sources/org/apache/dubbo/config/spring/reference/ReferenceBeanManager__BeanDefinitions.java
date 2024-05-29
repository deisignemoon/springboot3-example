package org.apache.dubbo.config.spring.reference;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ReferenceBeanManager}.
 */
@Generated
public class ReferenceBeanManager__BeanDefinitions {
  /**
   * Get the bean definition for 'dubboReferenceBeanManager'.
   */
  public static BeanDefinition getDubboReferenceBeanManagerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ReferenceBeanManager.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(ReferenceBeanManager::new);
    return beanDefinition;
  }
}
