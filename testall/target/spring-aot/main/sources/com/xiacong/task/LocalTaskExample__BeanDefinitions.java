package com.xiacong.task;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link LocalTaskExample}.
 */
@Generated
public class LocalTaskExample__BeanDefinitions {
  /**
   * Get the bean definition for 'localTaskExample'.
   */
  public static BeanDefinition getLocalTaskExampleBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(LocalTaskExample.class);
    InstanceSupplier<LocalTaskExample> instanceSupplier = InstanceSupplier.using(LocalTaskExample::new);
    instanceSupplier = instanceSupplier.andThen(LocalTaskExample__ResourceAutowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
