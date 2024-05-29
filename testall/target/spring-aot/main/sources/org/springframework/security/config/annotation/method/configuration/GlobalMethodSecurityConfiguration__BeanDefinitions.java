package org.springframework.security.config.annotation.method.configuration;

import java.lang.SuppressWarnings;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.security.access.method.MethodSecurityMetadataSource;
import org.springframework.security.access.prepost.PreInvocationAuthorizationAdvice;

/**
 * Bean definitions for {@link GlobalMethodSecurityConfiguration}.
 */
@Generated
public class GlobalMethodSecurityConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'globalMethodSecurityConfiguration'.
   */
  @SuppressWarnings("deprecation")
  public static BeanDefinition getGlobalMethodSecurityConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GlobalMethodSecurityConfiguration.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    InstanceSupplier<GlobalMethodSecurityConfiguration> instanceSupplier = InstanceSupplier.using(GlobalMethodSecurityConfiguration::new);
    instanceSupplier = instanceSupplier.andThen(GlobalMethodSecurityConfiguration__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'methodSecurityInterceptor'.
   */
  @SuppressWarnings("deprecation")
  private static BeanInstanceSupplier<MethodInterceptor> getMethodSecurityInterceptorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MethodInterceptor>forFactoryMethod(GlobalMethodSecurityConfiguration.class, "methodSecurityInterceptor", MethodSecurityMetadataSource.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GlobalMethodSecurityConfiguration.class).methodSecurityInterceptor(args.get(0)));
  }

  /**
   * Get the bean definition for 'methodSecurityInterceptor'.
   */
  public static BeanDefinition getMethodSecurityInterceptorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MethodInterceptor.class);
    beanDefinition.setInstanceSupplier(getMethodSecurityInterceptorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'methodSecurityMetadataSource'.
   */
  @SuppressWarnings("deprecation")
  private static BeanInstanceSupplier<MethodSecurityMetadataSource> getMethodSecurityMetadataSourceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MethodSecurityMetadataSource>forFactoryMethod(GlobalMethodSecurityConfiguration.class, "methodSecurityMetadataSource")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GlobalMethodSecurityConfiguration.class).methodSecurityMetadataSource());
  }

  /**
   * Get the bean definition for 'methodSecurityMetadataSource'.
   */
  public static BeanDefinition getMethodSecurityMetadataSourceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MethodSecurityMetadataSource.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(getMethodSecurityMetadataSourceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'preInvocationAuthorizationAdvice'.
   */
  @SuppressWarnings("deprecation")
  private static BeanInstanceSupplier<PreInvocationAuthorizationAdvice> getPreInvocationAuthorizationAdviceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<PreInvocationAuthorizationAdvice>forFactoryMethod(GlobalMethodSecurityConfiguration.class, "preInvocationAuthorizationAdvice")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GlobalMethodSecurityConfiguration.class).preInvocationAuthorizationAdvice());
  }

  /**
   * Get the bean definition for 'preInvocationAuthorizationAdvice'.
   */
  @SuppressWarnings("deprecation")
  public static BeanDefinition getPreInvocationAuthorizationAdviceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PreInvocationAuthorizationAdvice.class);
    beanDefinition.setInstanceSupplier(getPreInvocationAuthorizationAdviceInstanceSupplier());
    return beanDefinition;
  }
}
