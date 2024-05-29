package com.xiacong.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link VirtualTableIndexController}.
 */
@Generated
public class VirtualTableIndexController__BeanDefinitions {
  /**
   * Get the bean definition for 'virtualTableIndexController'.
   */
  public static BeanDefinition getVirtualTableIndexControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(VirtualTableIndexController.class);
    beanDefinition.setInstanceSupplier(VirtualTableIndexController::new);
    return beanDefinition;
  }
}
