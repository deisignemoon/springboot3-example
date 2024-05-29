package org.flowable.spring.boot.idm;

import java.util.List;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredMethodArgumentsResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link IdmEngineAutoConfiguration.IdmEngineAppConfiguration}.
 */
@Generated
public class IdmEngineAutoConfiguration_IdmEngineAppConfiguration__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static IdmEngineAutoConfiguration.IdmEngineAppConfiguration apply(
      RegisteredBean registeredBean,
      IdmEngineAutoConfiguration.IdmEngineAppConfiguration instance) {
    AutowiredMethodArgumentsResolver.forMethod("setEngineConfigurers", List.class).resolve(registeredBean, args -> instance.setEngineConfigurers(args.get(0)));
    return instance;
  }
}
