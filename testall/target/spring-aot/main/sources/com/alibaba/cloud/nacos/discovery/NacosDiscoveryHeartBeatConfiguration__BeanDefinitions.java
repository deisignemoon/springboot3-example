package com.alibaba.cloud.nacos.discovery;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link NacosDiscoveryHeartBeatConfiguration}.
 */
@Generated
public class NacosDiscoveryHeartBeatConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'nacosDiscoveryHeartBeatConfiguration'.
   */
  public static BeanDefinition getNacosDiscoveryHeartBeatConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NacosDiscoveryHeartBeatConfiguration.class);
    beanDefinition.setInstanceSupplier(NacosDiscoveryHeartBeatConfiguration::new);
    return beanDefinition;
  }
}
