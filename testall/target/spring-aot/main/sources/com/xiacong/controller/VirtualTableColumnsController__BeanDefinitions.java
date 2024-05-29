package com.xiacong.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link VirtualTableColumnsController}.
 */
@Generated
public class VirtualTableColumnsController__BeanDefinitions {
  /**
   * Get the bean definition for 'virtualTableColumnsController'.
   */
  public static BeanDefinition getVirtualTableColumnsControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(VirtualTableColumnsController.class);
    beanDefinition.setInstanceSupplier(VirtualTableColumnsController::new);
    return beanDefinition;
  }
}
