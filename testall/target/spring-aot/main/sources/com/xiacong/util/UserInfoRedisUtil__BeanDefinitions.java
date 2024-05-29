package com.xiacong.util;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UserInfoRedisUtil}.
 */
@Generated
public class UserInfoRedisUtil__BeanDefinitions {
  /**
   * Get the bean definition for 'userInfoRedisUtil'.
   */
  public static BeanDefinition getUserInfoRedisUtilBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UserInfoRedisUtil.class);
    InstanceSupplier<UserInfoRedisUtil> instanceSupplier = InstanceSupplier.using(UserInfoRedisUtil::new);
    instanceSupplier = instanceSupplier.andThen(UserInfoRedisUtil__ResourceAutowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
