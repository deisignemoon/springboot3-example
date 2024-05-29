package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link BookServiceImpl}.
 */
@Generated
public class BookServiceImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static BookServiceImpl apply(RegisteredBean registeredBean, BookServiceImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("baseMapper").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
