package org.flowable.spring.boot;

import javax.sql.DataSource;
import org.flowable.app.spring.SpringAppEngineConfiguration;
import org.flowable.engine.configurator.ProcessEngineConfigurator;
import org.flowable.job.service.impl.asyncexecutor.AsyncJobExecutorConfiguration;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.flowable.spring.boot.app.FlowableAppProperties;
import org.flowable.spring.boot.eventregistry.FlowableEventRegistryProperties;
import org.flowable.spring.boot.idm.FlowableIdmProperties;
import org.flowable.spring.boot.process.FlowableProcessProperties;
import org.flowable.spring.job.service.SpringAsyncExecutor;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Bean definitions for {@link ProcessEngineAutoConfiguration}.
 */
@Generated
public class ProcessEngineAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.flowable.spring.boot.ProcessEngineAutoConfiguration'.
   */
  private static BeanInstanceSupplier<ProcessEngineAutoConfiguration> getProcessEngineAutoConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ProcessEngineAutoConfiguration>forConstructor(FlowableProperties.class, FlowableProcessProperties.class, FlowableAppProperties.class, FlowableIdmProperties.class, FlowableEventRegistryProperties.class, FlowableMailProperties.class, FlowableHttpProperties.class, FlowableAutoDeploymentProperties.class)
            .withGenerator((registeredBean, args) -> new ProcessEngineAutoConfiguration(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4), args.get(5), args.get(6), args.get(7)));
  }

  /**
   * Get the bean definition for 'processEngineAutoConfiguration'.
   */
  public static BeanDefinition getProcessEngineAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ProcessEngineAutoConfiguration.class);
    InstanceSupplier<ProcessEngineAutoConfiguration> instanceSupplier = getProcessEngineAutoConfigurationInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(ProcessEngineAutoConfiguration__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'processAsyncExecutorConfiguration'.
   */
  private static BeanInstanceSupplier<AsyncJobExecutorConfiguration> getProcessAsyncExecutorConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AsyncJobExecutorConfiguration>forFactoryMethod(ProcessEngineAutoConfiguration.class, "processAsyncExecutorConfiguration")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(ProcessEngineAutoConfiguration.class).processAsyncExecutorConfiguration());
  }

  /**
   * Get the bean definition for 'processAsyncExecutorConfiguration'.
   */
  public static BeanDefinition getProcessAsyncExecutorConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AsyncJobExecutorConfiguration.class);
    beanDefinition.setInstanceSupplier(getProcessAsyncExecutorConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'processAsyncExecutor'.
   */
  private static BeanInstanceSupplier<SpringAsyncExecutor> getProcessAsyncExecutorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SpringAsyncExecutor>forFactoryMethod(ProcessEngineAutoConfiguration.class, "processAsyncExecutor", AsyncJobExecutorConfiguration.class, ObjectProvider.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ProcessEngineAutoConfiguration.class).processAsyncExecutor(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'processAsyncExecutor'.
   */
  public static BeanDefinition getProcessAsyncExecutorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringAsyncExecutor.class);
    beanDefinition.setDestroyMethodNames("shutdown");
    beanDefinition.setInstanceSupplier(getProcessAsyncExecutorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'springProcessEngineConfiguration'.
   */
  private static BeanInstanceSupplier<SpringProcessEngineConfiguration> getSpringProcessEngineConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SpringProcessEngineConfiguration>forFactoryMethod(ProcessEngineAutoConfiguration.class, "springProcessEngineConfiguration", DataSource.class, PlatformTransactionManager.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ProcessEngineAutoConfiguration.class).springProcessEngineConfiguration(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4), args.get(5), args.get(6), args.get(7), args.get(8), args.get(9), args.get(10), args.get(11), args.get(12)));
  }

  /**
   * Get the bean definition for 'springProcessEngineConfiguration'.
   */
  public static BeanDefinition getSpringProcessEngineConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringProcessEngineConfiguration.class);
    beanDefinition.setDestroyMethodNames("close");
    beanDefinition.setInstanceSupplier(getSpringProcessEngineConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link ProcessEngineAutoConfiguration.ProcessEngineAppConfiguration}.
   */
  @Generated
  public static class ProcessEngineAppConfiguration {
    /**
     * Get the bean definition for 'processEngineAppConfiguration'.
     */
    public static BeanDefinition getProcessEngineAppConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ProcessEngineAutoConfiguration.ProcessEngineAppConfiguration.class);
      InstanceSupplier<ProcessEngineAutoConfiguration.ProcessEngineAppConfiguration> instanceSupplier = InstanceSupplier.using(ProcessEngineAutoConfiguration.ProcessEngineAppConfiguration::new);
      instanceSupplier = instanceSupplier.andThen(ProcessEngineAutoConfiguration_ProcessEngineAppConfiguration__Autowiring::apply);
      beanDefinition.setInstanceSupplier(instanceSupplier);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'processAppEngineConfigurationConfigurer'.
     */
    private static BeanInstanceSupplier<EngineConfigurationConfigurer> getProcessAppEngineConfigurationConfigurerInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<EngineConfigurationConfigurer>forFactoryMethod(ProcessEngineAutoConfiguration.ProcessEngineAppConfiguration.class, "processAppEngineConfigurationConfigurer", ProcessEngineConfigurator.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ProcessEngineAutoConfiguration.ProcessEngineAppConfiguration.class).processAppEngineConfigurationConfigurer(args.get(0)));
    }

    /**
     * Get the bean definition for 'processAppEngineConfigurationConfigurer'.
     */
    public static BeanDefinition getProcessAppEngineConfigurationConfigurerBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(EngineConfigurationConfigurer.class);
      beanDefinition.setTargetType(ResolvableType.forClassWithGenerics(EngineConfigurationConfigurer.class, SpringAppEngineConfiguration.class));
      beanDefinition.setInstanceSupplier(getProcessAppEngineConfigurationConfigurerInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'processEngineConfigurator'.
     */
    private static BeanInstanceSupplier<ProcessEngineConfigurator> getProcessEngineConfiguratorInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<ProcessEngineConfigurator>forFactoryMethod(ProcessEngineAutoConfiguration.ProcessEngineAppConfiguration.class, "processEngineConfigurator", SpringProcessEngineConfiguration.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ProcessEngineAutoConfiguration.ProcessEngineAppConfiguration.class).processEngineConfigurator(args.get(0)));
    }

    /**
     * Get the bean definition for 'processEngineConfigurator'.
     */
    public static BeanDefinition getProcessEngineConfiguratorBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ProcessEngineConfigurator.class);
      beanDefinition.setInstanceSupplier(getProcessEngineConfiguratorInstanceSupplier());
      return beanDefinition;
    }
  }
}
