package com.xiacong.flow;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link FlowEngine}.
 */
@Generated
public class FlowEngine__BeanDefinitions {
  /**
   * Get the bean definition for 'flowEngine'.
   */
  public static BeanDefinition getFlowEngineBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FlowEngine.class);
    InstanceSupplier<FlowEngine> instanceSupplier = InstanceSupplier.using(FlowEngine::new);
    instanceSupplier = instanceSupplier.andThen(FlowEngine__ResourceAutowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
