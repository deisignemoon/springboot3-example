package org.apache.dubbo.config.spring.context;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DubboDeployApplicationListener}.
 */
@Generated
public class DubboDeployApplicationListener__BeanDefinitions {
  /**
   * Get the bean definition for 'dubboDeployApplicationListener'.
   */
  public static BeanDefinition getDubboDeployApplicationListenerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DubboDeployApplicationListener.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(DubboDeployApplicationListener::new);
    return beanDefinition;
  }
}
