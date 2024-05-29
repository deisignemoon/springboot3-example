package org.flowable.spring.boot.eventregistry;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredMethodArgumentsResolver;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * Autowiring for {@link EventRegistryAutoConfiguration}.
 */
@Generated
public class EventRegistryAutoConfiguration__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static EventRegistryAutoConfiguration apply(RegisteredBean registeredBean,
      EventRegistryAutoConfiguration instance) {
    AutowiredMethodArgumentsResolver.forRequiredMethod("setResourcePatternResolver", ResourcePatternResolver.class).resolve(registeredBean, args -> instance.setResourcePatternResolver(args.get(0)));
    return instance;
  }
}
