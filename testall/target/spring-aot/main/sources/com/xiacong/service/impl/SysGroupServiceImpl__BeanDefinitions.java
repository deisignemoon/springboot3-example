package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SysGroupServiceImpl}.
 */
@Generated
public class SysGroupServiceImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'sysGroupServiceImpl'.
   */
  public static BeanDefinition getSysGroupServiceImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SysGroupServiceImpl.class);
    InstanceSupplier<SysGroupServiceImpl> instanceSupplier = InstanceSupplier.using(SysGroupServiceImpl::new);
    instanceSupplier = instanceSupplier.andThen(SysGroupServiceImpl__ResourceAutowiring::apply);
    instanceSupplier = instanceSupplier.andThen(SysGroupServiceImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
