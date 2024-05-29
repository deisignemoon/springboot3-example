package org.flowable.spring.boot.cmmn;

import java.util.List;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredMethodArgumentsResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link CmmnEngineAutoConfiguration.CmmnEngineAppConfiguration}.
 */
@Generated
public class CmmnEngineAutoConfiguration_CmmnEngineAppConfiguration__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static CmmnEngineAutoConfiguration.CmmnEngineAppConfiguration apply(
      RegisteredBean registeredBean,
      CmmnEngineAutoConfiguration.CmmnEngineAppConfiguration instance) {
    AutowiredMethodArgumentsResolver.forMethod("setEngineConfigurers", List.class).resolve(registeredBean, args -> instance.setEngineConfigurers(args.get(0)));
    return instance;
  }
}
