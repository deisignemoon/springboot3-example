package com.xiacong.listener;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link FlowDataLoadListener}.
 */
@Generated
public class FlowDataLoadListener__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static FlowDataLoadListener apply(RegisteredBean registeredBean,
      FlowDataLoadListener instance) {
    ResourceElementResolver.forField("flowFactory").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
