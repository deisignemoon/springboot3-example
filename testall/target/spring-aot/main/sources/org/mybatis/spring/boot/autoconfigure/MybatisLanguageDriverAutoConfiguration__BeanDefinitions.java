package org.mybatis.spring.boot.autoconfigure;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link MybatisLanguageDriverAutoConfiguration}.
 */
@Generated
public class MybatisLanguageDriverAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'mybatisLanguageDriverAutoConfiguration'.
   */
  public static BeanDefinition getMybatisLanguageDriverAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MybatisLanguageDriverAutoConfiguration.class);
    beanDefinition.setTargetType(MybatisLanguageDriverAutoConfiguration.class);
    ConfigurationClassUtils.initializeConfigurationClass(MybatisLanguageDriverAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(MybatisLanguageDriverAutoConfiguration$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
