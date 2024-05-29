package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link VirtualTableServiceImpl}.
 */
@Generated
public class VirtualTableServiceImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static VirtualTableServiceImpl apply(RegisteredBean registeredBean,
      VirtualTableServiceImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("baseMapper").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
