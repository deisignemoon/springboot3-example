package org.springframework.security.config.annotation.method.configuration;

import java.util.List;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredMethodArgumentsResolver;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.core.context.SecurityContextHolderStrategy;

/**
 * Autowiring for {@link GlobalMethodSecurityConfiguration}.
 */
@Generated
public class GlobalMethodSecurityConfiguration__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GlobalMethodSecurityConfiguration apply(RegisteredBean registeredBean,
      GlobalMethodSecurityConfiguration instance) {
    AutowiredMethodArgumentsResolver.forMethod("setObjectPostProcessor", ObjectPostProcessor.class).resolve(registeredBean, args -> instance.setObjectPostProcessor(args.get(0)));
    AutowiredMethodArgumentsResolver.forMethod("setMethodSecurityExpressionHandler", List.class).resolve(registeredBean, args -> instance.setMethodSecurityExpressionHandler(args.get(0)));
    AutowiredMethodArgumentsResolver.forMethod("setSecurityContextHolderStrategy", SecurityContextHolderStrategy.class).resolve(registeredBean, args -> instance.setSecurityContextHolderStrategy(args.get(0)));
    return instance;
  }
}
