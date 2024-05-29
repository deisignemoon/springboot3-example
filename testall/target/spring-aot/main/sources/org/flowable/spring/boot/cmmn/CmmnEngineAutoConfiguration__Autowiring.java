package org.flowable.spring.boot.cmmn;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredMethodArgumentsResolver;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * Autowiring for {@link CmmnEngineAutoConfiguration}.
 */
@Generated
public class CmmnEngineAutoConfiguration__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static CmmnEngineAutoConfiguration apply(RegisteredBean registeredBean,
      CmmnEngineAutoConfiguration instance) {
    AutowiredMethodArgumentsResolver.forRequiredMethod("setResourcePatternResolver", ResourcePatternResolver.class).resolve(registeredBean, args -> instance.setResourcePatternResolver(args.get(0)));
    return instance;
  }
}
