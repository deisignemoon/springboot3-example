package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link LoginServiceImpl}.
 */
@Generated
public class LoginServiceImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'loginServiceImpl'.
   */
  public static BeanDefinition getLoginServiceImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(LoginServiceImpl.class);
    InstanceSupplier<LoginServiceImpl> instanceSupplier = InstanceSupplier.using(LoginServiceImpl::new);
    instanceSupplier = instanceSupplier.andThen(LoginServiceImpl__ResourceAutowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
