package org.springframework.cloud.client;

import java.util.Collection;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.cloud.client.actuator.HasFeatures;
import org.springframework.cloud.client.discovery.health.reactive.ReactiveDiscoveryCompositeHealthContributor;

/**
 * Bean definitions for {@link ReactiveCommonsClientAutoConfiguration}.
 */
@Generated
public class ReactiveCommonsClientAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'reactiveCommonsClientAutoConfiguration'.
   */
  public static BeanDefinition getReactiveCommonsClientAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ReactiveCommonsClientAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(ReactiveCommonsClientAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link ReactiveCommonsClientAutoConfiguration.ReactiveDiscoveryLoadBalancerConfiguration}.
   */
  @Generated
  public static class ReactiveDiscoveryLoadBalancerConfiguration {
    /**
     * Get the bean definition for 'reactiveDiscoveryLoadBalancerConfiguration'.
     */
    public static BeanDefinition getReactiveDiscoveryLoadBalancerConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ReactiveCommonsClientAutoConfiguration.ReactiveDiscoveryLoadBalancerConfiguration.class);
      beanDefinition.setInstanceSupplier(ReactiveCommonsClientAutoConfiguration.ReactiveDiscoveryLoadBalancerConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'reactiveDiscoveryClients'.
     */
    private static BeanInstanceSupplier<ReactiveDiscoveryCompositeHealthContributor> getReactiveDiscoveryClientsInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<ReactiveDiscoveryCompositeHealthContributor>forFactoryMethod(ReactiveCommonsClientAutoConfiguration.ReactiveDiscoveryLoadBalancerConfiguration.class, "reactiveDiscoveryClients", Collection.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ReactiveCommonsClientAutoConfiguration.ReactiveDiscoveryLoadBalancerConfiguration.class).reactiveDiscoveryClients(args.get(0)));
    }

    /**
     * Get the bean definition for 'reactiveDiscoveryClients'.
     */
    public static BeanDefinition getReactiveDiscoveryClientsBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ReactiveDiscoveryCompositeHealthContributor.class);
      beanDefinition.setInstanceSupplier(getReactiveDiscoveryClientsInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'reactiveCommonsFeatures'.
     */
    private static BeanInstanceSupplier<HasFeatures> getReactiveCommonsFeaturesInstanceSupplier() {
      return BeanInstanceSupplier.<HasFeatures>forFactoryMethod(ReactiveCommonsClientAutoConfiguration.ReactiveDiscoveryLoadBalancerConfiguration.class, "reactiveCommonsFeatures")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(ReactiveCommonsClientAutoConfiguration.ReactiveDiscoveryLoadBalancerConfiguration.class).reactiveCommonsFeatures());
    }

    /**
     * Get the bean definition for 'reactiveCommonsFeatures'.
     */
    public static BeanDefinition getReactiveCommonsFeaturesBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(HasFeatures.class);
      beanDefinition.setInstanceSupplier(getReactiveCommonsFeaturesInstanceSupplier());
      return beanDefinition;
    }
  }
}
