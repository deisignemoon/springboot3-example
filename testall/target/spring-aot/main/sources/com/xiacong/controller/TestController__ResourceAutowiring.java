package com.xiacong.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link TestController}.
 */
@Generated
public class TestController__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static TestController apply(RegisteredBean registeredBean, TestController instance) {
    ResourceElementResolver.forField("taskExample").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
