package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link SysUsrServiceImpl}.
 */
@Generated
public class SysUsrServiceImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static SysUsrServiceImpl apply(RegisteredBean registeredBean, SysUsrServiceImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("baseMapper").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
