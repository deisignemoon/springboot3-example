package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link VirtualTableIndexServiceImpl}.
 */
@Generated
public class VirtualTableIndexServiceImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'virtualTableIndexServiceImpl'.
   */
  public static BeanDefinition getVirtualTableIndexServiceImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(VirtualTableIndexServiceImpl.class);
    InstanceSupplier<VirtualTableIndexServiceImpl> instanceSupplier = InstanceSupplier.using(VirtualTableIndexServiceImpl::new);
    instanceSupplier = instanceSupplier.andThen(VirtualTableIndexServiceImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
