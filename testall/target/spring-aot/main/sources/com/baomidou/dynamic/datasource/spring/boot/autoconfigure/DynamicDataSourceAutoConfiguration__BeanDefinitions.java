package com.baomidou.dynamic.datasource.spring.boot.autoconfigure;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DynamicDataSourceAutoConfiguration}.
 */
@Generated
public class DynamicDataSourceAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceAutoConfiguration'.
   */
  private static BeanInstanceSupplier<DynamicDataSourceAutoConfiguration> getDynamicDataSourceAutoConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DynamicDataSourceAutoConfiguration>forConstructor(DynamicDataSourceProperties.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> new DynamicDataSourceAutoConfiguration(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'dynamicDataSourceAutoConfiguration'.
   */
  public static BeanDefinition getDynamicDataSourceAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DynamicDataSourceAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(getDynamicDataSourceAutoConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'dataSource'.
   */
  private static BeanInstanceSupplier<DataSource> getDataSourceInstanceSupplier() {
    return BeanInstanceSupplier.<DataSource>forFactoryMethod(DynamicDataSourceAutoConfiguration.class, "dataSource", List.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(DynamicDataSourceAutoConfiguration.class).dataSource(args.get(0)));
  }

  /**
   * Get the bean definition for 'dataSource'.
   */
  public static BeanDefinition getDataSourceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DataSource.class);
    beanDefinition.setInstanceSupplier(getDataSourceInstanceSupplier());
    return beanDefinition;
  }
}
