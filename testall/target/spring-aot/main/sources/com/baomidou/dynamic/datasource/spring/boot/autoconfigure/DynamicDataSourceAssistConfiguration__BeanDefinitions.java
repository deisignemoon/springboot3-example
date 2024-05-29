package com.baomidou.dynamic.datasource.spring.boot.autoconfigure;

import com.baomidou.dynamic.datasource.creator.DefaultDataSourceCreator;
import com.baomidou.dynamic.datasource.event.DataSourceInitEvent;
import com.baomidou.dynamic.datasource.provider.DynamicDataSourceProvider;
import com.baomidou.dynamic.datasource.tx.DsTxEventListenerFactory;
import java.util.List;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link DynamicDataSourceAssistConfiguration}.
 */
@Generated
public class DynamicDataSourceAssistConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceAssistConfiguration'.
   */
  private static BeanInstanceSupplier<DynamicDataSourceAssistConfiguration> getDynamicDataSourceAssistConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DynamicDataSourceAssistConfiguration>forConstructor(DynamicDataSourceProperties.class)
            .withGenerator((registeredBean, args) -> new DynamicDataSourceAssistConfiguration$$SpringCGLIB$$0(args.get(0)));
  }

  /**
   * Get the bean definition for 'dynamicDataSourceAssistConfiguration'.
   */
  public static BeanDefinition getDynamicDataSourceAssistConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DynamicDataSourceAssistConfiguration.class);
    beanDefinition.setTargetType(DynamicDataSourceAssistConfiguration.class);
    ConfigurationClassUtils.initializeConfigurationClass(DynamicDataSourceAssistConfiguration.class);
    beanDefinition.setInstanceSupplier(getDynamicDataSourceAssistConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'ymlDynamicDataSourceProvider'.
   */
  private static BeanInstanceSupplier<DynamicDataSourceProvider> getYmlDynamicDataSourceProviderInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DynamicDataSourceProvider>forFactoryMethod(DynamicDataSourceAssistConfiguration.class, "ymlDynamicDataSourceProvider", DefaultDataSourceCreator.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(DynamicDataSourceAssistConfiguration.class).ymlDynamicDataSourceProvider(args.get(0)));
  }

  /**
   * Get the bean definition for 'ymlDynamicDataSourceProvider'.
   */
  public static BeanDefinition getYmlDynamicDataSourceProviderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DynamicDataSourceProvider.class);
    beanDefinition.setInstanceSupplier(getYmlDynamicDataSourceProviderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'dataSourceInitEvent'.
   */
  private static BeanInstanceSupplier<DataSourceInitEvent> getDataSourceInitEventInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DataSourceInitEvent>forFactoryMethod(DynamicDataSourceAssistConfiguration.class, "dataSourceInitEvent")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(DynamicDataSourceAssistConfiguration.class).dataSourceInitEvent());
  }

  /**
   * Get the bean definition for 'dataSourceInitEvent'.
   */
  public static BeanDefinition getDataSourceInitEventBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DataSourceInitEvent.class);
    beanDefinition.setInstanceSupplier(getDataSourceInitEventInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'dataSourceCreator'.
   */
  private static BeanInstanceSupplier<DefaultDataSourceCreator> getDataSourceCreatorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DefaultDataSourceCreator>forFactoryMethod(DynamicDataSourceAssistConfiguration.class, "dataSourceCreator", List.class, DataSourceInitEvent.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(DynamicDataSourceAssistConfiguration.class).dataSourceCreator(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'dataSourceCreator'.
   */
  public static BeanDefinition getDataSourceCreatorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DefaultDataSourceCreator.class);
    beanDefinition.setInstanceSupplier(getDataSourceCreatorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link DynamicDataSourceAssistConfiguration.DsTxEventListenerFactoryConfiguration}.
   */
  @Generated
  public static class DsTxEventListenerFactoryConfiguration {
    /**
     * Get the bean definition for 'dsTxEventListenerFactoryConfiguration'.
     */
    public static BeanDefinition getDsTxEventListenerFactoryConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(DynamicDataSourceAssistConfiguration.DsTxEventListenerFactoryConfiguration.class);
      beanDefinition.setTargetType(DynamicDataSourceAssistConfiguration.DsTxEventListenerFactoryConfiguration.class);
      ConfigurationClassUtils.initializeConfigurationClass(DynamicDataSourceAssistConfiguration.DsTxEventListenerFactoryConfiguration.class);
      beanDefinition.setInstanceSupplier(DynamicDataSourceAssistConfiguration$DsTxEventListenerFactoryConfiguration$$SpringCGLIB$$0::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'dsTxEventListenerFactory'.
     */
    private static BeanInstanceSupplier<DsTxEventListenerFactory> getDsTxEventListenerFactoryInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<DsTxEventListenerFactory>forFactoryMethod(DynamicDataSourceAssistConfiguration.DsTxEventListenerFactoryConfiguration.class, "dsTxEventListenerFactory")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(DynamicDataSourceAssistConfiguration.DsTxEventListenerFactoryConfiguration.class).dsTxEventListenerFactory());
    }

    /**
     * Get the bean definition for 'dsTxEventListenerFactory'.
     */
    public static BeanDefinition getDsTxEventListenerFactoryBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(DsTxEventListenerFactory.class);
      beanDefinition.setInstanceSupplier(getDsTxEventListenerFactoryInstanceSupplier());
      return beanDefinition;
    }
  }
}
