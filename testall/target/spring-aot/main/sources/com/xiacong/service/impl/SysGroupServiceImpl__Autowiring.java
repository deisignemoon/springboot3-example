package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link SysGroupServiceImpl}.
 */
@Generated
public class SysGroupServiceImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static SysGroupServiceImpl apply(RegisteredBean registeredBean,
      SysGroupServiceImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("baseMapper").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
