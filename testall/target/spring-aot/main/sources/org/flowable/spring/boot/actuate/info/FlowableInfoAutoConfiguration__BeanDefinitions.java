package org.flowable.spring.boot.actuate.info;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link FlowableInfoAutoConfiguration}.
 */
@Generated
public class FlowableInfoAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'flowableInfoAutoConfiguration'.
   */
  public static BeanDefinition getFlowableInfoAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FlowableInfoAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(FlowableInfoAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'flowableInfoContributor'.
   */
  private static BeanInstanceSupplier<FlowableInfoContributor> getFlowableInfoContributorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<FlowableInfoContributor>forFactoryMethod(FlowableInfoAutoConfiguration.class, "flowableInfoContributor")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(FlowableInfoAutoConfiguration.class).flowableInfoContributor());
  }

  /**
   * Get the bean definition for 'flowableInfoContributor'.
   */
  public static BeanDefinition getFlowableInfoContributorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FlowableInfoContributor.class);
    beanDefinition.setInstanceSupplier(getFlowableInfoContributorInstanceSupplier());
    return beanDefinition;
  }
}
