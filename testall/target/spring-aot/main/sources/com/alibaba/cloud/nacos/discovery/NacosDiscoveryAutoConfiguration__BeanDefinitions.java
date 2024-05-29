package com.alibaba.cloud.nacos.discovery;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.NacosDiscoveryProperties__Autowiring;
import com.alibaba.cloud.nacos.NacosServiceManager;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link NacosDiscoveryAutoConfiguration}.
 */
@Generated
public class NacosDiscoveryAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'nacosDiscoveryAutoConfiguration'.
   */
  public static BeanDefinition getNacosDiscoveryAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NacosDiscoveryAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(NacosDiscoveryAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'nacosProperties'.
   */
  private static BeanInstanceSupplier<NacosDiscoveryProperties> getNacosPropertiesInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<NacosDiscoveryProperties>forFactoryMethod(NacosDiscoveryAutoConfiguration.class, "nacosProperties")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(NacosDiscoveryAutoConfiguration.class).nacosProperties());
  }

  /**
   * Get the bean definition for 'nacosProperties'.
   */
  public static BeanDefinition getNacosPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NacosDiscoveryProperties.class);
    beanDefinition.setInitMethodNames("init");
    InstanceSupplier<NacosDiscoveryProperties> instanceSupplier = getNacosPropertiesInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(NacosDiscoveryProperties__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'nacosServiceDiscovery'.
   */
  private static BeanInstanceSupplier<NacosServiceDiscovery> getNacosServiceDiscoveryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<NacosServiceDiscovery>forFactoryMethod(NacosDiscoveryAutoConfiguration.class, "nacosServiceDiscovery", NacosDiscoveryProperties.class, NacosServiceManager.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(NacosDiscoveryAutoConfiguration.class).nacosServiceDiscovery(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'nacosServiceDiscovery'.
   */
  public static BeanDefinition getNacosServiceDiscoveryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NacosServiceDiscovery.class);
    beanDefinition.setInstanceSupplier(getNacosServiceDiscoveryInstanceSupplier());
    return beanDefinition;
  }
}
