package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link VirtualTableDataServiceImpl}.
 */
@Generated
public class VirtualTableDataServiceImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'virtualTableDataServiceImpl'.
   */
  public static BeanDefinition getVirtualTableDataServiceImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(VirtualTableDataServiceImpl.class);
    InstanceSupplier<VirtualTableDataServiceImpl> instanceSupplier = InstanceSupplier.using(VirtualTableDataServiceImpl::new);
    instanceSupplier = instanceSupplier.andThen(VirtualTableDataServiceImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
