package org.springframework.boot.autoconfigure.web.embedded;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.env.Environment;

/**
 * Bean definitions for {@link EmbeddedWebServerFactoryCustomizerAutoConfiguration}.
 */
@Generated
public class EmbeddedWebServerFactoryCustomizerAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'embeddedWebServerFactoryCustomizerAutoConfiguration'.
   */
  public static BeanDefinition getEmbeddedWebServerFactoryCustomizerAutoConfigurationBeanDefinition(
      ) {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(EmbeddedWebServerFactoryCustomizerAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(EmbeddedWebServerFactoryCustomizerAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link EmbeddedWebServerFactoryCustomizerAutoConfiguration.NettyWebServerFactoryCustomizerConfiguration}.
   */
  @Generated
  public static class NettyWebServerFactoryCustomizerConfiguration {
    /**
     * Get the bean definition for 'nettyWebServerFactoryCustomizerConfiguration'.
     */
    public static BeanDefinition getNettyWebServerFactoryCustomizerConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(EmbeddedWebServerFactoryCustomizerAutoConfiguration.NettyWebServerFactoryCustomizerConfiguration.class);
      beanDefinition.setInstanceSupplier(EmbeddedWebServerFactoryCustomizerAutoConfiguration.NettyWebServerFactoryCustomizerConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'nettyWebServerFactoryCustomizer'.
     */
    private static BeanInstanceSupplier<NettyWebServerFactoryCustomizer> getNettyWebServerFactoryCustomizerInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<NettyWebServerFactoryCustomizer>forFactoryMethod(EmbeddedWebServerFactoryCustomizerAutoConfiguration.NettyWebServerFactoryCustomizerConfiguration.class, "nettyWebServerFactoryCustomizer", Environment.class, ServerProperties.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(EmbeddedWebServerFactoryCustomizerAutoConfiguration.NettyWebServerFactoryCustomizerConfiguration.class).nettyWebServerFactoryCustomizer(args.get(0), args.get(1)));
    }

    /**
     * Get the bean definition for 'nettyWebServerFactoryCustomizer'.
     */
    public static BeanDefinition getNettyWebServerFactoryCustomizerBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(NettyWebServerFactoryCustomizer.class);
      beanDefinition.setInstanceSupplier(getNettyWebServerFactoryCustomizerInstanceSupplier());
      return beanDefinition;
    }
  }

  /**
   * Bean definitions for {@link EmbeddedWebServerFactoryCustomizerAutoConfiguration.UndertowWebServerFactoryCustomizerConfiguration}.
   */
  @Generated
  public static class UndertowWebServerFactoryCustomizerConfiguration {
    /**
     * Get the bean definition for 'undertowWebServerFactoryCustomizerConfiguration'.
     */
    public static BeanDefinition getUndertowWebServerFactoryCustomizerConfigurationBeanDefinition(
        ) {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(EmbeddedWebServerFactoryCustomizerAutoConfiguration.UndertowWebServerFactoryCustomizerConfiguration.class);
      beanDefinition.setInstanceSupplier(EmbeddedWebServerFactoryCustomizerAutoConfiguration.UndertowWebServerFactoryCustomizerConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'undertowWebServerFactoryCustomizer'.
     */
    private static BeanInstanceSupplier<UndertowWebServerFactoryCustomizer> getUndertowWebServerFactoryCustomizerInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<UndertowWebServerFactoryCustomizer>forFactoryMethod(EmbeddedWebServerFactoryCustomizerAutoConfiguration.UndertowWebServerFactoryCustomizerConfiguration.class, "undertowWebServerFactoryCustomizer", Environment.class, ServerProperties.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(EmbeddedWebServerFactoryCustomizerAutoConfiguration.UndertowWebServerFactoryCustomizerConfiguration.class).undertowWebServerFactoryCustomizer(args.get(0), args.get(1)));
    }

    /**
     * Get the bean definition for 'undertowWebServerFactoryCustomizer'.
     */
    public static BeanDefinition getUndertowWebServerFactoryCustomizerBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(UndertowWebServerFactoryCustomizer.class);
      beanDefinition.setInstanceSupplier(getUndertowWebServerFactoryCustomizerInstanceSupplier());
      return beanDefinition;
    }
  }
}
