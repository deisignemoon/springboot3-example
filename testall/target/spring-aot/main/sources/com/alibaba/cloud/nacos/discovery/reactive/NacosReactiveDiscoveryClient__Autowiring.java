package com.alibaba.cloud.nacos.discovery.reactive;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link NacosReactiveDiscoveryClient}.
 */
@Generated
public class NacosReactiveDiscoveryClient__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static NacosReactiveDiscoveryClient apply(RegisteredBean registeredBean,
      NacosReactiveDiscoveryClient instance) {
    AutowiredFieldValueResolver.forRequiredField("failureToleranceEnabled").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
