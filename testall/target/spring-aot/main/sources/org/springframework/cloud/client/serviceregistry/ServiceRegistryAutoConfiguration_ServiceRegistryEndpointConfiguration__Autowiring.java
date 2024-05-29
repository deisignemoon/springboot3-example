package org.springframework.cloud.client.serviceregistry;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link ServiceRegistryAutoConfiguration.ServiceRegistryEndpointConfiguration}.
 */
@Generated
public class ServiceRegistryAutoConfiguration_ServiceRegistryEndpointConfiguration__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static ServiceRegistryAutoConfiguration.ServiceRegistryEndpointConfiguration apply(
      RegisteredBean registeredBean,
      ServiceRegistryAutoConfiguration.ServiceRegistryEndpointConfiguration instance) {
    AutowiredFieldValueResolver.forField("registration").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
