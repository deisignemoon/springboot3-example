package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link SysRoleServiceImpl}.
 */
@Generated
public class SysRoleServiceImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static SysRoleServiceImpl apply(RegisteredBean registeredBean,
      SysRoleServiceImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("baseMapper").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
