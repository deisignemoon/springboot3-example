package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link VirtualTableColumnsServiceImpl}.
 */
@Generated
public class VirtualTableColumnsServiceImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static VirtualTableColumnsServiceImpl apply(RegisteredBean registeredBean,
      VirtualTableColumnsServiceImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("baseMapper").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
