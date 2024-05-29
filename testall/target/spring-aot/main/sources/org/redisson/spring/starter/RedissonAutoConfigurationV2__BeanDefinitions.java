package org.redisson.spring.starter;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link RedissonAutoConfigurationV2}.
 */
@Generated
public class RedissonAutoConfigurationV2__BeanDefinitions {
  /**
   * Get the bean definition for 'redissonAutoConfigurationV2'.
   */
  public static BeanDefinition getRedissonAutoConfigurationVBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RedissonAutoConfigurationV2.class);
    InstanceSupplier<RedissonAutoConfigurationV2> instanceSupplier = InstanceSupplier.using(RedissonAutoConfigurationV2::new);
    instanceSupplier = instanceSupplier.andThen(RedissonAutoConfigurationV2__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
