package com.xiacong.task;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link LocalTaskExample}.
 */
@Generated
public class LocalTaskExample__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static LocalTaskExample apply(RegisteredBean registeredBean, LocalTaskExample instance) {
    ResourceElementResolver.forField("executor", "controlAsync").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
