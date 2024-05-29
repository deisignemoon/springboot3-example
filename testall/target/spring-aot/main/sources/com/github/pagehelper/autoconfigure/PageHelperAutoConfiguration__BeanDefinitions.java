package com.github.pagehelper.autoconfigure;

import java.util.List;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link PageHelperAutoConfiguration}.
 */
@Generated
public class PageHelperAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration'.
   */
  private static BeanInstanceSupplier<PageHelperAutoConfiguration> getPageHelperAutoConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<PageHelperAutoConfiguration>forConstructor(List.class, PageHelperStandardProperties.class)
            .withGenerator((registeredBean, args) -> new PageHelperAutoConfiguration$$SpringCGLIB$$0(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'pageHelperAutoConfiguration'.
   */
  public static BeanDefinition getPageHelperAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PageHelperAutoConfiguration.class);
    beanDefinition.setTargetType(PageHelperAutoConfiguration.class);
    beanDefinition.setLazyInit(false);
    ConfigurationClassUtils.initializeConfigurationClass(PageHelperAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(getPageHelperAutoConfigurationInstanceSupplier());
    return beanDefinition;
  }
}
