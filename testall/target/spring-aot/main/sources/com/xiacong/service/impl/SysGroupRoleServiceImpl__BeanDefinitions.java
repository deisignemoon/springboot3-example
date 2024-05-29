package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SysGroupRoleServiceImpl}.
 */
@Generated
public class SysGroupRoleServiceImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'sysGroupRoleServiceImpl'.
   */
  public static BeanDefinition getSysGroupRoleServiceImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SysGroupRoleServiceImpl.class);
    InstanceSupplier<SysGroupRoleServiceImpl> instanceSupplier = InstanceSupplier.using(SysGroupRoleServiceImpl::new);
    instanceSupplier = instanceSupplier.andThen(SysGroupRoleServiceImpl__ResourceAutowiring::apply);
    instanceSupplier = instanceSupplier.andThen(SysGroupRoleServiceImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
