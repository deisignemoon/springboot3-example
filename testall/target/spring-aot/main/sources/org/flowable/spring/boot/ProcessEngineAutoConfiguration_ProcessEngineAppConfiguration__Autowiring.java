package org.flowable.spring.boot;

import java.util.List;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredMethodArgumentsResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link ProcessEngineAutoConfiguration.ProcessEngineAppConfiguration}.
 */
@Generated
public class ProcessEngineAutoConfiguration_ProcessEngineAppConfiguration__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static ProcessEngineAutoConfiguration.ProcessEngineAppConfiguration apply(
      RegisteredBean registeredBean,
      ProcessEngineAutoConfiguration.ProcessEngineAppConfiguration instance) {
    AutowiredMethodArgumentsResolver.forMethod("setEngineConfigurers", List.class).resolve(registeredBean, args -> instance.setEngineConfigurers(args.get(0)));
    return instance;
  }
}
