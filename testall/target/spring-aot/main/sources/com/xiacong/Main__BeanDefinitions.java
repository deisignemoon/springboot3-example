package com.xiacong;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link Main}.
 */
@Generated
public class Main__BeanDefinitions {
  /**
   * Get the bean definition for 'main'.
   */
  public static BeanDefinition getMainBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(Main.class);
    beanDefinition.setTargetType(Main.class);
    ConfigurationClassUtils.initializeConfigurationClass(Main.class);
    beanDefinition.setInstanceSupplier(Main$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
