package com.alibaba.cloud.nacos.discovery.reactive;

import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link NacosReactiveDiscoveryClientConfiguration}.
 */
@Generated
public class NacosReactiveDiscoveryClientConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'nacosReactiveDiscoveryClientConfiguration'.
   */
  public static BeanDefinition getNacosReactiveDiscoveryClientConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NacosReactiveDiscoveryClientConfiguration.class);
    beanDefinition.setInstanceSupplier(NacosReactiveDiscoveryClientConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'nacosReactiveDiscoveryClient'.
   */
  private static BeanInstanceSupplier<NacosReactiveDiscoveryClient> getNacosReactiveDiscoveryClientInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<NacosReactiveDiscoveryClient>forFactoryMethod(NacosReactiveDiscoveryClientConfiguration.class, "nacosReactiveDiscoveryClient", NacosServiceDiscovery.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(NacosReactiveDiscoveryClientConfiguration.class).nacosReactiveDiscoveryClient(args.get(0)));
  }

  /**
   * Get the bean definition for 'nacosReactiveDiscoveryClient'.
   */
  public static BeanDefinition getNacosReactiveDiscoveryClientBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NacosReactiveDiscoveryClient.class);
    InstanceSupplier<NacosReactiveDiscoveryClient> instanceSupplier = getNacosReactiveDiscoveryClientInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(NacosReactiveDiscoveryClient__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
