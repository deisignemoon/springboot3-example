package org.flowable.spring.boot.eventregistry;

import java.util.List;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredMethodArgumentsResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link EventRegistryAutoConfiguration.EventRegistryAppEngineConfiguration}.
 */
@Generated
public class EventRegistryAutoConfiguration_EventRegistryAppEngineConfiguration__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static EventRegistryAutoConfiguration.EventRegistryAppEngineConfiguration apply(
      RegisteredBean registeredBean,
      EventRegistryAutoConfiguration.EventRegistryAppEngineConfiguration instance) {
    AutowiredMethodArgumentsResolver.forMethod("setEngineConfigurers", List.class).resolve(registeredBean, args -> instance.setEngineConfigurers(args.get(0)));
    return instance;
  }
}
