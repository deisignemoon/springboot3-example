package com.xiacong.handler;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link JwtLogoutSuccessHandler}.
 */
@Generated
public class JwtLogoutSuccessHandler__BeanDefinitions {
  /**
   * Get the bean definition for 'jwtLogoutSuccessHandler'.
   */
  public static BeanDefinition getJwtLogoutSuccessHandlerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JwtLogoutSuccessHandler.class);
    InstanceSupplier<JwtLogoutSuccessHandler> instanceSupplier = InstanceSupplier.using(JwtLogoutSuccessHandler::new);
    instanceSupplier = instanceSupplier.andThen(JwtLogoutSuccessHandler__ResourceAutowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
