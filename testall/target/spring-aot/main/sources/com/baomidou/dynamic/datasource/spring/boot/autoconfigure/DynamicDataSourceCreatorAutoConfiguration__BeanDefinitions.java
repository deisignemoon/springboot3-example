package com.baomidou.dynamic.datasource.spring.boot.autoconfigure;

import com.baomidou.dynamic.datasource.creator.basic.BasicDataSourceCreator;
import com.baomidou.dynamic.datasource.creator.druid.DruidDataSourceCreator;
import com.baomidou.dynamic.datasource.creator.hikaricp.HikariDataSourceCreator;
import com.baomidou.dynamic.datasource.creator.jndi.JndiDataSourceCreator;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link DynamicDataSourceCreatorAutoConfiguration}.
 */
@Generated
public class DynamicDataSourceCreatorAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'dynamicDataSourceCreatorAutoConfiguration'.
   */
  public static BeanDefinition getDynamicDataSourceCreatorAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DynamicDataSourceCreatorAutoConfiguration.class);
    beanDefinition.setTargetType(DynamicDataSourceCreatorAutoConfiguration.class);
    ConfigurationClassUtils.initializeConfigurationClass(DynamicDataSourceCreatorAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(DynamicDataSourceCreatorAutoConfiguration$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'basicDataSourceCreator'.
   */
  private static BeanInstanceSupplier<BasicDataSourceCreator> getBasicDataSourceCreatorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<BasicDataSourceCreator>forFactoryMethod(DynamicDataSourceCreatorAutoConfiguration.class, "basicDataSourceCreator")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(DynamicDataSourceCreatorAutoConfiguration.class).basicDataSourceCreator());
  }

  /**
   * Get the bean definition for 'basicDataSourceCreator'.
   */
  public static BeanDefinition getBasicDataSourceCreatorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(BasicDataSourceCreator.class);
    beanDefinition.setInstanceSupplier(getBasicDataSourceCreatorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'jndiDataSourceCreator'.
   */
  private static BeanInstanceSupplier<JndiDataSourceCreator> getJndiDataSourceCreatorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<JndiDataSourceCreator>forFactoryMethod(DynamicDataSourceCreatorAutoConfiguration.class, "jndiDataSourceCreator")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(DynamicDataSourceCreatorAutoConfiguration.class).jndiDataSourceCreator());
  }

  /**
   * Get the bean definition for 'jndiDataSourceCreator'.
   */
  public static BeanDefinition getJndiDataSourceCreatorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JndiDataSourceCreator.class);
    beanDefinition.setInstanceSupplier(getJndiDataSourceCreatorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link DynamicDataSourceCreatorAutoConfiguration.DruidDataSourceCreatorConfiguration}.
   */
  @Generated
  public static class DruidDataSourceCreatorConfiguration {
    /**
     * Get the bean definition for 'druidDataSourceCreatorConfiguration'.
     */
    public static BeanDefinition getDruidDataSourceCreatorConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(DynamicDataSourceCreatorAutoConfiguration.DruidDataSourceCreatorConfiguration.class);
      beanDefinition.setTargetType(DynamicDataSourceCreatorAutoConfiguration.DruidDataSourceCreatorConfiguration.class);
      ConfigurationClassUtils.initializeConfigurationClass(DynamicDataSourceCreatorAutoConfiguration.DruidDataSourceCreatorConfiguration.class);
      InstanceSupplier<DynamicDataSourceCreatorAutoConfiguration.DruidDataSourceCreatorConfiguration> instanceSupplier = InstanceSupplier.using(DynamicDataSourceCreatorAutoConfiguration$DruidDataSourceCreatorConfiguration$$SpringCGLIB$$0::new);
      instanceSupplier = instanceSupplier.andThen(DynamicDataSourceCreatorAutoConfiguration_DruidDataSourceCreatorConfiguration__Autowiring::apply);
      beanDefinition.setInstanceSupplier(instanceSupplier);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'druidDataSourceCreator'.
     */
    private static BeanInstanceSupplier<DruidDataSourceCreator> getDruidDataSourceCreatorInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<DruidDataSourceCreator>forFactoryMethod(DynamicDataSourceCreatorAutoConfiguration.DruidDataSourceCreatorConfiguration.class, "druidDataSourceCreator", DynamicDataSourceProperties.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(DynamicDataSourceCreatorAutoConfiguration.DruidDataSourceCreatorConfiguration.class).druidDataSourceCreator(args.get(0)));
    }

    /**
     * Get the bean definition for 'druidDataSourceCreator'.
     */
    public static BeanDefinition getDruidDataSourceCreatorBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(DruidDataSourceCreator.class);
      beanDefinition.setInstanceSupplier(getDruidDataSourceCreatorInstanceSupplier());
      return beanDefinition;
    }
  }

  /**
   * Bean definitions for {@link DynamicDataSourceCreatorAutoConfiguration.HikariDataSourceCreatorConfiguration}.
   */
  @Generated
  public static class HikariDataSourceCreatorConfiguration {
    /**
     * Get the bean definition for 'hikariDataSourceCreatorConfiguration'.
     */
    public static BeanDefinition getHikariDataSourceCreatorConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(DynamicDataSourceCreatorAutoConfiguration.HikariDataSourceCreatorConfiguration.class);
      beanDefinition.setTargetType(DynamicDataSourceCreatorAutoConfiguration.HikariDataSourceCreatorConfiguration.class);
      ConfigurationClassUtils.initializeConfigurationClass(DynamicDataSourceCreatorAutoConfiguration.HikariDataSourceCreatorConfiguration.class);
      beanDefinition.setInstanceSupplier(DynamicDataSourceCreatorAutoConfiguration$HikariDataSourceCreatorConfiguration$$SpringCGLIB$$0::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'hikariDataSourceCreator'.
     */
    private static BeanInstanceSupplier<HikariDataSourceCreator> getHikariDataSourceCreatorInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<HikariDataSourceCreator>forFactoryMethod(DynamicDataSourceCreatorAutoConfiguration.HikariDataSourceCreatorConfiguration.class, "hikariDataSourceCreator", DynamicDataSourceProperties.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(DynamicDataSourceCreatorAutoConfiguration.HikariDataSourceCreatorConfiguration.class).hikariDataSourceCreator(args.get(0)));
    }

    /**
     * Get the bean definition for 'hikariDataSourceCreator'.
     */
    public static BeanDefinition getHikariDataSourceCreatorBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(HikariDataSourceCreator.class);
      beanDefinition.setInstanceSupplier(getHikariDataSourceCreatorInstanceSupplier());
      return beanDefinition;
    }
  }
}
