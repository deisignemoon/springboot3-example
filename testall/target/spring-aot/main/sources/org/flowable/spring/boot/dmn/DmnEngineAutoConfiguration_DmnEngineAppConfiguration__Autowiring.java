package org.flowable.spring.boot.dmn;

import java.util.List;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredMethodArgumentsResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link DmnEngineAutoConfiguration.DmnEngineAppConfiguration}.
 */
@Generated
public class DmnEngineAutoConfiguration_DmnEngineAppConfiguration__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static DmnEngineAutoConfiguration.DmnEngineAppConfiguration apply(
      RegisteredBean registeredBean,
      DmnEngineAutoConfiguration.DmnEngineAppConfiguration instance) {
    AutowiredMethodArgumentsResolver.forMethod("setEngineConfigurers", List.class).resolve(registeredBean, args -> instance.setEngineConfigurers(args.get(0)));
    return instance;
  }
}
