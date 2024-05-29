package com.xiacong.handler;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link LoginSuccessHandler}.
 */
@Generated
public class LoginSuccessHandler__BeanDefinitions {
  /**
   * Get the bean definition for 'loginSuccessHandler'.
   */
  public static BeanDefinition getLoginSuccessHandlerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(LoginSuccessHandler.class);
    InstanceSupplier<LoginSuccessHandler> instanceSupplier = InstanceSupplier.using(LoginSuccessHandler::new);
    instanceSupplier = instanceSupplier.andThen(LoginSuccessHandler__ResourceAutowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
