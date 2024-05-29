package org.springframework.cloud.client;

import java.util.List;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.cloud.client.actuator.FeaturesEndpoint;
import org.springframework.cloud.client.actuator.HasFeatures;
import org.springframework.cloud.client.discovery.health.DiscoveryClientHealthIndicator;
import org.springframework.cloud.client.discovery.health.DiscoveryClientHealthIndicatorProperties;
import org.springframework.cloud.client.discovery.health.DiscoveryCompositeHealthContributor;

/**
 * Bean definitions for {@link CommonsClientAutoConfiguration}.
 */
@Generated
public class CommonsClientAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'commonsClientAutoConfiguration'.
   */
  public static BeanDefinition getCommonsClientAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CommonsClientAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(CommonsClientAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link CommonsClientAutoConfiguration.ActuatorConfiguration}.
   */
  @Generated
  public static class ActuatorConfiguration {
    /**
     * Get the bean definition for 'actuatorConfiguration'.
     */
    public static BeanDefinition getActuatorConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(CommonsClientAutoConfiguration.ActuatorConfiguration.class);
      InstanceSupplier<CommonsClientAutoConfiguration.ActuatorConfiguration> instanceSupplier = InstanceSupplier.using(CommonsClientAutoConfiguration.ActuatorConfiguration::new);
      instanceSupplier = instanceSupplier.andThen(CommonsClientAutoConfiguration_ActuatorConfiguration__Autowiring::apply);
      beanDefinition.setInstanceSupplier(instanceSupplier);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'featuresEndpoint'.
     */
    private static BeanInstanceSupplier<FeaturesEndpoint> getFeaturesEndpointInstanceSupplier() {
      return BeanInstanceSupplier.<FeaturesEndpoint>forFactoryMethod(CommonsClientAutoConfiguration.ActuatorConfiguration.class, "featuresEndpoint")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(CommonsClientAutoConfiguration.ActuatorConfiguration.class).featuresEndpoint());
    }

    /**
     * Get the bean definition for 'featuresEndpoint'.
     */
    public static BeanDefinition getFeaturesEndpointBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(FeaturesEndpoint.class);
      beanDefinition.setInstanceSupplier(getFeaturesEndpointInstanceSupplier());
      return beanDefinition;
    }
  }

  /**
   * Bean definitions for {@link CommonsClientAutoConfiguration.DiscoveryLoadBalancerConfiguration}.
   */
  @Generated
  public static class DiscoveryLoadBalancerConfiguration {
    /**
     * Get the bean definition for 'discoveryLoadBalancerConfiguration'.
     */
    public static BeanDefinition getDiscoveryLoadBalancerConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(CommonsClientAutoConfiguration.DiscoveryLoadBalancerConfiguration.class);
      beanDefinition.setInstanceSupplier(CommonsClientAutoConfiguration.DiscoveryLoadBalancerConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'discoveryClientHealthIndicator'.
     */
    private static BeanInstanceSupplier<DiscoveryClientHealthIndicator> getDiscoveryClientHealthIndicatorInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<DiscoveryClientHealthIndicator>forFactoryMethod(CommonsClientAutoConfiguration.DiscoveryLoadBalancerConfiguration.class, "discoveryClientHealthIndicator", ObjectProvider.class, DiscoveryClientHealthIndicatorProperties.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(CommonsClientAutoConfiguration.DiscoveryLoadBalancerConfiguration.class).discoveryClientHealthIndicator(args.get(0), args.get(1)));
    }

    /**
     * Get the bean definition for 'discoveryClientHealthIndicator'.
     */
    public static BeanDefinition getDiscoveryClientHealthIndicatorBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(DiscoveryClientHealthIndicator.class);
      beanDefinition.setInstanceSupplier(getDiscoveryClientHealthIndicatorInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'discoveryCompositeHealthContributor'.
     */
    private static BeanInstanceSupplier<DiscoveryCompositeHealthContributor> getDiscoveryCompositeHealthContributorInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<DiscoveryCompositeHealthContributor>forFactoryMethod(CommonsClientAutoConfiguration.DiscoveryLoadBalancerConfiguration.class, "discoveryCompositeHealthContributor", List.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(CommonsClientAutoConfiguration.DiscoveryLoadBalancerConfiguration.class).discoveryCompositeHealthContributor(args.get(0)));
    }

    /**
     * Get the bean definition for 'discoveryCompositeHealthContributor'.
     */
    public static BeanDefinition getDiscoveryCompositeHealthContributorBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(DiscoveryCompositeHealthContributor.class);
      beanDefinition.setInstanceSupplier(getDiscoveryCompositeHealthContributorInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'springCloudCommonsFeatures'.
     */
    private static BeanInstanceSupplier<HasFeatures> getSpringCloudCommonsFeaturesInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<HasFeatures>forFactoryMethod(CommonsClientAutoConfiguration.DiscoveryLoadBalancerConfiguration.class, "springCloudCommonsFeatures")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(CommonsClientAutoConfiguration.DiscoveryLoadBalancerConfiguration.class).springCloudCommonsFeatures());
    }

    /**
     * Get the bean definition for 'springCloudCommonsFeatures'.
     */
    public static BeanDefinition getSpringCloudCommonsFeaturesBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(HasFeatures.class);
      beanDefinition.setInstanceSupplier(getSpringCloudCommonsFeaturesInstanceSupplier());
      return beanDefinition;
    }
  }
}
