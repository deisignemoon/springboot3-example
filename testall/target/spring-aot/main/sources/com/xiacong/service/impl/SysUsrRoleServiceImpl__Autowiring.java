package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link SysUsrRoleServiceImpl}.
 */
@Generated
public class SysUsrRoleServiceImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static SysUsrRoleServiceImpl apply(RegisteredBean registeredBean,
      SysUsrRoleServiceImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("baseMapper").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
