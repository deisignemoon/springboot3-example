package com.xiacong.handler;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link JwtAccessDeniedHandler}.
 */
@Generated
public class JwtAccessDeniedHandler__BeanDefinitions {
  /**
   * Get the bean definition for 'jwtAccessDeniedHandler'.
   */
  public static BeanDefinition getJwtAccessDeniedHandlerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JwtAccessDeniedHandler.class);
    beanDefinition.setInstanceSupplier(JwtAccessDeniedHandler::new);
    return beanDefinition;
  }
}
