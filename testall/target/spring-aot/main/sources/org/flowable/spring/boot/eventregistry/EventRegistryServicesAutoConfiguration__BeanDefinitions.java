package org.flowable.spring.boot.eventregistry;

import org.flowable.app.engine.AppEngine;
import org.flowable.eventregistry.api.EventManagementService;
import org.flowable.eventregistry.api.EventRegistry;
import org.flowable.eventregistry.api.EventRepositoryService;
import org.flowable.eventregistry.impl.EventRegistryEngine;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link EventRegistryServicesAutoConfiguration}.
 */
@Generated
public class EventRegistryServicesAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'eventRegistryServicesAutoConfiguration'.
   */
  public static BeanDefinition getEventRegistryServicesAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(EventRegistryServicesAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(EventRegistryServicesAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'eventRepositoryService'.
   */
  private static BeanInstanceSupplier<EventRepositoryService> getEventRepositoryServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<EventRepositoryService>forFactoryMethod(EventRegistryServicesAutoConfiguration.class, "eventRepositoryService", EventRegistryEngine.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(EventRegistryServicesAutoConfiguration.class).eventRepositoryService(args.get(0)));
  }

  /**
   * Get the bean definition for 'eventRepositoryService'.
   */
  public static BeanDefinition getEventRepositoryServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(EventRepositoryService.class);
    beanDefinition.setInstanceSupplier(getEventRepositoryServiceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'eventManagementService'.
   */
  private static BeanInstanceSupplier<EventManagementService> getEventManagementServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<EventManagementService>forFactoryMethod(EventRegistryServicesAutoConfiguration.class, "eventManagementService", EventRegistryEngine.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(EventRegistryServicesAutoConfiguration.class).eventManagementService(args.get(0)));
  }

  /**
   * Get the bean definition for 'eventManagementService'.
   */
  public static BeanDefinition getEventManagementServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(EventManagementService.class);
    beanDefinition.setInstanceSupplier(getEventManagementServiceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'eventRegistry'.
   */
  private static BeanInstanceSupplier<EventRegistry> getEventRegistryInstanceSupplier() {
    return BeanInstanceSupplier.<EventRegistry>forFactoryMethod(EventRegistryServicesAutoConfiguration.class, "eventRegistry", EventRegistryEngine.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(EventRegistryServicesAutoConfiguration.class).eventRegistry(args.get(0)));
  }

  /**
   * Get the bean definition for 'eventRegistry'.
   */
  public static BeanDefinition getEventRegistryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(EventRegistry.class);
    beanDefinition.setInstanceSupplier(getEventRegistryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link EventRegistryServicesAutoConfiguration.AlreadyInitializedAppEngineConfiguration}.
   */
  @Generated
  public static class AlreadyInitializedAppEngineConfiguration {
    /**
     * Get the bean definition for 'alreadyInitializedAppEngineConfiguration'.
     */
    public static BeanDefinition getAlreadyInitializedAppEngineConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(EventRegistryServicesAutoConfiguration.AlreadyInitializedAppEngineConfiguration.class);
      beanDefinition.setInstanceSupplier(EventRegistryServicesAutoConfiguration.AlreadyInitializedAppEngineConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'eventRegistryEngine'.
     */
    private static BeanInstanceSupplier<EventRegistryEngine> getEventRegistryEngineInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<EventRegistryEngine>forFactoryMethod(EventRegistryServicesAutoConfiguration.AlreadyInitializedAppEngineConfiguration.class, "eventRegistryEngine", AppEngine.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(EventRegistryServicesAutoConfiguration.AlreadyInitializedAppEngineConfiguration.class).eventRegistryEngine(args.get(0)));
    }

    /**
     * Get the bean definition for 'eventRegistryEngine'.
     */
    public static BeanDefinition getEventRegistryEngineBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(EventRegistryEngine.class);
      beanDefinition.setDestroyMethodNames("close");
      beanDefinition.setInstanceSupplier(getEventRegistryEngineInstanceSupplier());
      return beanDefinition;
    }
  }
}
