package org.flowable.spring.boot.dmn;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredMethodArgumentsResolver;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * Autowiring for {@link DmnEngineAutoConfiguration}.
 */
@Generated
public class DmnEngineAutoConfiguration__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static DmnEngineAutoConfiguration apply(RegisteredBean registeredBean,
      DmnEngineAutoConfiguration instance) {
    AutowiredMethodArgumentsResolver.forRequiredMethod("setResourcePatternResolver", ResourcePatternResolver.class).resolve(registeredBean, args -> instance.setResourcePatternResolver(args.get(0)));
    return instance;
  }
}
