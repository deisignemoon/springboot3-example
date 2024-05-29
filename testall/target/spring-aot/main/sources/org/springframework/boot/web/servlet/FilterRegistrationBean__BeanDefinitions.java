package org.springframework.boot.web.servlet;

import com.xiacong.common.filter.SysLogFilter__BeanDefinitions;
import jakarta.servlet.DispatcherType;
import java.lang.String;
import java.util.Collections;
import java.util.Set;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;

/**
 * Bean definitions for {@link FilterRegistrationBean}.
 */
@Generated
public class FilterRegistrationBean__BeanDefinitions {
  /**
   * Get the bean definition for 'traceIdFilter'.
   */
  public static BeanDefinition getTraceIdFilterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FilterRegistrationBean.class);
    beanDefinition.setTargetType(ResolvableType.forClass(FilterRegistrationBean.class));
    beanDefinition.getPropertyValues().addPropertyValue("asyncSupported", false);
    beanDefinition.getPropertyValues().addPropertyValue("dispatcherTypes", Set.of(DispatcherType.REQUEST));
    beanDefinition.getPropertyValues().addPropertyValue("filter", SysLogFilter__BeanDefinitions.getFilterBeanDefinition());
    beanDefinition.getPropertyValues().addPropertyValue("initParameters", Collections.emptyMap());
    beanDefinition.getPropertyValues().addPropertyValue("name", "traceIdFilter");
    beanDefinition.getPropertyValues().addPropertyValue("servletNames", new String[] {});
    beanDefinition.getPropertyValues().addPropertyValue("urlPatterns", new String[] {"/*"});
    beanDefinition.setInstanceSupplier(FilterRegistrationBean::new);
    return beanDefinition;
  }
}
