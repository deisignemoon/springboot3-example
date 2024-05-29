package com.xiacong.flow;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link FlowFactory}.
 */
@Generated
public class FlowFactory__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static FlowFactory apply(RegisteredBean registeredBean, FlowFactory instance) {
    ResourceElementResolver.forField("flowEngine").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
