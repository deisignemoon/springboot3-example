package com.alibaba.cloud.nacos.discovery;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.cloud.client.discovery.DiscoveryClient;

/**
 * Bean definitions for {@link NacosDiscoveryClientConfiguration}.
 */
@Generated
public class NacosDiscoveryClientConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'nacosDiscoveryClientConfiguration'.
   */
  public static BeanDefinition getNacosDiscoveryClientConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NacosDiscoveryClientConfiguration.class);
    beanDefinition.setInstanceSupplier(NacosDiscoveryClientConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'nacosDiscoveryClient'.
   */
  private static BeanInstanceSupplier<DiscoveryClient> getNacosDiscoveryClientInstanceSupplier() {
    return BeanInstanceSupplier.<DiscoveryClient>forFactoryMethod(NacosDiscoveryClientConfiguration.class, "nacosDiscoveryClient", NacosServiceDiscovery.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(NacosDiscoveryClientConfiguration.class).nacosDiscoveryClient(args.get(0)));
  }

  /**
   * Get the bean definition for 'nacosDiscoveryClient'.
   */
  public static BeanDefinition getNacosDiscoveryClientBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DiscoveryClient.class);
    beanDefinition.setInstanceSupplier(getNacosDiscoveryClientInstanceSupplier());
    return beanDefinition;
  }
}
