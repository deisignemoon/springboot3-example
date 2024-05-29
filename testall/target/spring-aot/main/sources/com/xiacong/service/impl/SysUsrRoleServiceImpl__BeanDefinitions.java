package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SysUsrRoleServiceImpl}.
 */
@Generated
public class SysUsrRoleServiceImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'sysUsrRoleServiceImpl'.
   */
  public static BeanDefinition getSysUsrRoleServiceImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SysUsrRoleServiceImpl.class);
    InstanceSupplier<SysUsrRoleServiceImpl> instanceSupplier = InstanceSupplier.using(SysUsrRoleServiceImpl::new);
    instanceSupplier = instanceSupplier.andThen(SysUsrRoleServiceImpl__ResourceAutowiring::apply);
    instanceSupplier = instanceSupplier.andThen(SysUsrRoleServiceImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
