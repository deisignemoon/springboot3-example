package org.flowable.spring.boot;

import org.flowable.common.engine.impl.async.AsyncTaskExecutorConfiguration;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.task.AsyncTaskExecutor;

/**
 * Bean definitions for {@link FlowableJobConfiguration}.
 */
@Generated
public class FlowableJobConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'flowableJobConfiguration'.
   */
  public static BeanDefinition getFlowableJobConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FlowableJobConfiguration.class);
    beanDefinition.setInstanceSupplier(FlowableJobConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'taskExecutor'.
   */
  private static BeanInstanceSupplier<AsyncTaskExecutor> getTaskExecutorInstanceSupplier() {
    return BeanInstanceSupplier.<AsyncTaskExecutor>forFactoryMethod(FlowableJobConfiguration.class, "taskExecutor")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(FlowableJobConfiguration.class).taskExecutor());
  }

  /**
   * Get the bean definition for 'taskExecutor'.
   */
  public static BeanDefinition getTaskExecutorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AsyncTaskExecutor.class);
    beanDefinition.setInstanceSupplier(getTaskExecutorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'flowableAsyncTaskInvokerTaskExecutorConfiguration'.
   */
  private static BeanInstanceSupplier<AsyncTaskExecutorConfiguration> getFlowableAsyncTaskInvokerTaskExecutorConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AsyncTaskExecutorConfiguration>forFactoryMethod(FlowableJobConfiguration.class, "flowableAsyncTaskInvokerTaskExecutorConfiguration")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(FlowableJobConfiguration.class).flowableAsyncTaskInvokerTaskExecutorConfiguration());
  }

  /**
   * Get the bean definition for 'flowableAsyncTaskInvokerTaskExecutorConfiguration'.
   */
  public static BeanDefinition getFlowableAsyncTaskInvokerTaskExecutorConfigurationBeanDefinition(
      ) {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AsyncTaskExecutorConfiguration.class);
    beanDefinition.setInstanceSupplier(getFlowableAsyncTaskInvokerTaskExecutorConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'flowableAsyncTaskInvokerTaskExecutor'.
   */
  private static BeanInstanceSupplier<org.flowable.common.engine.api.async.AsyncTaskExecutor> getFlowableAsyncTaskInvokerTaskExecutorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<org.flowable.common.engine.api.async.AsyncTaskExecutor>forFactoryMethod(FlowableJobConfiguration.class, "flowableAsyncTaskInvokerTaskExecutor", AsyncTaskExecutorConfiguration.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(FlowableJobConfiguration.class).flowableAsyncTaskInvokerTaskExecutor(args.get(0)));
  }

  /**
   * Get the bean definition for 'flowableAsyncTaskInvokerTaskExecutor'.
   */
  public static BeanDefinition getFlowableAsyncTaskInvokerTaskExecutorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(org.flowable.common.engine.api.async.AsyncTaskExecutor.class);
    beanDefinition.setDestroyMethodNames("shutdown");
    beanDefinition.setInstanceSupplier(getFlowableAsyncTaskInvokerTaskExecutorInstanceSupplier());
    return beanDefinition;
  }
}
