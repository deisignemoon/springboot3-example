package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SysPermissionServiceImpl}.
 */
@Generated
public class SysPermissionServiceImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'sysPermissionServiceImpl'.
   */
  public static BeanDefinition getSysPermissionServiceImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SysPermissionServiceImpl.class);
    InstanceSupplier<SysPermissionServiceImpl> instanceSupplier = InstanceSupplier.using(SysPermissionServiceImpl::new);
    instanceSupplier = instanceSupplier.andThen(SysPermissionServiceImpl__ResourceAutowiring::apply);
    instanceSupplier = instanceSupplier.andThen(SysPermissionServiceImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
