package org.springframework.cloud.client.serviceregistry;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.cloud.client.serviceregistry.endpoint.ServiceRegistryEndpoint;

/**
 * Bean definitions for {@link ServiceRegistryAutoConfiguration}.
 */
@Generated
public class ServiceRegistryAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'serviceRegistryAutoConfiguration'.
   */
  public static BeanDefinition getServiceRegistryAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ServiceRegistryAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(ServiceRegistryAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link ServiceRegistryAutoConfiguration.ServiceRegistryEndpointConfiguration}.
   */
  @Generated
  public static class ServiceRegistryEndpointConfiguration {
    /**
     * Get the bean instance supplier for 'org.springframework.cloud.client.serviceregistry.ServiceRegistryAutoConfiguration$ServiceRegistryEndpointConfiguration'.
     */
    private static BeanInstanceSupplier<ServiceRegistryAutoConfiguration.ServiceRegistryEndpointConfiguration> getServiceRegistryEndpointConfigurationInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<ServiceRegistryAutoConfiguration.ServiceRegistryEndpointConfiguration>forConstructor()
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ServiceRegistryAutoConfiguration.class).new ServiceRegistryEndpointConfiguration());
    }

    /**
     * Get the bean definition for 'serviceRegistryEndpointConfiguration'.
     */
    public static BeanDefinition getServiceRegistryEndpointConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ServiceRegistryAutoConfiguration.ServiceRegistryEndpointConfiguration.class);
      InstanceSupplier<ServiceRegistryAutoConfiguration.ServiceRegistryEndpointConfiguration> instanceSupplier = getServiceRegistryEndpointConfigurationInstanceSupplier();
      instanceSupplier = instanceSupplier.andThen(ServiceRegistryAutoConfiguration_ServiceRegistryEndpointConfiguration__Autowiring::apply);
      beanDefinition.setInstanceSupplier(instanceSupplier);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'serviceRegistryEndpoint'.
     */
    private static BeanInstanceSupplier<ServiceRegistryEndpoint> getServiceRegistryEndpointInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<ServiceRegistryEndpoint>forFactoryMethod(ServiceRegistryAutoConfiguration.ServiceRegistryEndpointConfiguration.class, "serviceRegistryEndpoint", ServiceRegistry.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ServiceRegistryAutoConfiguration.ServiceRegistryEndpointConfiguration.class).serviceRegistryEndpoint(args.get(0)));
    }

    /**
     * Get the bean definition for 'serviceRegistryEndpoint'.
     */
    public static BeanDefinition getServiceRegistryEndpointBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ServiceRegistryEndpoint.class);
      beanDefinition.setInstanceSupplier(getServiceRegistryEndpointInstanceSupplier());
      return beanDefinition;
    }
  }
}
