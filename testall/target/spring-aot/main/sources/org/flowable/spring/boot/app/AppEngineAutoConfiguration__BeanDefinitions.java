package org.flowable.spring.boot.app;

import javax.sql.DataSource;
import org.flowable.app.spring.SpringAppEngineConfiguration;
import org.flowable.spring.boot.FlowableAutoDeploymentProperties;
import org.flowable.spring.boot.FlowableProperties;
import org.flowable.spring.boot.eventregistry.FlowableEventRegistryProperties;
import org.flowable.spring.boot.idm.FlowableIdmProperties;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Bean definitions for {@link AppEngineAutoConfiguration}.
 */
@Generated
public class AppEngineAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.flowable.spring.boot.app.AppEngineAutoConfiguration'.
   */
  private static BeanInstanceSupplier<AppEngineAutoConfiguration> getAppEngineAutoConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AppEngineAutoConfiguration>forConstructor(FlowableProperties.class, FlowableAppProperties.class, FlowableIdmProperties.class, FlowableEventRegistryProperties.class, FlowableAutoDeploymentProperties.class)
            .withGenerator((registeredBean, args) -> new AppEngineAutoConfiguration(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4)));
  }

  /**
   * Get the bean definition for 'appEngineAutoConfiguration'.
   */
  public static BeanDefinition getAppEngineAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AppEngineAutoConfiguration.class);
    InstanceSupplier<AppEngineAutoConfiguration> instanceSupplier = getAppEngineAutoConfigurationInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(AppEngineAutoConfiguration__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'springAppEngineConfiguration'.
   */
  private static BeanInstanceSupplier<SpringAppEngineConfiguration> getSpringAppEngineConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SpringAppEngineConfiguration>forFactoryMethod(AppEngineAutoConfiguration.class, "springAppEngineConfiguration", DataSource.class, PlatformTransactionManager.class, ObjectProvider.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(AppEngineAutoConfiguration.class).springAppEngineConfiguration(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'springAppEngineConfiguration'.
   */
  public static BeanDefinition getSpringAppEngineConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringAppEngineConfiguration.class);
    beanDefinition.setDestroyMethodNames("close");
    beanDefinition.setInstanceSupplier(getSpringAppEngineConfigurationInstanceSupplier());
    return beanDefinition;
  }
}
