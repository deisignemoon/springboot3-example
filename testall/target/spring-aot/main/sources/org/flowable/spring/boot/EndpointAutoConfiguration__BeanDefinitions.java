package org.flowable.spring.boot;

import org.flowable.engine.ProcessEngine;
import org.flowable.spring.boot.actuate.endpoint.ProcessEngineEndpoint;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link EndpointAutoConfiguration}.
 */
@Generated
public class EndpointAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'endpointAutoConfiguration'.
   */
  public static BeanDefinition getEndpointAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(EndpointAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(EndpointAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'processEngineEndpoint'.
   */
  private static BeanInstanceSupplier<ProcessEngineEndpoint> getProcessEngineEndpointInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ProcessEngineEndpoint>forFactoryMethod(EndpointAutoConfiguration.class, "processEngineEndpoint", ProcessEngine.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(EndpointAutoConfiguration.class).processEngineEndpoint(args.get(0)));
  }

  /**
   * Get the bean definition for 'processEngineEndpoint'.
   */
  public static BeanDefinition getProcessEngineEndpointBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ProcessEngineEndpoint.class);
    beanDefinition.setInstanceSupplier(getProcessEngineEndpointInstanceSupplier());
    return beanDefinition;
  }
}
