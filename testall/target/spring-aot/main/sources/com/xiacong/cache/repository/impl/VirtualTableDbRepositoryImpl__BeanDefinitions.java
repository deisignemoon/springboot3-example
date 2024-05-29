package com.xiacong.cache.repository.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link VirtualTableDbRepositoryImpl}.
 */
@Generated
public class VirtualTableDbRepositoryImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'virtualTableDbRepositoryImpl'.
   */
  public static BeanDefinition getVirtualTableDbRepositoryImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(VirtualTableDbRepositoryImpl.class);
    InstanceSupplier<VirtualTableDbRepositoryImpl> instanceSupplier = InstanceSupplier.using(VirtualTableDbRepositoryImpl::new);
    instanceSupplier = instanceSupplier.andThen(VirtualTableDbRepositoryImpl__ResourceAutowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
