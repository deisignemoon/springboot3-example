package com.xiacong.handler;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link LoginFailureHandler}.
 */
@Generated
public class LoginFailureHandler__BeanDefinitions {
  /**
   * Get the bean definition for 'loginFailureHandler'.
   */
  public static BeanDefinition getLoginFailureHandlerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(LoginFailureHandler.class);
    beanDefinition.setInstanceSupplier(LoginFailureHandler::new);
    return beanDefinition;
  }
}
