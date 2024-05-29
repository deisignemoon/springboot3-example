package com.github.pagehelper.autoconfigure;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link PageHelperStandardProperties}.
 */
@Generated
public class PageHelperStandardProperties__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'pagehelper-com.github.pagehelper.autoconfigure.PageHelperStandardProperties'.
   */
  private static BeanInstanceSupplier<PageHelperStandardProperties> getPageHelperStandardPropertiesInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<PageHelperStandardProperties>forConstructor(PageHelperProperties.class)
            .withGenerator((registeredBean, args) -> new PageHelperStandardProperties(args.get(0)));
  }

  /**
   * Get the bean definition for 'pageHelperStandardProperties'.
   */
  public static BeanDefinition getPageHelperStandardPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PageHelperStandardProperties.class);
    beanDefinition.setInstanceSupplier(getPageHelperStandardPropertiesInstanceSupplier());
    return beanDefinition;
  }
}
