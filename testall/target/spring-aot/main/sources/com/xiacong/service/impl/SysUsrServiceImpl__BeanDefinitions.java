package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SysUsrServiceImpl}.
 */
@Generated
public class SysUsrServiceImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'sysUsrServiceImpl'.
   */
  public static BeanDefinition getSysUsrServiceImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SysUsrServiceImpl.class);
    InstanceSupplier<SysUsrServiceImpl> instanceSupplier = InstanceSupplier.using(SysUsrServiceImpl::new);
    instanceSupplier = instanceSupplier.andThen(SysUsrServiceImpl__ResourceAutowiring::apply);
    instanceSupplier = instanceSupplier.andThen(SysUsrServiceImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
