package com.baomidou.dynamic.datasource.spring.boot.autoconfigure;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link DynamicDataSourceCreatorAutoConfiguration.DruidDataSourceCreatorConfiguration}.
 */
@Generated
public class DynamicDataSourceCreatorAutoConfiguration_DruidDataSourceCreatorConfiguration__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static DynamicDataSourceCreatorAutoConfiguration.DruidDataSourceCreatorConfiguration apply(
      RegisteredBean registeredBean,
      DynamicDataSourceCreatorAutoConfiguration.DruidDataSourceCreatorConfiguration instance) {
    AutowiredFieldValueResolver.forField("applicationContext").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
