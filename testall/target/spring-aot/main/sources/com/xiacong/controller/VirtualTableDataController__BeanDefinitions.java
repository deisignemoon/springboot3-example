package com.xiacong.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link VirtualTableDataController}.
 */
@Generated
public class VirtualTableDataController__BeanDefinitions {
  /**
   * Get the bean definition for 'virtualTableDataController'.
   */
  public static BeanDefinition getVirtualTableDataControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(VirtualTableDataController.class);
    beanDefinition.setInstanceSupplier(VirtualTableDataController::new);
    return beanDefinition;
  }
}
