package org.flowable.spring.boot.eventregistry;

import javax.sql.DataSource;
import org.flowable.app.spring.SpringAppEngineConfiguration;
import org.flowable.eventregistry.impl.configurator.EventRegistryEngineConfigurator;
import org.flowable.eventregistry.spring.SpringEventRegistryEngineConfiguration;
import org.flowable.spring.boot.EngineConfigurationConfigurer;
import org.flowable.spring.boot.FlowableAutoDeploymentProperties;
import org.flowable.spring.boot.FlowableProperties;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Bean definitions for {@link EventRegistryAutoConfiguration}.
 */
@Generated
public class EventRegistryAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.flowable.spring.boot.eventregistry.EventRegistryAutoConfiguration'.
   */
  private static BeanInstanceSupplier<EventRegistryAutoConfiguration> getEventRegistryAutoConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<EventRegistryAutoConfiguration>forConstructor(FlowableProperties.class, FlowableEventRegistryProperties.class, FlowableAutoDeploymentProperties.class)
            .withGenerator((registeredBean, args) -> new EventRegistryAutoConfiguration(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'eventRegistryAutoConfiguration'.
   */
  public static BeanDefinition getEventRegistryAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(EventRegistryAutoConfiguration.class);
    InstanceSupplier<EventRegistryAutoConfiguration> instanceSupplier = getEventRegistryAutoConfigurationInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(EventRegistryAutoConfiguration__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'eventEngineConfiguration'.
   */
  private static BeanInstanceSupplier<SpringEventRegistryEngineConfiguration> getEventEngineConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SpringEventRegistryEngineConfiguration>forFactoryMethod(EventRegistryAutoConfiguration.class, "eventEngineConfiguration", DataSource.class, PlatformTransactionManager.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(EventRegistryAutoConfiguration.class).eventEngineConfiguration(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4), args.get(5)));
  }

  /**
   * Get the bean definition for 'eventEngineConfiguration'.
   */
  public static BeanDefinition getEventEngineConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringEventRegistryEngineConfiguration.class);
    beanDefinition.setDestroyMethodNames("close");
    beanDefinition.setInstanceSupplier(getEventEngineConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link EventRegistryAutoConfiguration.EventRegistryAppEngineConfiguration}.
   */
  @Generated
  public static class EventRegistryAppEngineConfiguration {
    /**
     * Get the bean definition for 'eventRegistryAppEngineConfiguration'.
     */
    public static BeanDefinition getEventRegistryAppEngineConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(EventRegistryAutoConfiguration.EventRegistryAppEngineConfiguration.class);
      InstanceSupplier<EventRegistryAutoConfiguration.EventRegistryAppEngineConfiguration> instanceSupplier = InstanceSupplier.using(EventRegistryAutoConfiguration.EventRegistryAppEngineConfiguration::new);
      instanceSupplier = instanceSupplier.andThen(EventRegistryAutoConfiguration_EventRegistryAppEngineConfiguration__Autowiring::apply);
      beanDefinition.setInstanceSupplier(instanceSupplier);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'eventAppEngineConfigurationConfigurer'.
     */
    private static BeanInstanceSupplier<EngineConfigurationConfigurer> getEventAppEngineConfigurationConfigurerInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<EngineConfigurationConfigurer>forFactoryMethod(EventRegistryAutoConfiguration.EventRegistryAppEngineConfiguration.class, "eventAppEngineConfigurationConfigurer", EventRegistryEngineConfigurator.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(EventRegistryAutoConfiguration.EventRegistryAppEngineConfiguration.class).eventAppEngineConfigurationConfigurer(args.get(0)));
    }

    /**
     * Get the bean definition for 'eventAppEngineConfigurationConfigurer'.
     */
    public static BeanDefinition getEventAppEngineConfigurationConfigurerBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(EngineConfigurationConfigurer.class);
      beanDefinition.setTargetType(ResolvableType.forClassWithGenerics(EngineConfigurationConfigurer.class, SpringAppEngineConfiguration.class));
      beanDefinition.setInstanceSupplier(getEventAppEngineConfigurationConfigurerInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'eventEngineConfigurator'.
     */
    private static BeanInstanceSupplier<EventRegistryEngineConfigurator> getEventEngineConfiguratorInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<EventRegistryEngineConfigurator>forFactoryMethod(EventRegistryAutoConfiguration.EventRegistryAppEngineConfiguration.class, "eventEngineConfigurator", SpringEventRegistryEngineConfiguration.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(EventRegistryAutoConfiguration.EventRegistryAppEngineConfiguration.class).eventEngineConfigurator(args.get(0)));
    }

    /**
     * Get the bean definition for 'eventEngineConfigurator'.
     */
    public static BeanDefinition getEventEngineConfiguratorBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(EventRegistryEngineConfigurator.class);
      beanDefinition.setInstanceSupplier(getEventEngineConfiguratorInstanceSupplier());
      return beanDefinition;
    }
  }
}
