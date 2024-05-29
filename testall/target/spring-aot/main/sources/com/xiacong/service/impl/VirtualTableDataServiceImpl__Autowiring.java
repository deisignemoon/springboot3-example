package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link VirtualTableDataServiceImpl}.
 */
@Generated
public class VirtualTableDataServiceImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static VirtualTableDataServiceImpl apply(RegisteredBean registeredBean,
      VirtualTableDataServiceImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("baseMapper").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
