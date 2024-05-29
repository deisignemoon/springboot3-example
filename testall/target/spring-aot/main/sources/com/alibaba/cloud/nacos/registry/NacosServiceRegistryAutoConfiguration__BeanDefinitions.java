package com.alibaba.cloud.nacos.registry;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.NacosServiceManager;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationProperties;
import org.springframework.context.ApplicationContext;

/**
 * Bean definitions for {@link NacosServiceRegistryAutoConfiguration}.
 */
@Generated
public class NacosServiceRegistryAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'nacosServiceRegistryAutoConfiguration'.
   */
  public static BeanDefinition getNacosServiceRegistryAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NacosServiceRegistryAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(NacosServiceRegistryAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'nacosServiceRegistry'.
   */
  private static BeanInstanceSupplier<NacosServiceRegistry> getNacosServiceRegistryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<NacosServiceRegistry>forFactoryMethod(NacosServiceRegistryAutoConfiguration.class, "nacosServiceRegistry", NacosServiceManager.class, NacosDiscoveryProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(NacosServiceRegistryAutoConfiguration.class).nacosServiceRegistry(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'nacosServiceRegistry'.
   */
  public static BeanDefinition getNacosServiceRegistryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NacosServiceRegistry.class);
    beanDefinition.setDestroyMethodNames("close");
    beanDefinition.setInstanceSupplier(getNacosServiceRegistryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'nacosRegistration'.
   */
  private static BeanInstanceSupplier<NacosRegistration> getNacosRegistrationInstanceSupplier() {
    return BeanInstanceSupplier.<NacosRegistration>forFactoryMethod(NacosServiceRegistryAutoConfiguration.class, "nacosRegistration", ObjectProvider.class, NacosDiscoveryProperties.class, ApplicationContext.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(NacosServiceRegistryAutoConfiguration.class).nacosRegistration(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'nacosRegistration'.
   */
  public static BeanDefinition getNacosRegistrationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NacosRegistration.class);
    beanDefinition.setInitMethodNames("init");
    beanDefinition.setInstanceSupplier(getNacosRegistrationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'nacosAutoServiceRegistration'.
   */
  private static BeanInstanceSupplier<NacosAutoServiceRegistration> getNacosAutoServiceRegistrationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<NacosAutoServiceRegistration>forFactoryMethod(NacosServiceRegistryAutoConfiguration.class, "nacosAutoServiceRegistration", NacosServiceRegistry.class, AutoServiceRegistrationProperties.class, NacosRegistration.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(NacosServiceRegistryAutoConfiguration.class).nacosAutoServiceRegistration(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'nacosAutoServiceRegistration'.
   */
  public static BeanDefinition getNacosAutoServiceRegistrationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NacosAutoServiceRegistration.class);
    beanDefinition.setDestroyMethodNames("destroy");
    beanDefinition.setInstanceSupplier(getNacosAutoServiceRegistrationInstanceSupplier());
    return beanDefinition;
  }
}
