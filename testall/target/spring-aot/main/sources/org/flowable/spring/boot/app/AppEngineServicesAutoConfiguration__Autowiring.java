package org.flowable.spring.boot.app;

import java.util.List;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredMethodArgumentsResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link AppEngineServicesAutoConfiguration}.
 */
@Generated
public class AppEngineServicesAutoConfiguration__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static AppEngineServicesAutoConfiguration apply(RegisteredBean registeredBean,
      AppEngineServicesAutoConfiguration instance) {
    AutowiredMethodArgumentsResolver.forMethod("setEngineConfigurers", List.class).resolve(registeredBean, args -> instance.setEngineConfigurers(args.get(0)));
    return instance;
  }
}
