package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SysRolePermissionServiceImpl}.
 */
@Generated
public class SysRolePermissionServiceImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'sysRolePermissionServiceImpl'.
   */
  public static BeanDefinition getSysRolePermissionServiceImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SysRolePermissionServiceImpl.class);
    InstanceSupplier<SysRolePermissionServiceImpl> instanceSupplier = InstanceSupplier.using(SysRolePermissionServiceImpl::new);
    instanceSupplier = instanceSupplier.andThen(SysRolePermissionServiceImpl__ResourceAutowiring::apply);
    instanceSupplier = instanceSupplier.andThen(SysRolePermissionServiceImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
