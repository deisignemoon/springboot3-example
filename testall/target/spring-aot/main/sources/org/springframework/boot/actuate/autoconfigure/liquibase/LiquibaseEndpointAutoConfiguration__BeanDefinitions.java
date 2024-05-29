package org.springframework.boot.actuate.autoconfigure.liquibase;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link LiquibaseEndpointAutoConfiguration}.
 */
@Generated
public class LiquibaseEndpointAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'liquibaseEndpointAutoConfiguration'.
   */
  public static BeanDefinition getLiquibaseEndpointAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(LiquibaseEndpointAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(LiquibaseEndpointAutoConfiguration::new);
    return beanDefinition;
  }
}
