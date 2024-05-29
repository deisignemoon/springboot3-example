package com.xiacong.common.thread;

import java.util.concurrent.Executor;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link ExecutorConfig}.
 */
@Generated
public class ExecutorConfig__BeanDefinitions {
  /**
   * Get the bean definition for 'executorConfig'.
   */
  public static BeanDefinition getExecutorConfigBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ExecutorConfig.class);
    beanDefinition.setTargetType(ExecutorConfig.class);
    ConfigurationClassUtils.initializeConfigurationClass(ExecutorConfig.class);
    beanDefinition.setInstanceSupplier(ExecutorConfig$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'controlAsync'.
   */
  private static BeanInstanceSupplier<Executor> getControlAsyncInstanceSupplier() {
    return BeanInstanceSupplier.<Executor>forFactoryMethod(ExecutorConfig.class, "controlAsync")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(ExecutorConfig.class).controlAsync());
  }

  /**
   * Get the bean definition for 'controlAsync'.
   */
  public static BeanDefinition getControlAsyncBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(Executor.class);
    beanDefinition.setInstanceSupplier(getControlAsyncInstanceSupplier());
    return beanDefinition;
  }
}
