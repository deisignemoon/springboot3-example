package org.flowable.spring.boot.idm;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredMethodArgumentsResolver;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * Autowiring for {@link IdmEngineAutoConfiguration}.
 */
@Generated
public class IdmEngineAutoConfiguration__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static IdmEngineAutoConfiguration apply(RegisteredBean registeredBean,
      IdmEngineAutoConfiguration instance) {
    AutowiredMethodArgumentsResolver.forRequiredMethod("setResourcePatternResolver", ResourcePatternResolver.class).resolve(registeredBean, args -> instance.setResourcePatternResolver(args.get(0)));
    return instance;
  }
}
