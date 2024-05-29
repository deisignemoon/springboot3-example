package org.springframework.security.access.intercept.aopalliance;

import java.lang.String;
import java.lang.SuppressWarnings;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.security.access.method.MethodSecurityMetadataSource;

/**
 * Bean definitions for {@link MethodSecurityMetadataSourceAdvisor}.
 */
@Generated
public class MethodSecurityMetadataSourceAdvisor__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'metaDataSourceAdvisor'.
   */
  @SuppressWarnings("deprecation")
  private static BeanInstanceSupplier<MethodSecurityMetadataSourceAdvisor> getMetaDataSourceAdvisorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MethodSecurityMetadataSourceAdvisor>forConstructor(String.class, MethodSecurityMetadataSource.class, String.class)
            .withGenerator((registeredBean, args) -> new MethodSecurityMetadataSourceAdvisor(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'metaDataSourceAdvisor'.
   */
  @SuppressWarnings("deprecation")
  public static BeanDefinition getMetaDataSourceAdvisorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MethodSecurityMetadataSourceAdvisor.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, "methodSecurityInterceptor");
    beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(1, new RuntimeBeanReference("methodSecurityMetadataSource"));
    beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(2, "methodSecurityMetadataSource");
    beanDefinition.getPropertyValues().addPropertyValue("order", 2147483647);
    beanDefinition.setInstanceSupplier(getMetaDataSourceAdvisorInstanceSupplier());
    return beanDefinition;
  }
}
