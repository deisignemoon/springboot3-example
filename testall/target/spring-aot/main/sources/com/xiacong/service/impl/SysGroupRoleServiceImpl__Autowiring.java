package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link SysGroupRoleServiceImpl}.
 */
@Generated
public class SysGroupRoleServiceImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static SysGroupRoleServiceImpl apply(RegisteredBean registeredBean,
      SysGroupRoleServiceImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("baseMapper").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
