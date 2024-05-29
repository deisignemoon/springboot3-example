package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SysUsrGroupServiceImpl}.
 */
@Generated
public class SysUsrGroupServiceImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'sysUsrGroupServiceImpl'.
   */
  public static BeanDefinition getSysUsrGroupServiceImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SysUsrGroupServiceImpl.class);
    InstanceSupplier<SysUsrGroupServiceImpl> instanceSupplier = InstanceSupplier.using(SysUsrGroupServiceImpl::new);
    instanceSupplier = instanceSupplier.andThen(SysUsrGroupServiceImpl__ResourceAutowiring::apply);
    instanceSupplier = instanceSupplier.andThen(SysUsrGroupServiceImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
