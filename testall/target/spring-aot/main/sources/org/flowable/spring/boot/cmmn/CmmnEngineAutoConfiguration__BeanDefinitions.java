package org.flowable.spring.boot.cmmn;

import javax.sql.DataSource;
import org.flowable.app.spring.SpringAppEngineConfiguration;
import org.flowable.cmmn.engine.configurator.CmmnEngineConfigurator;
import org.flowable.cmmn.spring.SpringCmmnEngineConfiguration;
import org.flowable.job.service.impl.asyncexecutor.AsyncJobExecutorConfiguration;
import org.flowable.spring.boot.EngineConfigurationConfigurer;
import org.flowable.spring.boot.FlowableAutoDeploymentProperties;
import org.flowable.spring.boot.FlowableHttpProperties;
import org.flowable.spring.boot.FlowableMailProperties;
import org.flowable.spring.boot.FlowableProperties;
import org.flowable.spring.boot.eventregistry.FlowableEventRegistryProperties;
import org.flowable.spring.boot.idm.FlowableIdmProperties;
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
 * Bean definitions for {@link CmmnEngineAutoConfiguration}.
 */
@Generated
public class CmmnEngineAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.flowable.spring.boot.cmmn.CmmnEngineAutoConfiguration'.
   */
  private static BeanInstanceSupplier<CmmnEngineAutoConfiguration> getCmmnEngineAutoConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<CmmnEngineAutoConfiguration>forConstructor(FlowableProperties.class, FlowableCmmnProperties.class, FlowableIdmProperties.class, FlowableEventRegistryProperties.class, FlowableMailProperties.class, FlowableHttpProperties.class, FlowableAutoDeploymentProperties.class)
            .withGenerator((registeredBean, args) -> new CmmnEngineAutoConfiguration(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4), args.get(5), args.get(6)));
  }

  /**
   * Get the bean definition for 'cmmnEngineAutoConfiguration'.
   */
  public static BeanDefinition getCmmnEngineAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CmmnEngineAutoConfiguration.class);
    InstanceSupplier<CmmnEngineAutoConfiguration> instanceSupplier = getCmmnEngineAutoConfigurationInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(CmmnEngineAutoConfiguration__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'cmmnAsyncExecutorConfiguration'.
   */
  private static BeanInstanceSupplier<AsyncJobExecutorConfiguration> getCmmnAsyncExecutorConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AsyncJobExecutorConfiguration>forFactoryMethod(CmmnEngineAutoConfiguration.class, "cmmnAsyncExecutorConfiguration")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(CmmnEngineAutoConfiguration.class).cmmnAsyncExecutorConfiguration());
  }

  /**
   * Get the bean definition for 'cmmnAsyncExecutorConfiguration'.
   */
  public static BeanDefinition getCmmnAsyncExecutorConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AsyncJobExecutorConfiguration.class);
    beanDefinition.setInstanceSupplier(getCmmnAsyncExecutorConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'cmmnAsyncExecutor'.
   */
  private static BeanInstanceSupplier<SpringAsyncExecutor> getCmmnAsyncExecutorInstanceSupplier() {
    return BeanInstanceSupplier.<SpringAsyncExecutor>forFactoryMethod(CmmnEngineAutoConfiguration.class, "cmmnAsyncExecutor", AsyncJobExecutorConfiguration.class, ObjectProvider.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(CmmnEngineAutoConfiguration.class).cmmnAsyncExecutor(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'cmmnAsyncExecutor'.
   */
  public static BeanDefinition getCmmnAsyncExecutorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringAsyncExecutor.class);
    beanDefinition.setDestroyMethodNames("shutdown");
    beanDefinition.setInstanceSupplier(getCmmnAsyncExecutorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'cmmnEngineConfiguration'.
   */
  private static BeanInstanceSupplier<SpringCmmnEngineConfiguration> getCmmnEngineConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SpringCmmnEngineConfiguration>forFactoryMethod(CmmnEngineAutoConfiguration.class, "cmmnEngineConfiguration", DataSource.class, PlatformTransactionManager.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(CmmnEngineAutoConfiguration.class).cmmnEngineConfiguration(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4), args.get(5), args.get(6), args.get(7), args.get(8), args.get(9)));
  }

  /**
   * Get the bean definition for 'cmmnEngineConfiguration'.
   */
  public static BeanDefinition getCmmnEngineConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringCmmnEngineConfiguration.class);
    beanDefinition.setDestroyMethodNames("close");
    beanDefinition.setInstanceSupplier(getCmmnEngineConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link CmmnEngineAutoConfiguration.CmmnEngineAppConfiguration}.
   */
  @Generated
  public static class CmmnEngineAppConfiguration {
    /**
     * Get the bean definition for 'cmmnEngineAppConfiguration'.
     */
    public static BeanDefinition getCmmnEngineAppConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(CmmnEngineAutoConfiguration.CmmnEngineAppConfiguration.class);
      InstanceSupplier<CmmnEngineAutoConfiguration.CmmnEngineAppConfiguration> instanceSupplier = InstanceSupplier.using(CmmnEngineAutoConfiguration.CmmnEngineAppConfiguration::new);
      instanceSupplier = instanceSupplier.andThen(CmmnEngineAutoConfiguration_CmmnEngineAppConfiguration__Autowiring::apply);
      beanDefinition.setInstanceSupplier(instanceSupplier);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'cmmnAppEngineConfigurationConfigurer'.
     */
    private static BeanInstanceSupplier<EngineConfigurationConfigurer> getCmmnAppEngineConfigurationConfigurerInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<EngineConfigurationConfigurer>forFactoryMethod(CmmnEngineAutoConfiguration.CmmnEngineAppConfiguration.class, "cmmnAppEngineConfigurationConfigurer", CmmnEngineConfigurator.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(CmmnEngineAutoConfiguration.CmmnEngineAppConfiguration.class).cmmnAppEngineConfigurationConfigurer(args.get(0)));
    }

    /**
     * Get the bean definition for 'cmmnAppEngineConfigurationConfigurer'.
     */
    public static BeanDefinition getCmmnAppEngineConfigurationConfigurerBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(EngineConfigurationConfigurer.class);
      beanDefinition.setTargetType(ResolvableType.forClassWithGenerics(EngineConfigurationConfigurer.class, SpringAppEngineConfiguration.class));
      beanDefinition.setInstanceSupplier(getCmmnAppEngineConfigurationConfigurerInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'cmmnEngineConfigurator'.
     */
    private static BeanInstanceSupplier<CmmnEngineConfigurator> getCmmnEngineConfiguratorInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<CmmnEngineConfigurator>forFactoryMethod(CmmnEngineAutoConfiguration.CmmnEngineAppConfiguration.class, "cmmnEngineConfigurator", SpringCmmnEngineConfiguration.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(CmmnEngineAutoConfiguration.CmmnEngineAppConfiguration.class).cmmnEngineConfigurator(args.get(0)));
    }

    /**
     * Get the bean definition for 'cmmnEngineConfigurator'.
     */
    public static BeanDefinition getCmmnEngineConfiguratorBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(CmmnEngineConfigurator.class);
      beanDefinition.setInstanceSupplier(getCmmnEngineConfiguratorInstanceSupplier());
      return beanDefinition;
    }
  }
}
