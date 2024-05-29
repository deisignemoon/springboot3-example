package com.alibaba.cloud.nacos.util;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.cloud.commons.util.InetUtilsProperties;

/**
 * Bean definitions for {@link UtilIPv6AutoConfiguration}.
 */
@Generated
public class UtilIPv6AutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'utilIPv6AutoConfiguration'.
   */
  public static BeanDefinition getUtilIPvAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UtilIPv6AutoConfiguration.class);
    beanDefinition.setInstanceSupplier(UtilIPv6AutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'inetIPv6Utils'.
   */
  private static BeanInstanceSupplier<InetIPv6Utils> getInetIPvUtilsInstanceSupplier() {
    return BeanInstanceSupplier.<InetIPv6Utils>forFactoryMethod(UtilIPv6AutoConfiguration.class, "inetIPv6Utils", InetUtilsProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(UtilIPv6AutoConfiguration.class).inetIPv6Utils(args.get(0)));
  }

  /**
   * Get the bean definition for 'inetIPv6Utils'.
   */
  public static BeanDefinition getInetIPvUtilsBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(InetIPv6Utils.class);
    beanDefinition.setInstanceSupplier(getInetIPvUtilsInstanceSupplier());
    return beanDefinition;
  }
}
