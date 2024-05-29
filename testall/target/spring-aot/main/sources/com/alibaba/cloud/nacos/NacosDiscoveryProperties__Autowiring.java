package com.alibaba.cloud.nacos;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link NacosDiscoveryProperties}.
 */
@Generated
public class NacosDiscoveryProperties__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static NacosDiscoveryProperties apply(RegisteredBean registeredBean,
      NacosDiscoveryProperties instance) {
    AutowiredFieldValueResolver.forRequiredField("service").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("inetIPv6Utils").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("inetUtils").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("environment").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("nacosServiceManager").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("applicationEventPublisher").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
