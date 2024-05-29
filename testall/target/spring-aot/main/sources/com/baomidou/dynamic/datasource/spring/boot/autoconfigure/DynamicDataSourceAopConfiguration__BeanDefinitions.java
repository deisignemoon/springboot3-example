package com.baomidou.dynamic.datasource.spring.boot.autoconfigure;

import com.baomidou.dynamic.datasource.processor.DsProcessor;
import org.springframework.aop.Advisor;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DynamicDataSourceAopConfiguration}.
 */
@Generated
public class DynamicDataSourceAopConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceAopConfiguration'.
   */
  private static BeanInstanceSupplier<DynamicDataSourceAopConfiguration> getDynamicDataSourceAopConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DynamicDataSourceAopConfiguration>forConstructor(DynamicDataSourceProperties.class)
            .withGenerator((registeredBean, args) -> new DynamicDataSourceAopConfiguration(args.get(0)));
  }

  /**
   * Get the bean definition for 'dynamicDataSourceAopConfiguration'.
   */
  public static BeanDefinition getDynamicDataSourceAopConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DynamicDataSourceAopConfiguration.class);
    beanDefinition.setInstanceSupplier(getDynamicDataSourceAopConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean definition for 'dynamicDataSourceProperties'.
   */
  public static BeanDefinition getDynamicDataSourcePropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DynamicDataSourceAopConfiguration.class);
    beanDefinition.setTargetType(DynamicDataSourceProperties.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(BeanInstanceSupplier.<DynamicDataSourceProperties>forFactoryMethod(DynamicDataSourceAopConfiguration.class, "dynamicDataSourceProperties").withGenerator((registeredBean) -> DynamicDataSourceAopConfiguration.dynamicDataSourceProperties()));
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'dsProcessor'.
   */
  private static BeanInstanceSupplier<DsProcessor> getDsProcessorInstanceSupplier() {
    return BeanInstanceSupplier.<DsProcessor>forFactoryMethod(DynamicDataSourceAopConfiguration.class, "dsProcessor", BeanFactory.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(DynamicDataSourceAopConfiguration.class).dsProcessor(args.get(0)));
  }

  /**
   * Get the bean definition for 'dsProcessor'.
   */
  public static BeanDefinition getDsProcessorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DsProcessor.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(getDsProcessorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'dynamicDatasourceAnnotationAdvisor'.
   */
  private static BeanInstanceSupplier<Advisor> getDynamicDatasourceAnnotationAdvisorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<Advisor>forFactoryMethod(DynamicDataSourceAopConfiguration.class, "dynamicDatasourceAnnotationAdvisor", DsProcessor.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(DynamicDataSourceAopConfiguration.class).dynamicDatasourceAnnotationAdvisor(args.get(0)));
  }

  /**
   * Get the bean definition for 'dynamicDatasourceAnnotationAdvisor'.
   */
  public static BeanDefinition getDynamicDatasourceAnnotationAdvisorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(Advisor.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(getDynamicDatasourceAnnotationAdvisorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'dynamicTransactionAdvisor'.
   */
  private static BeanInstanceSupplier<Advisor> getDynamicTransactionAdvisorInstanceSupplier() {
    return BeanInstanceSupplier.<Advisor>forFactoryMethod(DynamicDataSourceAopConfiguration.class, "dynamicTransactionAdvisor")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(DynamicDataSourceAopConfiguration.class).dynamicTransactionAdvisor());
  }

  /**
   * Get the bean definition for 'dynamicTransactionAdvisor'.
   */
  public static BeanDefinition getDynamicTransactionAdvisorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(Advisor.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(getDynamicTransactionAdvisorInstanceSupplier());
    return beanDefinition;
  }
}
