package org.springframework.cloud.client;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link CommonsClientAutoConfiguration.ActuatorConfiguration}.
 */
@Generated
public class CommonsClientAutoConfiguration_ActuatorConfiguration__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static CommonsClientAutoConfiguration.ActuatorConfiguration apply(
      RegisteredBean registeredBean,
      CommonsClientAutoConfiguration.ActuatorConfiguration instance) {
    AutowiredFieldValueResolver.forField("hasFeatures").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
