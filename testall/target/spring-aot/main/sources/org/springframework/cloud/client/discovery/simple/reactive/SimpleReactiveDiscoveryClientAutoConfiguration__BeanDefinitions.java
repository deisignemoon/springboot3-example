package org.springframework.cloud.client.discovery.simple.reactive;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.cloud.client.discovery.health.DiscoveryClientHealthIndicatorProperties;
import org.springframework.cloud.client.discovery.health.reactive.ReactiveDiscoveryClientHealthIndicator;

/**
 * Bean definitions for {@link SimpleReactiveDiscoveryClientAutoConfiguration}.
 */
@Generated
public class SimpleReactiveDiscoveryClientAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'simpleReactiveDiscoveryClientAutoConfiguration'.
   */
  public static BeanDefinition getSimpleReactiveDiscoveryClientAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SimpleReactiveDiscoveryClientAutoConfiguration.class);
    InstanceSupplier<SimpleReactiveDiscoveryClientAutoConfiguration> instanceSupplier = InstanceSupplier.using(SimpleReactiveDiscoveryClientAutoConfiguration::new);
    instanceSupplier = instanceSupplier.andThen(SimpleReactiveDiscoveryClientAutoConfiguration__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'simpleReactiveDiscoveryProperties'.
   */
  private static BeanInstanceSupplier<SimpleReactiveDiscoveryProperties> getSimpleReactiveDiscoveryPropertiesInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SimpleReactiveDiscoveryProperties>forFactoryMethod(SimpleReactiveDiscoveryClientAutoConfiguration.class, "simpleReactiveDiscoveryProperties")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(SimpleReactiveDiscoveryClientAutoConfiguration.class).simpleReactiveDiscoveryProperties());
  }

  /**
   * Get the bean definition for 'simpleReactiveDiscoveryProperties'.
   */
  public static BeanDefinition getSimpleReactiveDiscoveryPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SimpleReactiveDiscoveryProperties.class);
    beanDefinition.setInstanceSupplier(getSimpleReactiveDiscoveryPropertiesInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'simpleReactiveDiscoveryClient'.
   */
  private static BeanInstanceSupplier<SimpleReactiveDiscoveryClient> getSimpleReactiveDiscoveryClientInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SimpleReactiveDiscoveryClient>forFactoryMethod(SimpleReactiveDiscoveryClientAutoConfiguration.class, "simpleReactiveDiscoveryClient", SimpleReactiveDiscoveryProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SimpleReactiveDiscoveryClientAutoConfiguration.class).simpleReactiveDiscoveryClient(args.get(0)));
  }

  /**
   * Get the bean definition for 'simpleReactiveDiscoveryClient'.
   */
  public static BeanDefinition getSimpleReactiveDiscoveryClientBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SimpleReactiveDiscoveryClient.class);
    beanDefinition.setInstanceSupplier(getSimpleReactiveDiscoveryClientInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link SimpleReactiveDiscoveryClientAutoConfiguration.HealthConfiguration}.
   */
  @Generated
  public static class HealthConfiguration {
    /**
     * Get the bean definition for 'healthConfiguration'.
     */
    public static BeanDefinition getHealthConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(SimpleReactiveDiscoveryClientAutoConfiguration.HealthConfiguration.class);
      beanDefinition.setInstanceSupplier(SimpleReactiveDiscoveryClientAutoConfiguration.HealthConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'simpleReactiveDiscoveryClientHealthIndicator'.
     */
    private static BeanInstanceSupplier<ReactiveDiscoveryClientHealthIndicator> getSimpleReactiveDiscoveryClientHealthIndicatorInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<ReactiveDiscoveryClientHealthIndicator>forFactoryMethod(SimpleReactiveDiscoveryClientAutoConfiguration.HealthConfiguration.class, "simpleReactiveDiscoveryClientHealthIndicator", DiscoveryClientHealthIndicatorProperties.class, SimpleReactiveDiscoveryClient.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SimpleReactiveDiscoveryClientAutoConfiguration.HealthConfiguration.class).simpleReactiveDiscoveryClientHealthIndicator(args.get(0), args.get(1)));
    }

    /**
     * Get the bean definition for 'simpleReactiveDiscoveryClientHealthIndicator'.
     */
    public static BeanDefinition getSimpleReactiveDiscoveryClientHealthIndicatorBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ReactiveDiscoveryClientHealthIndicator.class);
      beanDefinition.setInstanceSupplier(getSimpleReactiveDiscoveryClientHealthIndicatorInstanceSupplier());
      return beanDefinition;
    }
  }
}
