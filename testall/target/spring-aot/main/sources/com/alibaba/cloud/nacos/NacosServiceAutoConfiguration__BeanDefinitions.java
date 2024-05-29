package com.alibaba.cloud.nacos;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link NacosServiceAutoConfiguration}.
 */
@Generated
public class NacosServiceAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'nacosServiceAutoConfiguration'.
   */
  public static BeanDefinition getNacosServiceAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NacosServiceAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(NacosServiceAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'nacosServiceManager'.
   */
  private static BeanInstanceSupplier<NacosServiceManager> getNacosServiceManagerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<NacosServiceManager>forFactoryMethod(NacosServiceAutoConfiguration.class, "nacosServiceManager")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(NacosServiceAutoConfiguration.class).nacosServiceManager());
  }

  /**
   * Get the bean definition for 'nacosServiceManager'.
   */
  public static BeanDefinition getNacosServiceManagerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NacosServiceManager.class);
    beanDefinition.setInstanceSupplier(getNacosServiceManagerInstanceSupplier());
    return beanDefinition;
  }
}
