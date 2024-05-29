package com.xiacong.flow;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link FlowEngine}.
 */
@Generated
public class FlowEngine__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static FlowEngine apply(RegisteredBean registeredBean, FlowEngine instance) {
    ResourceElementResolver.forField("executor", "controlAsync").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
