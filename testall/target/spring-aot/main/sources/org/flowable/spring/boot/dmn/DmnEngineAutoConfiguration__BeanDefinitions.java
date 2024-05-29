package org.flowable.spring.boot.dmn;

import javax.sql.DataSource;
import org.flowable.app.spring.SpringAppEngineConfiguration;
import org.flowable.dmn.engine.configurator.DmnEngineConfigurator;
import org.flowable.dmn.spring.SpringDmnEngineConfiguration;
import org.flowable.spring.boot.EngineConfigurationConfigurer;
import org.flowable.spring.boot.FlowableAutoDeploymentProperties;
import org.flowable.spring.boot.FlowableProperties;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Bean definitions for {@link DmnEngineAutoConfiguration}.
 */
@Generated
public class DmnEngineAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.flowable.spring.boot.dmn.DmnEngineAutoConfiguration'.
   */
  private static BeanInstanceSupplier<DmnEngineAutoConfiguration> getDmnEngineAutoConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DmnEngineAutoConfiguration>forConstructor(FlowableProperties.class, FlowableDmnProperties.class, FlowableAutoDeploymentProperties.class)
            .withGenerator((registeredBean, args) -> new DmnEngineAutoConfiguration(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'dmnEngineAutoConfiguration'.
   */
  public static BeanDefinition getDmnEngineAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DmnEngineAutoConfiguration.class);
    InstanceSupplier<DmnEngineAutoConfiguration> instanceSupplier = getDmnEngineAutoConfigurationInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(DmnEngineAutoConfiguration__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'dmnEngineConfiguration'.
   */
  private static BeanInstanceSupplier<SpringDmnEngineConfiguration> getDmnEngineConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SpringDmnEngineConfiguration>forFactoryMethod(DmnEngineAutoConfiguration.class, "dmnEngineConfiguration", DataSource.class, PlatformTransactionManager.class, ObjectProvider.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(DmnEngineAutoConfiguration.class).dmnEngineConfiguration(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'dmnEngineConfiguration'.
   */
  public static BeanDefinition getDmnEngineConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDmnEngineConfiguration.class);
    beanDefinition.setDestroyMethodNames("close");
    beanDefinition.setInstanceSupplier(getDmnEngineConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link DmnEngineAutoConfiguration.DmnEngineAppConfiguration}.
   */
  @Generated
  public static class DmnEngineAppConfiguration {
    /**
     * Get the bean definition for 'dmnEngineAppConfiguration'.
     */
    public static BeanDefinition getDmnEngineAppConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(DmnEngineAutoConfiguration.DmnEngineAppConfiguration.class);
      InstanceSupplier<DmnEngineAutoConfiguration.DmnEngineAppConfiguration> instanceSupplier = InstanceSupplier.using(DmnEngineAutoConfiguration.DmnEngineAppConfiguration::new);
      instanceSupplier = instanceSupplier.andThen(DmnEngineAutoConfiguration_DmnEngineAppConfiguration__Autowiring::apply);
      beanDefinition.setInstanceSupplier(instanceSupplier);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'dmnAppEngineConfigurationConfigurer'.
     */
    private static BeanInstanceSupplier<EngineConfigurationConfigurer> getDmnAppEngineConfigurationConfigurerInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<EngineConfigurationConfigurer>forFactoryMethod(DmnEngineAutoConfiguration.DmnEngineAppConfiguration.class, "dmnAppEngineConfigurationConfigurer", DmnEngineConfigurator.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(DmnEngineAutoConfiguration.DmnEngineAppConfiguration.class).dmnAppEngineConfigurationConfigurer(args.get(0)));
    }

    /**
     * Get the bean definition for 'dmnAppEngineConfigurationConfigurer'.
     */
    public static BeanDefinition getDmnAppEngineConfigurationConfigurerBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(EngineConfigurationConfigurer.class);
      beanDefinition.setTargetType(ResolvableType.forClassWithGenerics(EngineConfigurationConfigurer.class, SpringAppEngineConfiguration.class));
      beanDefinition.setInstanceSupplier(getDmnAppEngineConfigurationConfigurerInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'dmnEngineConfigurator'.
     */
    private static BeanInstanceSupplier<DmnEngineConfigurator> getDmnEngineConfiguratorInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<DmnEngineConfigurator>forFactoryMethod(DmnEngineAutoConfiguration.DmnEngineAppConfiguration.class, "dmnEngineConfigurator", SpringDmnEngineConfiguration.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(DmnEngineAutoConfiguration.DmnEngineAppConfiguration.class).dmnEngineConfigurator(args.get(0)));
    }

    /**
     * Get the bean definition for 'dmnEngineConfigurator'.
     */
    public static BeanDefinition getDmnEngineConfiguratorBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(DmnEngineConfigurator.class);
      beanDefinition.setInstanceSupplier(getDmnEngineConfiguratorInstanceSupplier());
      return beanDefinition;
    }
  }
}
