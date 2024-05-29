package com.xiacong.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link BookController}.
 */
@Generated
public class BookController__BeanDefinitions {
  /**
   * Get the bean definition for 'bookController'.
   */
  public static BeanDefinition getBookControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(BookController.class);
    InstanceSupplier<BookController> instanceSupplier = InstanceSupplier.using(BookController::new);
    instanceSupplier = instanceSupplier.andThen(BookController__ResourceAutowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
