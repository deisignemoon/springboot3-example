package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link SysUsrGroupServiceImpl}.
 */
@Generated
public class SysUsrGroupServiceImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static SysUsrGroupServiceImpl apply(RegisteredBean registeredBean,
      SysUsrGroupServiceImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("baseMapper").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
