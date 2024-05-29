package org.flowable.spring.boot.idm;

import org.flowable.app.engine.AppEngine;
import org.flowable.idm.api.IdmIdentityService;
import org.flowable.idm.api.IdmManagementService;
import org.flowable.idm.engine.IdmEngine;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link IdmEngineServicesAutoConfiguration}.
 */
@Generated
public class IdmEngineServicesAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'idmEngineServicesAutoConfiguration'.
   */
  public static BeanDefinition getIdmEngineServicesAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(IdmEngineServicesAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(IdmEngineServicesAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'idmManagementService'.
   */
  private static BeanInstanceSupplier<IdmManagementService> getIdmManagementServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<IdmManagementService>forFactoryMethod(IdmEngineServicesAutoConfiguration.class, "idmManagementService", IdmEngine.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(IdmEngineServicesAutoConfiguration.class).idmManagementService(args.get(0)));
  }

  /**
   * Get the bean definition for 'idmManagementService'.
   */
  public static BeanDefinition getIdmManagementServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(IdmManagementService.class);
    beanDefinition.setInstanceSupplier(getIdmManagementServiceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'idmIdentityService'.
   */
  private static BeanInstanceSupplier<IdmIdentityService> getIdmIdentityServiceInstanceSupplier() {
    return BeanInstanceSupplier.<IdmIdentityService>forFactoryMethod(IdmEngineServicesAutoConfiguration.class, "idmIdentityService", IdmEngine.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(IdmEngineServicesAutoConfiguration.class).idmIdentityService(args.get(0)));
  }

  /**
   * Get the bean definition for 'idmIdentityService'.
   */
  public static BeanDefinition getIdmIdentityServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(IdmIdentityService.class);
    beanDefinition.setInstanceSupplier(getIdmIdentityServiceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link IdmEngineServicesAutoConfiguration.AlreadyInitializedAppEngineConfiguration}.
   */
  @Generated
  public static class AlreadyInitializedAppEngineConfiguration {
    /**
     * Get the bean definition for 'alreadyInitializedAppEngineConfiguration'.
     */
    public static BeanDefinition getAlreadyInitializedAppEngineConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(IdmEngineServicesAutoConfiguration.AlreadyInitializedAppEngineConfiguration.class);
      beanDefinition.setInstanceSupplier(IdmEngineServicesAutoConfiguration.AlreadyInitializedAppEngineConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'idmEngine'.
     */
    private static BeanInstanceSupplier<IdmEngine> getIdmEngineInstanceSupplier() {
      return BeanInstanceSupplier.<IdmEngine>forFactoryMethod(IdmEngineServicesAutoConfiguration.AlreadyInitializedAppEngineConfiguration.class, "idmEngine", AppEngine.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(IdmEngineServicesAutoConfiguration.AlreadyInitializedAppEngineConfiguration.class).idmEngine(args.get(0)));
    }

    /**
     * Get the bean definition for 'idmEngine'.
     */
    public static BeanDefinition getIdmEngineBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(IdmEngine.class);
      beanDefinition.setDestroyMethodNames("close");
      beanDefinition.setInstanceSupplier(getIdmEngineInstanceSupplier());
      return beanDefinition;
    }
  }
}
