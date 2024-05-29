package org.flowable.spring.boot;

import org.flowable.app.engine.AppEngine;
import org.flowable.engine.DynamicBpmnService;
import org.flowable.engine.FormService;
import org.flowable.engine.HistoryService;
import org.flowable.engine.IdentityService;
import org.flowable.engine.ManagementService;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessMigrationService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ProcessEngineServicesAutoConfiguration}.
 */
@Generated
public class ProcessEngineServicesAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'processEngineServicesAutoConfiguration'.
   */
  public static BeanDefinition getProcessEngineServicesAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ProcessEngineServicesAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(ProcessEngineServicesAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'runtimeServiceBean'.
   */
  private static BeanInstanceSupplier<RuntimeService> getRuntimeServiceBeanInstanceSupplier() {
    return BeanInstanceSupplier.<RuntimeService>forFactoryMethod(ProcessEngineServicesAutoConfiguration.class, "runtimeServiceBean", ProcessEngine.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ProcessEngineServicesAutoConfiguration.class).runtimeServiceBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'runtimeServiceBean'.
   */
  public static BeanDefinition getRuntimeServiceBeanBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RuntimeService.class);
    beanDefinition.setInstanceSupplier(getRuntimeServiceBeanInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'repositoryServiceBean'.
   */
  private static BeanInstanceSupplier<RepositoryService> getRepositoryServiceBeanInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RepositoryService>forFactoryMethod(ProcessEngineServicesAutoConfiguration.class, "repositoryServiceBean", ProcessEngine.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ProcessEngineServicesAutoConfiguration.class).repositoryServiceBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'repositoryServiceBean'.
   */
  public static BeanDefinition getRepositoryServiceBeanBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RepositoryService.class);
    beanDefinition.setInstanceSupplier(getRepositoryServiceBeanInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'taskServiceBean'.
   */
  private static BeanInstanceSupplier<TaskService> getTaskServiceBeanInstanceSupplier() {
    return BeanInstanceSupplier.<TaskService>forFactoryMethod(ProcessEngineServicesAutoConfiguration.class, "taskServiceBean", ProcessEngine.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ProcessEngineServicesAutoConfiguration.class).taskServiceBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'taskServiceBean'.
   */
  public static BeanDefinition getTaskServiceBeanBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TaskService.class);
    beanDefinition.setInstanceSupplier(getTaskServiceBeanInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'historyServiceBean'.
   */
  private static BeanInstanceSupplier<HistoryService> getHistoryServiceBeanInstanceSupplier() {
    return BeanInstanceSupplier.<HistoryService>forFactoryMethod(ProcessEngineServicesAutoConfiguration.class, "historyServiceBean", ProcessEngine.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ProcessEngineServicesAutoConfiguration.class).historyServiceBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'historyServiceBean'.
   */
  public static BeanDefinition getHistoryServiceBeanBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HistoryService.class);
    beanDefinition.setInstanceSupplier(getHistoryServiceBeanInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'managementServiceBean'.
   */
  private static BeanInstanceSupplier<ManagementService> getManagementServiceBeanInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ManagementService>forFactoryMethod(ProcessEngineServicesAutoConfiguration.class, "managementServiceBean", ProcessEngine.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ProcessEngineServicesAutoConfiguration.class).managementServiceBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'managementServiceBean'.
   */
  public static BeanDefinition getManagementServiceBeanBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ManagementService.class);
    beanDefinition.setInstanceSupplier(getManagementServiceBeanInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'dynamicBpmnServiceBean'.
   */
  private static BeanInstanceSupplier<DynamicBpmnService> getDynamicBpmnServiceBeanInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DynamicBpmnService>forFactoryMethod(ProcessEngineServicesAutoConfiguration.class, "dynamicBpmnServiceBean", ProcessEngine.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ProcessEngineServicesAutoConfiguration.class).dynamicBpmnServiceBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'dynamicBpmnServiceBean'.
   */
  public static BeanDefinition getDynamicBpmnServiceBeanBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DynamicBpmnService.class);
    beanDefinition.setInstanceSupplier(getDynamicBpmnServiceBeanInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'processInstanceMigrationService'.
   */
  private static BeanInstanceSupplier<ProcessMigrationService> getProcessInstanceMigrationServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ProcessMigrationService>forFactoryMethod(ProcessEngineServicesAutoConfiguration.class, "processInstanceMigrationService", ProcessEngine.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ProcessEngineServicesAutoConfiguration.class).processInstanceMigrationService(args.get(0)));
  }

  /**
   * Get the bean definition for 'processInstanceMigrationService'.
   */
  public static BeanDefinition getProcessInstanceMigrationServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ProcessMigrationService.class);
    beanDefinition.setInstanceSupplier(getProcessInstanceMigrationServiceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'formServiceBean'.
   */
  private static BeanInstanceSupplier<FormService> getFormServiceBeanInstanceSupplier() {
    return BeanInstanceSupplier.<FormService>forFactoryMethod(ProcessEngineServicesAutoConfiguration.class, "formServiceBean", ProcessEngine.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ProcessEngineServicesAutoConfiguration.class).formServiceBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'formServiceBean'.
   */
  public static BeanDefinition getFormServiceBeanBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FormService.class);
    beanDefinition.setInstanceSupplier(getFormServiceBeanInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'identityServiceBean'.
   */
  private static BeanInstanceSupplier<IdentityService> getIdentityServiceBeanInstanceSupplier() {
    return BeanInstanceSupplier.<IdentityService>forFactoryMethod(ProcessEngineServicesAutoConfiguration.class, "identityServiceBean", ProcessEngine.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ProcessEngineServicesAutoConfiguration.class).identityServiceBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'identityServiceBean'.
   */
  public static BeanDefinition getIdentityServiceBeanBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(IdentityService.class);
    beanDefinition.setInstanceSupplier(getIdentityServiceBeanInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link ProcessEngineServicesAutoConfiguration.AlreadyInitializedAppEngineConfiguration}.
   */
  @Generated
  public static class AlreadyInitializedAppEngineConfiguration {
    /**
     * Get the bean definition for 'alreadyInitializedAppEngineConfiguration'.
     */
    public static BeanDefinition getAlreadyInitializedAppEngineConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ProcessEngineServicesAutoConfiguration.AlreadyInitializedAppEngineConfiguration.class);
      beanDefinition.setInstanceSupplier(ProcessEngineServicesAutoConfiguration.AlreadyInitializedAppEngineConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'processEngine'.
     */
    private static BeanInstanceSupplier<ProcessEngine> getProcessEngineInstanceSupplier() {
      return BeanInstanceSupplier.<ProcessEngine>forFactoryMethod(ProcessEngineServicesAutoConfiguration.AlreadyInitializedAppEngineConfiguration.class, "processEngine", AppEngine.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ProcessEngineServicesAutoConfiguration.AlreadyInitializedAppEngineConfiguration.class).processEngine(args.get(0)));
    }

    /**
     * Get the bean definition for 'processEngine'.
     */
    public static BeanDefinition getProcessEngineBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ProcessEngine.class);
      beanDefinition.setDestroyMethodNames("close");
      beanDefinition.setInstanceSupplier(getProcessEngineInstanceSupplier());
      return beanDefinition;
    }
  }
}
