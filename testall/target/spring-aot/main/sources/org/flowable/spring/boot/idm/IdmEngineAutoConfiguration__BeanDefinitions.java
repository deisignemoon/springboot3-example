package org.flowable.spring.boot.idm;

import javax.sql.DataSource;
import org.flowable.app.spring.SpringAppEngineConfiguration;
import org.flowable.idm.engine.configurator.IdmEngineConfigurator;
import org.flowable.idm.spring.SpringIdmEngineConfiguration;
import org.flowable.spring.boot.EngineConfigurationConfigurer;
import org.flowable.spring.boot.FlowableProperties;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Bean definitions for {@link IdmEngineAutoConfiguration}.
 */
@Generated
public class IdmEngineAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.flowable.spring.boot.idm.IdmEngineAutoConfiguration'.
   */
  private static BeanInstanceSupplier<IdmEngineAutoConfiguration> getIdmEngineAutoConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<IdmEngineAutoConfiguration>forConstructor(FlowableProperties.class, FlowableIdmProperties.class)
            .withGenerator((registeredBean, args) -> new IdmEngineAutoConfiguration(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'idmEngineAutoConfiguration'.
   */
  public static BeanDefinition getIdmEngineAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(IdmEngineAutoConfiguration.class);
    InstanceSupplier<IdmEngineAutoConfiguration> instanceSupplier = getIdmEngineAutoConfigurationInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(IdmEngineAutoConfiguration__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'idmEngineConfiguration'.
   */
  private static BeanInstanceSupplier<SpringIdmEngineConfiguration> getIdmEngineConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SpringIdmEngineConfiguration>forFactoryMethod(IdmEngineAutoConfiguration.class, "idmEngineConfiguration", DataSource.class, PlatformTransactionManager.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(IdmEngineAutoConfiguration.class).idmEngineConfiguration(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'idmEngineConfiguration'.
   */
  public static BeanDefinition getIdmEngineConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringIdmEngineConfiguration.class);
    beanDefinition.setDestroyMethodNames("close");
    beanDefinition.setInstanceSupplier(getIdmEngineConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link IdmEngineAutoConfiguration.IdmEngineAppConfiguration}.
   */
  @Generated
  public static class IdmEngineAppConfiguration {
    /**
     * Get the bean definition for 'idmEngineAppConfiguration'.
     */
    public static BeanDefinition getIdmEngineAppConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(IdmEngineAutoConfiguration.IdmEngineAppConfiguration.class);
      InstanceSupplier<IdmEngineAutoConfiguration.IdmEngineAppConfiguration> instanceSupplier = InstanceSupplier.using(IdmEngineAutoConfiguration.IdmEngineAppConfiguration::new);
      instanceSupplier = instanceSupplier.andThen(IdmEngineAutoConfiguration_IdmEngineAppConfiguration__Autowiring::apply);
      beanDefinition.setInstanceSupplier(instanceSupplier);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'idmAppEngineConfigurationConfigurer'.
     */
    private static BeanInstanceSupplier<EngineConfigurationConfigurer> getIdmAppEngineConfigurationConfigurerInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<EngineConfigurationConfigurer>forFactoryMethod(IdmEngineAutoConfiguration.IdmEngineAppConfiguration.class, "idmAppEngineConfigurationConfigurer", IdmEngineConfigurator.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(IdmEngineAutoConfiguration.IdmEngineAppConfiguration.class).idmAppEngineConfigurationConfigurer(args.get(0)));
    }

    /**
     * Get the bean definition for 'idmAppEngineConfigurationConfigurer'.
     */
    public static BeanDefinition getIdmAppEngineConfigurationConfigurerBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(EngineConfigurationConfigurer.class);
      beanDefinition.setTargetType(ResolvableType.forClassWithGenerics(EngineConfigurationConfigurer.class, SpringAppEngineConfiguration.class));
      beanDefinition.setInstanceSupplier(getIdmAppEngineConfigurationConfigurerInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'idmEngineConfigurator'.
     */
    private static BeanInstanceSupplier<IdmEngineConfigurator> getIdmEngineConfiguratorInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<IdmEngineConfigurator>forFactoryMethod(IdmEngineAutoConfiguration.IdmEngineAppConfiguration.class, "idmEngineConfigurator", SpringIdmEngineConfiguration.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(IdmEngineAutoConfiguration.IdmEngineAppConfiguration.class).idmEngineConfigurator(args.get(0)));
    }

    /**
     * Get the bean definition for 'idmEngineConfigurator'.
     */
    public static BeanDefinition getIdmEngineConfiguratorBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(IdmEngineConfigurator.class);
      beanDefinition.setInstanceSupplier(getIdmEngineConfiguratorInstanceSupplier());
      return beanDefinition;
    }
  }

  /**
   * Bean definitions for {@link IdmEngineAutoConfiguration.PasswordEncoderConfiguration}.
   */
  @Generated
  public static class PasswordEncoderConfiguration {
    /**
     * Get the bean definition for 'passwordEncoderConfiguration'.
     */
    public static BeanDefinition getPasswordEncoderConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(IdmEngineAutoConfiguration.PasswordEncoderConfiguration.class);
      beanDefinition.setInstanceSupplier(IdmEngineAutoConfiguration.PasswordEncoderConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'passwordEncoderIdmEngineConfigurationConfigurer'.
     */
    private static BeanInstanceSupplier<EngineConfigurationConfigurer> getPasswordEncoderIdmEngineConfigurationConfigurerInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<EngineConfigurationConfigurer>forFactoryMethod(IdmEngineAutoConfiguration.PasswordEncoderConfiguration.class, "passwordEncoderIdmEngineConfigurationConfigurer", PasswordEncoder.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(IdmEngineAutoConfiguration.PasswordEncoderConfiguration.class).passwordEncoderIdmEngineConfigurationConfigurer(args.get(0)));
    }

    /**
     * Get the bean definition for 'passwordEncoderIdmEngineConfigurationConfigurer'.
     */
    public static BeanDefinition getPasswordEncoderIdmEngineConfigurationConfigurerBeanDefinition(
        ) {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(EngineConfigurationConfigurer.class);
      beanDefinition.setTargetType(ResolvableType.forClassWithGenerics(EngineConfigurationConfigurer.class, SpringIdmEngineConfiguration.class));
      beanDefinition.setInstanceSupplier(getPasswordEncoderIdmEngineConfigurationConfigurerInstanceSupplier());
      return beanDefinition;
    }
  }
}
