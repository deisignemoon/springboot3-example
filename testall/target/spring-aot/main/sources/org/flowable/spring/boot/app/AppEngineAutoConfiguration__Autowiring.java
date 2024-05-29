package org.flowable.spring.boot.app;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredMethodArgumentsResolver;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * Autowiring for {@link AppEngineAutoConfiguration}.
 */
@Generated
public class AppEngineAutoConfiguration__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static AppEngineAutoConfiguration apply(RegisteredBean registeredBean,
      AppEngineAutoConfiguration instance) {
    AutowiredMethodArgumentsResolver.forRequiredMethod("setResourcePatternResolver", ResourcePatternResolver.class).resolve(registeredBean, args -> instance.setResourcePatternResolver(args.get(0)));
    return instance;
  }
}
