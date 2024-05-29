package org.flowable.spring.boot.cmmn;

import org.flowable.app.engine.AppEngine;
import org.flowable.cmmn.api.CmmnHistoryService;
import org.flowable.cmmn.api.CmmnManagementService;
import org.flowable.cmmn.api.CmmnMigrationService;
import org.flowable.cmmn.api.CmmnRepositoryService;
import org.flowable.cmmn.api.CmmnRuntimeService;
import org.flowable.cmmn.api.CmmnTaskService;
import org.flowable.cmmn.api.DynamicCmmnService;
import org.flowable.cmmn.engine.CmmnEngine;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CmmnEngineServicesAutoConfiguration}.
 */
@Generated
public class CmmnEngineServicesAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'cmmnEngineServicesAutoConfiguration'.
   */
  public static BeanDefinition getCmmnEngineServicesAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CmmnEngineServicesAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(CmmnEngineServicesAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'cmmnRuntimeService'.
   */
  private static BeanInstanceSupplier<CmmnRuntimeService> getCmmnRuntimeServiceInstanceSupplier() {
    return BeanInstanceSupplier.<CmmnRuntimeService>forFactoryMethod(CmmnEngineServicesAutoConfiguration.class, "cmmnRuntimeService", CmmnEngine.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(CmmnEngineServicesAutoConfiguration.class).cmmnRuntimeService(args.get(0)));
  }

  /**
   * Get the bean definition for 'cmmnRuntimeService'.
   */
  public static BeanDefinition getCmmnRuntimeServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CmmnRuntimeService.class);
    beanDefinition.setInstanceSupplier(getCmmnRuntimeServiceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'dynamicCmmnService'.
   */
  private static BeanInstanceSupplier<DynamicCmmnService> getDynamicCmmnServiceInstanceSupplier() {
    return BeanInstanceSupplier.<DynamicCmmnService>forFactoryMethod(CmmnEngineServicesAutoConfiguration.class, "dynamicCmmnService", CmmnEngine.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(CmmnEngineServicesAutoConfiguration.class).dynamicCmmnService(args.get(0)));
  }

  /**
   * Get the bean definition for 'dynamicCmmnService'.
   */
  public static BeanDefinition getDynamicCmmnServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DynamicCmmnService.class);
    beanDefinition.setInstanceSupplier(getDynamicCmmnServiceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'cmmnTaskService'.
   */
  private static BeanInstanceSupplier<CmmnTaskService> getCmmnTaskServiceInstanceSupplier() {
    return BeanInstanceSupplier.<CmmnTaskService>forFactoryMethod(CmmnEngineServicesAutoConfiguration.class, "cmmnTaskService", CmmnEngine.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(CmmnEngineServicesAutoConfiguration.class).cmmnTaskService(args.get(0)));
  }

  /**
   * Get the bean definition for 'cmmnTaskService'.
   */
  public static BeanDefinition getCmmnTaskServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CmmnTaskService.class);
    beanDefinition.setInstanceSupplier(getCmmnTaskServiceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'cmmnManagementService'.
   */
  private static BeanInstanceSupplier<CmmnManagementService> getCmmnManagementServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<CmmnManagementService>forFactoryMethod(CmmnEngineServicesAutoConfiguration.class, "cmmnManagementService", CmmnEngine.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(CmmnEngineServicesAutoConfiguration.class).cmmnManagementService(args.get(0)));
  }

  /**
   * Get the bean definition for 'cmmnManagementService'.
   */
  public static BeanDefinition getCmmnManagementServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CmmnManagementService.class);
    beanDefinition.setInstanceSupplier(getCmmnManagementServiceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'cmmnRepositoryService'.
   */
  private static BeanInstanceSupplier<CmmnRepositoryService> getCmmnRepositoryServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<CmmnRepositoryService>forFactoryMethod(CmmnEngineServicesAutoConfiguration.class, "cmmnRepositoryService", CmmnEngine.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(CmmnEngineServicesAutoConfiguration.class).cmmnRepositoryService(args.get(0)));
  }

  /**
   * Get the bean definition for 'cmmnRepositoryService'.
   */
  public static BeanDefinition getCmmnRepositoryServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CmmnRepositoryService.class);
    beanDefinition.setInstanceSupplier(getCmmnRepositoryServiceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'cmmnHistoryService'.
   */
  private static BeanInstanceSupplier<CmmnHistoryService> getCmmnHistoryServiceInstanceSupplier() {
    return BeanInstanceSupplier.<CmmnHistoryService>forFactoryMethod(CmmnEngineServicesAutoConfiguration.class, "cmmnHistoryService", CmmnEngine.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(CmmnEngineServicesAutoConfiguration.class).cmmnHistoryService(args.get(0)));
  }

  /**
   * Get the bean definition for 'cmmnHistoryService'.
   */
  public static BeanDefinition getCmmnHistoryServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CmmnHistoryService.class);
    beanDefinition.setInstanceSupplier(getCmmnHistoryServiceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'cmmnMigrationService'.
   */
  private static BeanInstanceSupplier<CmmnMigrationService> getCmmnMigrationServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<CmmnMigrationService>forFactoryMethod(CmmnEngineServicesAutoConfiguration.class, "cmmnMigrationService", CmmnEngine.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(CmmnEngineServicesAutoConfiguration.class).cmmnMigrationService(args.get(0)));
  }

  /**
   * Get the bean definition for 'cmmnMigrationService'.
   */
  public static BeanDefinition getCmmnMigrationServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CmmnMigrationService.class);
    beanDefinition.setInstanceSupplier(getCmmnMigrationServiceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link CmmnEngineServicesAutoConfiguration.AlreadyInitializedAppEngineConfiguration}.
   */
  @Generated
  public static class AlreadyInitializedAppEngineConfiguration {
    /**
     * Get the bean definition for 'alreadyInitializedAppEngineConfiguration'.
     */
    public static BeanDefinition getAlreadyInitializedAppEngineConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(CmmnEngineServicesAutoConfiguration.AlreadyInitializedAppEngineConfiguration.class);
      beanDefinition.setInstanceSupplier(CmmnEngineServicesAutoConfiguration.AlreadyInitializedAppEngineConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'cmmnEngine'.
     */
    private static BeanInstanceSupplier<CmmnEngine> getCmmnEngineInstanceSupplier() {
      return BeanInstanceSupplier.<CmmnEngine>forFactoryMethod(CmmnEngineServicesAutoConfiguration.AlreadyInitializedAppEngineConfiguration.class, "cmmnEngine", AppEngine.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(CmmnEngineServicesAutoConfiguration.AlreadyInitializedAppEngineConfiguration.class).cmmnEngine(args.get(0)));
    }

    /**
     * Get the bean definition for 'cmmnEngine'.
     */
    public static BeanDefinition getCmmnEngineBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(CmmnEngine.class);
      beanDefinition.setDestroyMethodNames("close");
      beanDefinition.setInstanceSupplier(getCmmnEngineInstanceSupplier());
      return beanDefinition;
    }
  }
}
