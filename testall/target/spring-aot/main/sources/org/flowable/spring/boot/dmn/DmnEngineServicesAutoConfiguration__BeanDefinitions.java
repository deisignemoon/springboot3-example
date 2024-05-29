package org.flowable.spring.boot.dmn;

import org.flowable.app.engine.AppEngine;
import org.flowable.dmn.api.DmnDecisionService;
import org.flowable.dmn.api.DmnHistoryService;
import org.flowable.dmn.api.DmnManagementService;
import org.flowable.dmn.api.DmnRepositoryService;
import org.flowable.dmn.engine.DmnEngine;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DmnEngineServicesAutoConfiguration}.
 */
@Generated
public class DmnEngineServicesAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'dmnEngineServicesAutoConfiguration'.
   */
  public static BeanDefinition getDmnEngineServicesAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DmnEngineServicesAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(DmnEngineServicesAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'dmnManagementService'.
   */
  private static BeanInstanceSupplier<DmnManagementService> getDmnManagementServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DmnManagementService>forFactoryMethod(DmnEngineServicesAutoConfiguration.class, "dmnManagementService", DmnEngine.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(DmnEngineServicesAutoConfiguration.class).dmnManagementService(args.get(0)));
  }

  /**
   * Get the bean definition for 'dmnManagementService'.
   */
  public static BeanDefinition getDmnManagementServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DmnManagementService.class);
    beanDefinition.setInstanceSupplier(getDmnManagementServiceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'dmnRepositoryService'.
   */
  private static BeanInstanceSupplier<DmnRepositoryService> getDmnRepositoryServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DmnRepositoryService>forFactoryMethod(DmnEngineServicesAutoConfiguration.class, "dmnRepositoryService", DmnEngine.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(DmnEngineServicesAutoConfiguration.class).dmnRepositoryService(args.get(0)));
  }

  /**
   * Get the bean definition for 'dmnRepositoryService'.
   */
  public static BeanDefinition getDmnRepositoryServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DmnRepositoryService.class);
    beanDefinition.setInstanceSupplier(getDmnRepositoryServiceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'dmnRuleService'.
   */
  private static BeanInstanceSupplier<DmnDecisionService> getDmnRuleServiceInstanceSupplier() {
    return BeanInstanceSupplier.<DmnDecisionService>forFactoryMethod(DmnEngineServicesAutoConfiguration.class, "dmnRuleService", DmnEngine.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(DmnEngineServicesAutoConfiguration.class).dmnRuleService(args.get(0)));
  }

  /**
   * Get the bean definition for 'dmnRuleService'.
   */
  public static BeanDefinition getDmnRuleServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DmnDecisionService.class);
    beanDefinition.setInstanceSupplier(getDmnRuleServiceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'dmnHistoryService'.
   */
  private static BeanInstanceSupplier<DmnHistoryService> getDmnHistoryServiceInstanceSupplier() {
    return BeanInstanceSupplier.<DmnHistoryService>forFactoryMethod(DmnEngineServicesAutoConfiguration.class, "dmnHistoryService", DmnEngine.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(DmnEngineServicesAutoConfiguration.class).dmnHistoryService(args.get(0)));
  }

  /**
   * Get the bean definition for 'dmnHistoryService'.
   */
  public static BeanDefinition getDmnHistoryServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DmnHistoryService.class);
    beanDefinition.setInstanceSupplier(getDmnHistoryServiceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link DmnEngineServicesAutoConfiguration.AlreadyInitializedAppEngineConfiguration}.
   */
  @Generated
  public static class AlreadyInitializedAppEngineConfiguration {
    /**
     * Get the bean definition for 'alreadyInitializedAppEngineConfiguration'.
     */
    public static BeanDefinition getAlreadyInitializedAppEngineConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(DmnEngineServicesAutoConfiguration.AlreadyInitializedAppEngineConfiguration.class);
      beanDefinition.setInstanceSupplier(DmnEngineServicesAutoConfiguration.AlreadyInitializedAppEngineConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'dmnEngine'.
     */
    private static BeanInstanceSupplier<DmnEngine> getDmnEngineInstanceSupplier() {
      return BeanInstanceSupplier.<DmnEngine>forFactoryMethod(DmnEngineServicesAutoConfiguration.AlreadyInitializedAppEngineConfiguration.class, "dmnEngine", AppEngine.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(DmnEngineServicesAutoConfiguration.AlreadyInitializedAppEngineConfiguration.class).dmnEngine(args.get(0)));
    }

    /**
     * Get the bean definition for 'dmnEngine'.
     */
    public static BeanDefinition getDmnEngineBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(DmnEngine.class);
      beanDefinition.setDestroyMethodNames("close");
      beanDefinition.setInstanceSupplier(getDmnEngineInstanceSupplier());
      return beanDefinition;
    }
  }
}
