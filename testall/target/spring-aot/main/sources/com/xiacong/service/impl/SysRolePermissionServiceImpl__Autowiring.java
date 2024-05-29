package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link SysRolePermissionServiceImpl}.
 */
@Generated
public class SysRolePermissionServiceImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static SysRolePermissionServiceImpl apply(RegisteredBean registeredBean,
      SysRolePermissionServiceImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("baseMapper").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
