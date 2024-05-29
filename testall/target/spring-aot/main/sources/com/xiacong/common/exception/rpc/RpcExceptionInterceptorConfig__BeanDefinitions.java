package com.xiacong.common.exception.rpc;

import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link RpcExceptionInterceptorConfig}.
 */
@Generated
public class RpcExceptionInterceptorConfig__BeanDefinitions {
  /**
   * Get the bean definition for 'rpcExceptionInterceptorConfig'.
   */
  public static BeanDefinition getRpcExceptionInterceptorConfigBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RpcExceptionInterceptorConfig.class);
    beanDefinition.setTargetType(RpcExceptionInterceptorConfig.class);
    ConfigurationClassUtils.initializeConfigurationClass(RpcExceptionInterceptorConfig.class);
    beanDefinition.setInstanceSupplier(RpcExceptionInterceptorConfig$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'defaultPointcutAdvisor2'.
   */
  private static BeanInstanceSupplier<DefaultPointcutAdvisor> getDefaultPointcutAdvisorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DefaultPointcutAdvisor>forFactoryMethod(RpcExceptionInterceptorConfig.class, "defaultPointcutAdvisor2")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(RpcExceptionInterceptorConfig.class).defaultPointcutAdvisor2());
  }

  /**
   * Get the bean definition for 'defaultPointcutAdvisor2'.
   */
  public static BeanDefinition getDefaultPointcutAdvisorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DefaultPointcutAdvisor.class);
    beanDefinition.setInstanceSupplier(getDefaultPointcutAdvisorInstanceSupplier());
    return beanDefinition;
  }
}
