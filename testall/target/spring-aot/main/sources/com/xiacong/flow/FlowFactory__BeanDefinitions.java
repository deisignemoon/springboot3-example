package com.xiacong.flow;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link FlowFactory}.
 */
@Generated
public class FlowFactory__BeanDefinitions {
  /**
   * Get the bean definition for 'flowFactory'.
   */
  public static BeanDefinition getFlowFactoryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FlowFactory.class);
    InstanceSupplier<FlowFactory> instanceSupplier = InstanceSupplier.using(FlowFactory::new);
    instanceSupplier = instanceSupplier.andThen(FlowFactory__ResourceAutowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
