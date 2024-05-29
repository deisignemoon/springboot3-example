package org.apache.dubbo.config.spring.context;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DubboConfigApplicationListener}.
 */
@Generated
public class DubboConfigApplicationListener__BeanDefinitions {
  /**
   * Get the bean definition for 'dubboConfigApplicationListener'.
   */
  public static BeanDefinition getDubboConfigApplicationListenerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DubboConfigApplicationListener.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(DubboConfigApplicationListener::new);
    return beanDefinition;
  }
}
