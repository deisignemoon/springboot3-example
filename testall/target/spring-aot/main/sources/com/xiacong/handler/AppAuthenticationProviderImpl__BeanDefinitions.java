package com.xiacong.handler;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AppAuthenticationProviderImpl}.
 */
@Generated
public class AppAuthenticationProviderImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'appAuthenticationProviderImpl'.
   */
  public static BeanDefinition getAppAuthenticationProviderImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AppAuthenticationProviderImpl.class);
    InstanceSupplier<AppAuthenticationProviderImpl> instanceSupplier = InstanceSupplier.using(AppAuthenticationProviderImpl::new);
    instanceSupplier = instanceSupplier.andThen(AppAuthenticationProviderImpl__ResourceAutowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
