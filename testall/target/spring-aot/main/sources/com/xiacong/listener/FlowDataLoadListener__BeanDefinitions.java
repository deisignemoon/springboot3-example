package com.xiacong.listener;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link FlowDataLoadListener}.
 */
@Generated
public class FlowDataLoadListener__BeanDefinitions {
  /**
   * Get the bean definition for 'flowDataLoadListener'.
   */
  public static BeanDefinition getFlowDataLoadListenerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FlowDataLoadListener.class);
    InstanceSupplier<FlowDataLoadListener> instanceSupplier = InstanceSupplier.using(FlowDataLoadListener::new);
    instanceSupplier = instanceSupplier.andThen(FlowDataLoadListener__ResourceAutowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
