package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link VirtualTableServiceImpl}.
 */
@Generated
public class VirtualTableServiceImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'virtualTableServiceImpl'.
   */
  public static BeanDefinition getVirtualTableServiceImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(VirtualTableServiceImpl.class);
    InstanceSupplier<VirtualTableServiceImpl> instanceSupplier = InstanceSupplier.using(VirtualTableServiceImpl::new);
    instanceSupplier = instanceSupplier.andThen(VirtualTableServiceImpl__ResourceAutowiring::apply);
    instanceSupplier = instanceSupplier.andThen(VirtualTableServiceImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
