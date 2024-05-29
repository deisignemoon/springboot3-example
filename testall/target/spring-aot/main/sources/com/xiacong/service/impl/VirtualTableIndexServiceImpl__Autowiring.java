package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link VirtualTableIndexServiceImpl}.
 */
@Generated
public class VirtualTableIndexServiceImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static VirtualTableIndexServiceImpl apply(RegisteredBean registeredBean,
      VirtualTableIndexServiceImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("baseMapper").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
