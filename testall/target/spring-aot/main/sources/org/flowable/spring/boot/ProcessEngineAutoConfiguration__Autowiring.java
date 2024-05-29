package org.flowable.spring.boot;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredMethodArgumentsResolver;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * Autowiring for {@link ProcessEngineAutoConfiguration}.
 */
@Generated
public class ProcessEngineAutoConfiguration__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static ProcessEngineAutoConfiguration apply(RegisteredBean registeredBean,
      ProcessEngineAutoConfiguration instance) {
    AutowiredMethodArgumentsResolver.forRequiredMethod("setResourcePatternResolver", ResourcePatternResolver.class).resolve(registeredBean, args -> instance.setResourcePatternResolver(args.get(0)));
    return instance;
  }
}
