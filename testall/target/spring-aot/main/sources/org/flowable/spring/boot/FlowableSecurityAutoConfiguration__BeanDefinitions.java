package org.flowable.spring.boot;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link FlowableSecurityAutoConfiguration}.
 */
@Generated
public class FlowableSecurityAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'flowableSecurityAutoConfiguration'.
   */
  public static BeanDefinition getFlowableSecurityAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FlowableSecurityAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(FlowableSecurityAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link FlowableSecurityAutoConfiguration.SpringSecurityAuthenticationContextConfiguration}.
   */
  @Generated
  public static class SpringSecurityAuthenticationContextConfiguration {
    /**
     * Get the bean instance supplier for 'org.flowable.spring.boot.FlowableSecurityAutoConfiguration$SpringSecurityAuthenticationContextConfiguration'.
     */
    private static BeanInstanceSupplier<FlowableSecurityAutoConfiguration.SpringSecurityAuthenticationContextConfiguration> getSpringSecurityAuthenticationContextConfigurationInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<FlowableSecurityAutoConfiguration.SpringSecurityAuthenticationContextConfiguration>forConstructor(ObjectProvider.class)
              .withGenerator((registeredBean, args) -> new FlowableSecurityAutoConfiguration.SpringSecurityAuthenticationContextConfiguration(args.get(0)));
    }

    /**
     * Get the bean definition for 'springSecurityAuthenticationContextConfiguration'.
     */
    public static BeanDefinition getSpringSecurityAuthenticationContextConfigurationBeanDefinition(
        ) {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(FlowableSecurityAutoConfiguration.SpringSecurityAuthenticationContextConfiguration.class);
      beanDefinition.setInstanceSupplier(getSpringSecurityAuthenticationContextConfigurationInstanceSupplier());
      return beanDefinition;
    }
  }
}
