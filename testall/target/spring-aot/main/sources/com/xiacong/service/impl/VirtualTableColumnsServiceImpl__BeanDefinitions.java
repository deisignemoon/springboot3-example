package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link VirtualTableColumnsServiceImpl}.
 */
@Generated
public class VirtualTableColumnsServiceImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'virtualTableColumnsServiceImpl'.
   */
  public static BeanDefinition getVirtualTableColumnsServiceImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(VirtualTableColumnsServiceImpl.class);
    InstanceSupplier<VirtualTableColumnsServiceImpl> instanceSupplier = InstanceSupplier.using(VirtualTableColumnsServiceImpl::new);
    instanceSupplier = instanceSupplier.andThen(VirtualTableColumnsServiceImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
