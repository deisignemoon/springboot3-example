package com.xiacong.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link VirtualTableController}.
 */
@Generated
public class VirtualTableController__BeanDefinitions {
  /**
   * Get the bean definition for 'virtualTableController'.
   */
  public static BeanDefinition getVirtualTableControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(VirtualTableController.class);
    InstanceSupplier<VirtualTableController> instanceSupplier = InstanceSupplier.using(VirtualTableController::new);
    instanceSupplier = instanceSupplier.andThen(VirtualTableController__ResourceAutowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
