package org.flowable.spring.boot.app;

import org.flowable.app.api.AppManagementService;
import org.flowable.app.api.AppRepositoryService;
import org.flowable.app.engine.AppEngine;
import org.flowable.app.spring.AppEngineFactoryBean;
import org.flowable.app.spring.SpringAppEngineConfiguration;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AppEngineServicesAutoConfiguration}.
 */
@Generated
public class AppEngineServicesAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'appEngineServicesAutoConfiguration'.
   */
  public static BeanDefinition getAppEngineServicesAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AppEngineServicesAutoConfiguration.class);
    InstanceSupplier<AppEngineServicesAutoConfiguration> instanceSupplier = InstanceSupplier.using(AppEngineServicesAutoConfiguration::new);
    instanceSupplier = instanceSupplier.andThen(AppEngineServicesAutoConfiguration__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'flowableAppEngine'.
   */
  private static BeanInstanceSupplier<AppEngineFactoryBean> getFlowableAppEngineInstanceSupplier() {
    return BeanInstanceSupplier.<AppEngineFactoryBean>forFactoryMethod(AppEngineServicesAutoConfiguration.class, "appEngine", SpringAppEngineConfiguration.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(AppEngineServicesAutoConfiguration.class).appEngine(args.get(0)));
  }

  /**
   * Get the bean definition for 'flowableAppEngine'.
   */
  public static BeanDefinition getFlowableAppEngineBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AppEngineFactoryBean.class);
    beanDefinition.setInstanceSupplier(getFlowableAppEngineInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'appRepositoryServiceBean'.
   */
  private static BeanInstanceSupplier<AppRepositoryService> getAppRepositoryServiceBeanInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AppRepositoryService>forFactoryMethod(AppEngineServicesAutoConfiguration.class, "appRepositoryServiceBean", AppEngine.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(AppEngineServicesAutoConfiguration.class).appRepositoryServiceBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'appRepositoryServiceBean'.
   */
  public static BeanDefinition getAppRepositoryServiceBeanBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AppRepositoryService.class);
    beanDefinition.setInstanceSupplier(getAppRepositoryServiceBeanInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'appManagementServiceBean'.
   */
  private static BeanInstanceSupplier<AppManagementService> getAppManagementServiceBeanInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AppManagementService>forFactoryMethod(AppEngineServicesAutoConfiguration.class, "appManagementServiceBean", AppEngine.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(AppEngineServicesAutoConfiguration.class).appManagementServiceBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'appManagementServiceBean'.
   */
  public static BeanDefinition getAppManagementServiceBeanBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AppManagementService.class);
    beanDefinition.setInstanceSupplier(getAppManagementServiceBeanInstanceSupplier());
    return beanDefinition;
  }
}
