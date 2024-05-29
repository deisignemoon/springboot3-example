package com.xiacong.common.exception;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link RestExceptionHandler}.
 */
@Generated
public class RestExceptionHandler__BeanDefinitions {
  /**
   * Get the bean definition for 'restExceptionHandler'.
   */
  public static BeanDefinition getRestExceptionHandlerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RestExceptionHandler.class);
    beanDefinition.setTargetType(RestExceptionHandler.class);
    ConfigurationClassUtils.initializeConfigurationClass(RestExceptionHandler.class);
    beanDefinition.setInstanceSupplier(RestExceptionHandler$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
