package org.springframework.boot.actuate.autoconfigure.context;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.actuate.context.ShutdownEndpoint;

/**
 * Bean definitions for {@link ShutdownEndpointAutoConfiguration}.
 */
@Generated
public class ShutdownEndpointAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'shutdownEndpointAutoConfiguration'.
   */
  public static BeanDefinition getShutdownEndpointAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ShutdownEndpointAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(ShutdownEndpointAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'shutdownEndpoint'.
   */
  private static BeanInstanceSupplier<ShutdownEndpoint> getShutdownEndpointInstanceSupplier() {
    return BeanInstanceSupplier.<ShutdownEndpoint>forFactoryMethod(ShutdownEndpointAutoConfiguration.class, "shutdownEndpoint")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(ShutdownEndpointAutoConfiguration.class).shutdownEndpoint());
  }

  /**
   * Get the bean definition for 'shutdownEndpoint'.
   */
  public static BeanDefinition getShutdownEndpointBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ShutdownEndpoint.class);
    beanDefinition.setInstanceSupplier(getShutdownEndpointInstanceSupplier());
    return beanDefinition;
  }
}
