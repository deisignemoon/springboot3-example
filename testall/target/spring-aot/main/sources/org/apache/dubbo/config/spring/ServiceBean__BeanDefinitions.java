package org.apache.dubbo.config.spring;

import java.util.Collections;
import org.apache.dubbo.rpc.model.ModuleModel;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;

/**
 * Bean definitions for {@link ServiceBean}.
 */
@Generated
public class ServiceBean__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'ServiceBean:com.xiacong.provider.TestProvider::'.
   */
  private static BeanInstanceSupplier<ServiceBean> getTestProviderInstanceSupplier() {
    return BeanInstanceSupplier.<ServiceBean>forConstructor(ModuleModel.class)
            .withGenerator((registeredBean, args) -> new ServiceBean(args.get(0, ModuleModel.class)));
  }

  /**
   * Get the bean definition for 'testProvider::'.
   */
  public static BeanDefinition getTestProviderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ServiceBean.class);
    beanDefinition.setTargetType(ResolvableType.forClass(ServiceBean.class));
    beanDefinition.setLazyInit(false);
    beanDefinition.getPropertyValues().addPropertyValue("ref", new RuntimeBeanReference("testProviderImpl"));
    beanDefinition.getPropertyValues().addPropertyValue("interface", "com.xiacong.provider.TestProvider");
    beanDefinition.getPropertyValues().addPropertyValue("parameters", Collections.emptyMap());
    beanDefinition.setInstanceSupplier(getTestProviderInstanceSupplier());
    return beanDefinition;
  }
}
