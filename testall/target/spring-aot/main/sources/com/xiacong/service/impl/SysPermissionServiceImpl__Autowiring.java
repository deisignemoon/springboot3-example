package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link SysPermissionServiceImpl}.
 */
@Generated
public class SysPermissionServiceImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static SysPermissionServiceImpl apply(RegisteredBean registeredBean,
      SysPermissionServiceImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("baseMapper").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
