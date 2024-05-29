package com.alibaba.cloud.nacos.endpoint;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.NacosServiceManager;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.actuate.health.HealthIndicator;

/**
 * Bean definitions for {@link NacosDiscoveryEndpointAutoConfiguration}.
 */
@Generated
public class NacosDiscoveryEndpointAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'nacosDiscoveryEndpointAutoConfiguration'.
   */
  public static BeanDefinition getNacosDiscoveryEndpointAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NacosDiscoveryEndpointAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(NacosDiscoveryEndpointAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'nacosDiscoveryEndpoint'.
   */
  private static BeanInstanceSupplier<NacosDiscoveryEndpoint> getNacosDiscoveryEndpointInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<NacosDiscoveryEndpoint>forFactoryMethod(NacosDiscoveryEndpointAutoConfiguration.class, "nacosDiscoveryEndpoint", NacosServiceManager.class, NacosDiscoveryProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(NacosDiscoveryEndpointAutoConfiguration.class).nacosDiscoveryEndpoint(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'nacosDiscoveryEndpoint'.
   */
  public static BeanDefinition getNacosDiscoveryEndpointBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NacosDiscoveryEndpoint.class);
    beanDefinition.setInstanceSupplier(getNacosDiscoveryEndpointInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'nacosDiscoveryHealthIndicator'.
   */
  private static BeanInstanceSupplier<HealthIndicator> getNacosDiscoveryHealthIndicatorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<HealthIndicator>forFactoryMethod(NacosDiscoveryEndpointAutoConfiguration.class, "nacosDiscoveryHealthIndicator", NacosServiceManager.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(NacosDiscoveryEndpointAutoConfiguration.class).nacosDiscoveryHealthIndicator(args.get(0)));
  }

  /**
   * Get the bean definition for 'nacosDiscoveryHealthIndicator'.
   */
  public static BeanDefinition getNacosDiscoveryHealthIndicatorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HealthIndicator.class);
    beanDefinition.setInstanceSupplier(getNacosDiscoveryHealthIndicatorInstanceSupplier());
    return beanDefinition;
  }
}
