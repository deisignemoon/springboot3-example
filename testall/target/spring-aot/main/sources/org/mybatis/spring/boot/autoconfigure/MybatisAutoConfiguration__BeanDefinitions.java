package org.mybatis.spring.boot.autoconfigure;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.core.io.ResourceLoader;

/**
 * Bean definitions for {@link MybatisAutoConfiguration}.
 */
@Generated
public class MybatisAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration'.
   */
  private static BeanInstanceSupplier<MybatisAutoConfiguration> getMybatisAutoConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MybatisAutoConfiguration>forConstructor(MybatisProperties.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ResourceLoader.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> new MybatisAutoConfiguration$$SpringCGLIB$$0(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4), args.get(5), args.get(6), args.get(7)));
  }

  /**
   * Get the bean definition for 'mybatisAutoConfiguration'.
   */
  public static BeanDefinition getMybatisAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MybatisAutoConfiguration.class);
    beanDefinition.setTargetType(MybatisAutoConfiguration.class);
    ConfigurationClassUtils.initializeConfigurationClass(MybatisAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(getMybatisAutoConfigurationInstanceSupplier());
    return beanDefinition;
  }
}
