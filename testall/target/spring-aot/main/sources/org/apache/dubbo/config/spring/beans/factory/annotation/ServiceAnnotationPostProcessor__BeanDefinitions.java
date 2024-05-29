package org.apache.dubbo.config.spring.beans.factory.annotation;

import java.util.Collection;
import java.util.Set;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ServiceAnnotationPostProcessor}.
 */
@Generated
public class ServiceAnnotationPostProcessor__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.apache.dubbo.config.spring.beans.factory.annotation.ServiceAnnotationPostProcessor#0'.
   */
  private static BeanInstanceSupplier<ServiceAnnotationPostProcessor> getServiceAnnotationPostProcessorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ServiceAnnotationPostProcessor>forConstructor(Collection.class)
            .withGenerator((registeredBean, args) -> new ServiceAnnotationPostProcessor(args.get(0, Collection.class)));
  }

  /**
   * Get the bean definition for 'serviceAnnotationPostProcessor#0'.
   */
  public static BeanDefinition getServiceAnnotationPostProcessorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ServiceAnnotationPostProcessor.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, Set.of("com.xiacong"));
    beanDefinition.setInstanceSupplier(getServiceAnnotationPostProcessorInstanceSupplier());
    return beanDefinition;
  }
}
