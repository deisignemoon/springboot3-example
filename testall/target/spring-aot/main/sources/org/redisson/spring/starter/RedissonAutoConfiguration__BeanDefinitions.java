package org.redisson.spring.starter;

import java.lang.Object;
import org.redisson.api.RedissonClient;
import org.redisson.api.RedissonReactiveClient;
import org.redisson.api.RedissonRxClient;
import org.redisson.spring.data.connection.RedissonConnectionFactory;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Bean definitions for {@link RedissonAutoConfiguration}.
 */
@Generated
public class RedissonAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'redisTemplate'.
   */
  private static BeanInstanceSupplier<RedisTemplate> getRedisTemplateInstanceSupplier() {
    return BeanInstanceSupplier.<RedisTemplate>forFactoryMethod(RedissonAutoConfiguration.class, "redisTemplate", RedisConnectionFactory.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(RedissonAutoConfiguration.class).redisTemplate(args.get(0)));
  }

  /**
   * Get the bean definition for 'redisTemplate'.
   */
  public static BeanDefinition getRedisTemplateBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RedisTemplate.class);
    beanDefinition.setTargetType(ResolvableType.forClassWithGenerics(RedisTemplate.class, Object.class, Object.class));
    beanDefinition.setInstanceSupplier(getRedisTemplateInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'stringRedisTemplate'.
   */
  private static BeanInstanceSupplier<StringRedisTemplate> getStringRedisTemplateInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<StringRedisTemplate>forFactoryMethod(RedissonAutoConfiguration.class, "stringRedisTemplate", RedisConnectionFactory.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(RedissonAutoConfiguration.class).stringRedisTemplate(args.get(0)));
  }

  /**
   * Get the bean definition for 'stringRedisTemplate'.
   */
  public static BeanDefinition getStringRedisTemplateBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(StringRedisTemplate.class);
    beanDefinition.setInstanceSupplier(getStringRedisTemplateInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'redissonConnectionFactory'.
   */
  private static BeanInstanceSupplier<RedissonConnectionFactory> getRedissonConnectionFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RedissonConnectionFactory>forFactoryMethod(RedissonAutoConfiguration.class, "redissonConnectionFactory", RedissonClient.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(RedissonAutoConfiguration.class).redissonConnectionFactory(args.get(0)));
  }

  /**
   * Get the bean definition for 'redissonConnectionFactory'.
   */
  public static BeanDefinition getRedissonConnectionFactoryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RedissonConnectionFactory.class);
    beanDefinition.setInstanceSupplier(getRedissonConnectionFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'redissonReactive'.
   */
  private static BeanInstanceSupplier<RedissonReactiveClient> getRedissonReactiveInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RedissonReactiveClient>forFactoryMethod(RedissonAutoConfiguration.class, "redissonReactive", RedissonClient.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(RedissonAutoConfiguration.class).redissonReactive(args.get(0)));
  }

  /**
   * Get the bean definition for 'redissonReactive'.
   */
  public static BeanDefinition getRedissonReactiveBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RedissonReactiveClient.class);
    beanDefinition.setLazyInit(true);
    beanDefinition.setDestroyMethodNames("shutdown");
    beanDefinition.setInstanceSupplier(getRedissonReactiveInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'redissonRxJava'.
   */
  private static BeanInstanceSupplier<RedissonRxClient> getRedissonRxJavaInstanceSupplier() {
    return BeanInstanceSupplier.<RedissonRxClient>forFactoryMethod(RedissonAutoConfiguration.class, "redissonRxJava", RedissonClient.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(RedissonAutoConfiguration.class).redissonRxJava(args.get(0)));
  }

  /**
   * Get the bean definition for 'redissonRxJava'.
   */
  public static BeanDefinition getRedissonRxJavaBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RedissonRxClient.class);
    beanDefinition.setLazyInit(true);
    beanDefinition.setDestroyMethodNames("shutdown");
    beanDefinition.setInstanceSupplier(getRedissonRxJavaInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'redisson'.
   */
  private static BeanInstanceSupplier<RedissonClient> getRedissonInstanceSupplier() {
    return BeanInstanceSupplier.<RedissonClient>forFactoryMethod(RedissonAutoConfiguration.class, "redisson")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(RedissonAutoConfiguration.class).redisson());
  }

  /**
   * Get the bean definition for 'redisson'.
   */
  public static BeanDefinition getRedissonBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RedissonClient.class);
    beanDefinition.setDestroyMethodNames("shutdown");
    beanDefinition.setInstanceSupplier(getRedissonInstanceSupplier());
    return beanDefinition;
  }
}
