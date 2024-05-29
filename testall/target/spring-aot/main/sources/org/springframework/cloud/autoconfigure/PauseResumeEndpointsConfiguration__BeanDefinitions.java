package org.springframework.cloud.autoconfigure;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link PauseResumeEndpointsConfiguration}.
 */
@Generated
public class PauseResumeEndpointsConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'pauseResumeEndpointsConfiguration'.
   */
  public static BeanDefinition getPauseResumeEndpointsConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PauseResumeEndpointsConfiguration.class);
    beanDefinition.setInstanceSupplier(PauseResumeEndpointsConfiguration::new);
    return beanDefinition;
  }
}
