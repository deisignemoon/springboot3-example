package com.xiacong.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.annotation.ResourceElementResolver;

/**
 * Resource autowiring for {@link BookController}.
 */
@Generated
public class BookController__ResourceAutowiring {
  /**
   * Apply resource autowiring.
   */
  public static BookController apply(RegisteredBean registeredBean, BookController instance) {
    ResourceElementResolver.forField("mapper").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
