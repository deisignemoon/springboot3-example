package org.apache.dubbo.config.spring.beans.factory.annotation;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ServicePackagesHolder}.
 */
@Generated
public class ServicePackagesHolder__BeanDefinitions {
  /**
   * Get the bean definition for 'dubboServicePackagesHolder'.
   */
  public static BeanDefinition getDubboServicePackagesHolderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ServicePackagesHolder.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(ServicePackagesHolder::new);
    return beanDefinition;
  }
}
