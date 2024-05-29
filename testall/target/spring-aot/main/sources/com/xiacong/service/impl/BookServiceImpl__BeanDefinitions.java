package com.xiacong.service.impl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link BookServiceImpl}.
 */
@Generated
public class BookServiceImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'bookServiceImpl'.
   */
  public static BeanDefinition getBookServiceImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(BookServiceImpl.class);
    InstanceSupplier<BookServiceImpl> instanceSupplier = InstanceSupplier.using(BookServiceImpl::new);
    instanceSupplier = instanceSupplier.andThen(BookServiceImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
