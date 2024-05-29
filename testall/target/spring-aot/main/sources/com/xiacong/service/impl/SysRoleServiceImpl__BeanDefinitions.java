package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SysRoleServiceImpl}.
 */
@Generated
public class SysRoleServiceImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'sysRoleServiceImpl'.
   */
  public static BeanDefinition getSysRoleServiceImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SysRoleServiceImpl.class);
    InstanceSupplier<SysRoleServiceImpl> instanceSupplier = InstanceSupplier.using(SysRoleServiceImpl::new);
    instanceSupplier = instanceSupplier.andThen(SysRoleServiceImpl__ResourceAutowiring::apply);
    instanceSupplier = instanceSupplier.andThen(SysRoleServiceImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
