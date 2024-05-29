package com.xiacong;

import cn.hutool.extra.spring.SpringUtil__BeanDefinitions;
import com.alibaba.cloud.nacos.NacosServiceAutoConfiguration__BeanDefinitions;
import com.alibaba.cloud.nacos.discovery.NacosDiscoveryAutoConfiguration__BeanDefinitions;
import com.alibaba.cloud.nacos.discovery.NacosDiscoveryClientConfiguration__BeanDefinitions;
import com.alibaba.cloud.nacos.discovery.NacosDiscoveryHeartBeatConfiguration__BeanDefinitions;
import com.alibaba.cloud.nacos.discovery.reactive.NacosReactiveDiscoveryClientConfiguration__BeanDefinitions;
import com.alibaba.cloud.nacos.endpoint.NacosDiscoveryEndpointAutoConfiguration__BeanDefinitions;
import com.alibaba.cloud.nacos.registry.NacosServiceRegistryAutoConfiguration__BeanDefinitions;
import com.alibaba.cloud.nacos.util.UtilIPv6AutoConfiguration__BeanDefinitions;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceAopConfiguration__BeanDefinitions;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceAssistConfiguration__BeanDefinitions;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceAutoConfiguration__BeanDefinitions;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceCreatorAutoConfiguration__BeanDefinitions;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration__BeanDefinitions;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusLanguageDriverAutoConfiguration__BeanDefinitions;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties__BeanDefinitions;
import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration__BeanDefinitions;
import com.github.pagehelper.autoconfigure.PageHelperProperties__BeanDefinitions;
import com.github.pagehelper.autoconfigure.PageHelperStandardProperties__BeanDefinitions;
import com.xiacong.cache.converter.VirtualTableConverter__BeanDefinitions;
import com.xiacong.cache.impl.CacheManagerRegister__BeanDefinitions;
import com.xiacong.cache.impl.VirtualTableCacheManager__BeanDefinitions;
import com.xiacong.cache.impl.VirtualTableCache__BeanDefinitions;
import com.xiacong.cache.impl.VirtualTableColumnsCacheManager__BeanDefinitions;
import com.xiacong.cache.impl.VirtualTableColumnsCache__BeanDefinitions;
import com.xiacong.cache.impl.VirtualTableDataCacheManager__BeanDefinitions;
import com.xiacong.cache.impl.VirtualTableDataCache__BeanDefinitions;
import com.xiacong.cache.impl.VirtualTableIndexCacheManager__BeanDefinitions;
import com.xiacong.cache.impl.VirtualTableIndexCache__BeanDefinitions;
import com.xiacong.cache.repository.impl.VirtualTableDbRepositoryImpl__BeanDefinitions;
import com.xiacong.common.converter.RedissionConverter__BeanDefinitions;
import com.xiacong.common.exception.RestExceptionHandler__BeanDefinitions;
import com.xiacong.common.exception.rpc.RpcExceptionInterceptorConfig__BeanDefinitions;
import com.xiacong.common.thread.ExecutorConfig__BeanDefinitions;
import com.xiacong.common.util.ApplicationContextUtil__BeanDefinitions;
import com.xiacong.config.MyBeanFactoryPostProcessor__BeanDefinitions;
import com.xiacong.config.SecurityConfiguration__BeanDefinitions;
import com.xiacong.controller.BookController__BeanDefinitions;
import com.xiacong.controller.LoginController__BeanDefinitions;
import com.xiacong.controller.TestController__BeanDefinitions;
import com.xiacong.controller.VirtualTableColumnsController__BeanDefinitions;
import com.xiacong.controller.VirtualTableController__BeanDefinitions;
import com.xiacong.controller.VirtualTableDataController__BeanDefinitions;
import com.xiacong.controller.VirtualTableIndexController__BeanDefinitions;
import com.xiacong.filter.JwtAuthenticationFilter__BeanDefinitions;
import com.xiacong.flow.FlowEngine__BeanDefinitions;
import com.xiacong.flow.FlowFactory__BeanDefinitions;
import com.xiacong.handler.AppAuthenticationProviderImpl__BeanDefinitions;
import com.xiacong.handler.JwtAccessDeniedHandler__BeanDefinitions;
import com.xiacong.handler.JwtAuthenticationEntryPoint__BeanDefinitions;
import com.xiacong.handler.JwtLogoutSuccessHandler__BeanDefinitions;
import com.xiacong.handler.LoginFailureHandler__BeanDefinitions;
import com.xiacong.handler.LoginSuccessHandler__BeanDefinitions;
import com.xiacong.listener.CacheRefershListener__BeanDefinitions;
import com.xiacong.listener.FlowDataLoadListener__BeanDefinitions;
import com.xiacong.mapper.BookMapper;
import com.xiacong.mapper.SysGroupMapper;
import com.xiacong.mapper.SysGroupRoleMapper;
import com.xiacong.mapper.SysPermissionMapper;
import com.xiacong.mapper.SysRoleMapper;
import com.xiacong.mapper.SysRolePermissionMapper;
import com.xiacong.mapper.SysUsrGroupMapper;
import com.xiacong.mapper.SysUsrMapper;
import com.xiacong.mapper.SysUsrRoleMapper;
import com.xiacong.mapper.VirtualTableColumnsMapper;
import com.xiacong.mapper.VirtualTableDataMapper;
import com.xiacong.mapper.VirtualTableIndexMapper;
import com.xiacong.mapper.VirtualTableMapper;
import com.xiacong.provider.TestProviderImpl__BeanDefinitions;
import com.xiacong.repository.impl.RedisRepositoryImpl__BeanDefinitions;
import com.xiacong.service.impl.BookServiceImpl__BeanDefinitions;
import com.xiacong.service.impl.LoginServiceImpl__BeanDefinitions;
import com.xiacong.service.impl.SysGroupRoleServiceImpl__BeanDefinitions;
import com.xiacong.service.impl.SysGroupServiceImpl__BeanDefinitions;
import com.xiacong.service.impl.SysPermissionServiceImpl__BeanDefinitions;
import com.xiacong.service.impl.SysRolePermissionServiceImpl__BeanDefinitions;
import com.xiacong.service.impl.SysRoleServiceImpl__BeanDefinitions;
import com.xiacong.service.impl.SysUsrGroupServiceImpl__BeanDefinitions;
import com.xiacong.service.impl.SysUsrRoleServiceImpl__BeanDefinitions;
import com.xiacong.service.impl.SysUsrServiceImpl__BeanDefinitions;
import com.xiacong.service.impl.UserDetailsServiceImpl__BeanDefinitions;
import com.xiacong.service.impl.VirtualTableColumnsServiceImpl__BeanDefinitions;
import com.xiacong.service.impl.VirtualTableDataServiceImpl__BeanDefinitions;
import com.xiacong.service.impl.VirtualTableIndexServiceImpl__BeanDefinitions;
import com.xiacong.service.impl.VirtualTableServiceImpl__BeanDefinitions;
import com.xiacong.task.LocalTaskExample__BeanDefinitions;
import com.xiacong.util.JwtUtil__BeanDefinitions;
import com.xiacong.util.RedisSequenceUtil__BeanDefinitions;
import com.xiacong.util.RedissonUtil__BeanDefinitions;
import com.xiacong.util.UserInfoRedisUtil__BeanDefinitions;
import java.lang.Class;
import org.apache.dubbo.config.spring.ServiceBean__BeanDefinitions;
import org.apache.dubbo.config.spring.beans.factory.annotation.DubboConfigAliasPostProcessor__BeanDefinitions;
import org.apache.dubbo.config.spring.beans.factory.annotation.ServiceAnnotationPostProcessor__BeanDefinitions;
import org.apache.dubbo.config.spring.beans.factory.annotation.ServicePackagesHolder__BeanDefinitions;
import org.apache.dubbo.config.spring.beans.factory.config.DubboConfigDefaultPropertyValueBeanPostProcessor__BeanDefinitions;
import org.apache.dubbo.config.spring.context.DubboConfigApplicationListener__BeanDefinitions;
import org.apache.dubbo.config.spring.context.DubboConfigBeanInitializer__BeanDefinitions;
import org.apache.dubbo.config.spring.context.DubboContextPostProcessor__BeanDefinitions;
import org.apache.dubbo.config.spring.context.DubboDeployApplicationListener__BeanDefinitions;
import org.apache.dubbo.config.spring.reference.ReferenceBeanManager__BeanDefinitions;
import org.flowable.spring.boot.EndpointAutoConfiguration__BeanDefinitions;
import org.flowable.spring.boot.FlowableAutoDeploymentProperties__BeanDefinitions;
import org.flowable.spring.boot.FlowableHttpProperties__BeanDefinitions;
import org.flowable.spring.boot.FlowableJobConfiguration__BeanDefinitions;
import org.flowable.spring.boot.FlowableMailProperties__BeanDefinitions;
import org.flowable.spring.boot.FlowableProperties__BeanDefinitions;
import org.flowable.spring.boot.FlowableSecurityAutoConfiguration__BeanDefinitions;
import org.flowable.spring.boot.ProcessEngineAutoConfiguration__BeanDefinitions;
import org.flowable.spring.boot.ProcessEngineServicesAutoConfiguration__BeanDefinitions;
import org.flowable.spring.boot.actuate.info.FlowableInfoAutoConfiguration__BeanDefinitions;
import org.flowable.spring.boot.app.AppEngineAutoConfiguration__BeanDefinitions;
import org.flowable.spring.boot.app.AppEngineServicesAutoConfiguration__BeanDefinitions;
import org.flowable.spring.boot.app.FlowableAppProperties__BeanDefinitions;
import org.flowable.spring.boot.cmmn.CmmnEngineAutoConfiguration__BeanDefinitions;
import org.flowable.spring.boot.cmmn.CmmnEngineServicesAutoConfiguration__BeanDefinitions;
import org.flowable.spring.boot.cmmn.FlowableCmmnProperties__BeanDefinitions;
import org.flowable.spring.boot.dmn.DmnEngineAutoConfiguration__BeanDefinitions;
import org.flowable.spring.boot.dmn.DmnEngineServicesAutoConfiguration__BeanDefinitions;
import org.flowable.spring.boot.dmn.FlowableDmnProperties__BeanDefinitions;
import org.flowable.spring.boot.eventregistry.EventRegistryAutoConfiguration__BeanDefinitions;
import org.flowable.spring.boot.eventregistry.EventRegistryServicesAutoConfiguration__BeanDefinitions;
import org.flowable.spring.boot.eventregistry.FlowableEventRegistryProperties__BeanDefinitions;
import org.flowable.spring.boot.idm.FlowableIdmProperties__BeanDefinitions;
import org.flowable.spring.boot.idm.IdmEngineAutoConfiguration__BeanDefinitions;
import org.flowable.spring.boot.idm.IdmEngineServicesAutoConfiguration__BeanDefinitions;
import org.flowable.spring.boot.process.FlowableProcessProperties__BeanDefinitions;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration__BeanDefinitions;
import org.mybatis.spring.boot.autoconfigure.MybatisLanguageDriverAutoConfiguration__BeanDefinitions;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties__BeanDefinitions;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer__BeanDefinitions;
import org.redisson.spring.starter.RedissonAutoConfigurationV2__BeanDefinitions;
import org.redisson.spring.starter.RedissonAutoConfiguration__BeanDefinitions;
import org.redisson.spring.starter.RedissonProperties__BeanDefinitions;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator__BeanDefinitions;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.actuate.autoconfigure.audit.AuditEventsEndpointAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.availability.AvailabilityHealthContributorAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.beans.BeansEndpointAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.cache.CachesEndpointAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.condition.ConditionsReportEndpointAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.context.ShutdownEndpointAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.context.properties.ConfigurationPropertiesReportEndpointAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.context.properties.ConfigurationPropertiesReportEndpointProperties__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.data.redis.RedisHealthContributorAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.data.redis.RedisReactiveHealthContributorAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.endpoint.jackson.JacksonEndpointAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.CorsEndpointProperties__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.ServletEndpointManagementContextConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.servlet.WebMvcEndpointManagementContextConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.env.EnvironmentEndpointAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.env.EnvironmentEndpointProperties__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.health.HealthContributorAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.health.HealthEndpointAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.health.HealthEndpointConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.health.HealthEndpointProperties__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.health.HealthEndpointWebExtensionConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.health.ReactiveHealthEndpointConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.info.InfoContributorAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.info.InfoContributorProperties__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.info.InfoEndpointAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.jdbc.DataSourceHealthContributorAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.jdbc.DataSourceHealthIndicatorProperties__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.liquibase.LiquibaseEndpointAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.logging.LogFileWebEndpointAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.logging.LogFileWebEndpointProperties__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.logging.LoggersEndpointAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.management.HeapDumpWebEndpointAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.management.ThreadDumpEndpointAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.metrics.CompositeMeterRegistryAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.metrics.JvmMetricsAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.metrics.LogbackMetricsAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsEndpointAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.metrics.SystemMetricsAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.metrics.data.RepositoryMetricsAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.metrics.export.simple.SimpleMetricsExportAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.metrics.export.simple.SimpleProperties__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.metrics.integration.IntegrationMetricsAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.metrics.jdbc.DataSourcePoolMetricsAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.metrics.startup.StartupTimeMetricsListenerAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.metrics.task.TaskExecutorMetricsAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.observation.web.client.HttpClientObservationsAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.observation.web.client.RestClientObservationConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.observation.web.client.RestTemplateObservationConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.observation.web.client.WebClientObservationConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.observation.web.servlet.WebMvcObservationAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.scheduling.ScheduledTasksEndpointAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.scheduling.ScheduledTasksObservabilityAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.security.servlet.SecurityRequestMatchersManagementContextConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.system.DiskSpaceHealthContributorAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.system.DiskSpaceHealthIndicatorProperties__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.web.exchanges.HttpExchangesEndpointAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.web.mappings.MappingsEndpointAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.web.server.ManagementContextAutoConfiguration__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.web.server.ManagementServerProperties__BeanDefinitions;
import org.springframework.boot.actuate.autoconfigure.web.servlet.ServletManagementContextAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages__BeanDefinitions;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.availability.ApplicationAvailabilityAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.codec.CodecProperties__BeanDefinitions;
import org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.context.LifecycleProperties__BeanDefinitions;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties__BeanDefinitions;
import org.springframework.boot.autoconfigure.data.redis.RedisReactiveAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties__BeanDefinitions;
import org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.http.JacksonHttpMessageConvertersConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.http.codec.CodecsAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties__BeanDefinitions;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.jackson.JacksonProperties__BeanDefinitions;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties__BeanDefinitions;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.jdbc.JdbcClientAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.jdbc.JdbcProperties__BeanDefinitions;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.jdbc.NamedParameterJdbcTemplateConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.jdbc.metadata.DataSourcePoolMetadataProvidersConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.netty.NettyAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.netty.NettyProperties__BeanDefinitions;
import org.springframework.boot.autoconfigure.reactor.ReactorAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.reactor.ReactorProperties__BeanDefinitions;
import org.springframework.boot.autoconfigure.reactor.netty.ReactorNettyConfigurations__BeanDefinitions;
import org.springframework.boot.autoconfigure.reactor.netty.ReactorNettyProperties__BeanDefinitions;
import org.springframework.boot.autoconfigure.security.SecurityProperties__BeanDefinitions;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.security.servlet.SpringBootWebSecurityConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.sql.init.DataSourceInitializationConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationProperties__BeanDefinitions;
import org.springframework.boot.autoconfigure.ssl.SslAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.ssl.SslProperties__BeanDefinitions;
import org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.task.TaskExecutionProperties__BeanDefinitions;
import org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations__BeanDefinitions;
import org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.task.TaskSchedulingConfigurations__BeanDefinitions;
import org.springframework.boot.autoconfigure.task.TaskSchedulingProperties__BeanDefinitions;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizationAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.transaction.TransactionProperties__BeanDefinitions;
import org.springframework.boot.autoconfigure.web.ServerProperties__BeanDefinitions;
import org.springframework.boot.autoconfigure.web.WebProperties__BeanDefinitions;
import org.springframework.boot.autoconfigure.web.client.RestClientAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.web.reactive.function.client.ClientHttpConnectorAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.web.reactive.function.client.ClientHttpConnectorFactoryConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.web.servlet.MultipartProperties__BeanDefinitions;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties__BeanDefinitions;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration__BeanDefinitions;
import org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration__BeanDefinitions;
import org.springframework.boot.context.properties.BoundConfigurationProperties__BeanDefinitions;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinder__BeanDefinitions;
import org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor__BeanDefinitions;
import org.springframework.boot.jackson.JsonMixinModuleEntries__BeanDefinitions;
import org.springframework.boot.sql.init.dependency.DatabaseInitializationDependencyConfigurer__BeanDefinitions;
import org.springframework.boot.validation.beanvalidation.MethodValidationExcludeFilter__BeanDefinitions;
import org.springframework.boot.web.server.ErrorPageRegistrarBeanPostProcessor__BeanDefinitions;
import org.springframework.boot.web.server.WebServerFactoryCustomizerBeanPostProcessor__BeanDefinitions;
import org.springframework.boot.web.servlet.FilterRegistrationBean__BeanDefinitions;
import org.springframework.cloud.autoconfigure.ConfigurationPropertiesRebinderAutoConfiguration__BeanDefinitions;
import org.springframework.cloud.autoconfigure.LifecycleMvcEndpointAutoConfiguration__BeanDefinitions;
import org.springframework.cloud.autoconfigure.PauseResumeEndpointsConfiguration__BeanDefinitions;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration__BeanDefinitions;
import org.springframework.cloud.autoconfigure.RefreshEndpointAutoConfiguration__BeanDefinitions;
import org.springframework.cloud.autoconfigure.RestartEndpointWithoutIntegrationConfiguration__BeanDefinitions;
import org.springframework.cloud.client.CommonsClientAutoConfiguration__BeanDefinitions;
import org.springframework.cloud.client.ReactiveCommonsClientAutoConfiguration__BeanDefinitions;
import org.springframework.cloud.client.discovery.composite.CompositeDiscoveryClientAutoConfiguration__BeanDefinitions;
import org.springframework.cloud.client.discovery.composite.reactive.ReactiveCompositeDiscoveryClientAutoConfiguration__BeanDefinitions;
import org.springframework.cloud.client.discovery.health.DiscoveryClientHealthIndicatorProperties__BeanDefinitions;
import org.springframework.cloud.client.discovery.simple.SimpleDiscoveryClientAutoConfiguration__BeanDefinitions;
import org.springframework.cloud.client.discovery.simple.reactive.SimpleReactiveDiscoveryClientAutoConfiguration__BeanDefinitions;
import org.springframework.cloud.client.loadbalancer.LoadBalancerDefaultMappingsProviderAutoConfiguration__BeanDefinitions;
import org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationAutoConfiguration__BeanDefinitions;
import org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationConfiguration__BeanDefinitions;
import org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationProperties__BeanDefinitions;
import org.springframework.cloud.client.serviceregistry.ServiceRegistryAutoConfiguration__BeanDefinitions;
import org.springframework.cloud.commons.config.CommonsConfigAutoConfiguration__BeanDefinitions;
import org.springframework.cloud.commons.security.ResourceServerTokenRelayAutoConfiguration__BeanDefinitions;
import org.springframework.cloud.commons.util.UtilAutoConfiguration__BeanDefinitions;
import org.springframework.cloud.configuration.CompatibilityVerifierAutoConfiguration__BeanDefinitions;
import org.springframework.cloud.configuration.CompatibilityVerifierProperties__BeanDefinitions;
import org.springframework.context.event.DefaultEventListenerFactory__BeanDefinitions;
import org.springframework.context.event.EventListenerMethodProcessor__BeanDefinitions;
import org.springframework.core.ResolvableType;
import org.springframework.data.redis.core.RedisKeyValueAdapter__BeanDefinitions;
import org.springframework.data.redis.core.RedisKeyValueTemplate__BeanDefinitions;
import org.springframework.data.redis.core.convert.KeyspaceConfiguration__BeanDefinitions;
import org.springframework.data.redis.core.convert.MappingConfiguration__BeanDefinitions;
import org.springframework.data.redis.core.convert.MappingRedisConverter__BeanDefinitions;
import org.springframework.data.redis.core.convert.RedisCustomConversions__BeanDefinitions;
import org.springframework.data.redis.core.convert.ReferenceResolverImpl__BeanDefinitions;
import org.springframework.data.redis.core.index.IndexConfiguration__BeanDefinitions;
import org.springframework.data.redis.core.mapping.RedisMappingContext__BeanDefinitions;
import org.springframework.data.web.config.ProjectingArgumentResolverRegistrar__BeanDefinitions;
import org.springframework.data.web.config.SpringDataJacksonConfiguration__BeanDefinitions;
import org.springframework.data.web.config.SpringDataWebConfiguration__BeanDefinitions;
import org.springframework.scheduling.annotation.ProxyAsyncConfiguration__BeanDefinitions;
import org.springframework.scheduling.annotation.SchedulingConfiguration__BeanDefinitions;
import org.springframework.security.access.intercept.aopalliance.MethodSecurityMetadataSourceAdvisor__BeanDefinitions;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration__BeanDefinitions;
import org.springframework.security.config.annotation.configuration.ObjectPostProcessorConfiguration__BeanDefinitions;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration__BeanDefinitions;
import org.springframework.security.config.annotation.web.configuration.HttpSecurityConfiguration__BeanDefinitions;
import org.springframework.security.config.annotation.web.configuration.WebMvcSecurityConfiguration__BeanDefinitions;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration__BeanDefinitions;
import org.springframework.security.web.access.HandlerMappingIntrospectorRequestTransformer__BeanDefinitions;
import org.springframework.transaction.annotation.AbstractTransactionManagementConfiguration__BeanDefinitions;
import org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration__BeanDefinitions;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport__BeanDefinitions;

/**
 * Register bean definitions for the bean factory.
 */
@Generated
public class Main__BeanFactoryRegistrations {
  /**
   * Get the bean instance supplier for 'bookMapper'.
   */
  private static BeanInstanceSupplier<MapperFactoryBean> getBookMapperInstanceSupplier() {
    return BeanInstanceSupplier.<MapperFactoryBean>forConstructor(Class.class)
            .withGenerator((registeredBean, args) -> new MapperFactoryBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'bookMapper'.
   */
  private static BeanDefinition getBookMapperBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MapperFactoryBean.class);
    beanDefinition.setTargetType(ResolvableType.forClass(MapperFactoryBean.class));
    beanDefinition.setLazyInit(false);
    beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("com.xiacong.mapper.BookMapper");
    beanDefinition.getPropertyValues().addPropertyValue("mapperInterface", BookMapper.class);
    beanDefinition.getPropertyValues().addPropertyValue("addToConfig", true);
    beanDefinition.setInstanceSupplier(getBookMapperInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'sysGroupMapper'.
   */
  private static BeanInstanceSupplier<MapperFactoryBean> getSysGroupMapperInstanceSupplier() {
    return BeanInstanceSupplier.<MapperFactoryBean>forConstructor(Class.class)
            .withGenerator((registeredBean, args) -> new MapperFactoryBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'sysGroupMapper'.
   */
  private static BeanDefinition getSysGroupMapperBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MapperFactoryBean.class);
    beanDefinition.setTargetType(ResolvableType.forClass(MapperFactoryBean.class));
    beanDefinition.setLazyInit(false);
    beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("com.xiacong.mapper.SysGroupMapper");
    beanDefinition.getPropertyValues().addPropertyValue("mapperInterface", SysGroupMapper.class);
    beanDefinition.getPropertyValues().addPropertyValue("addToConfig", true);
    beanDefinition.setInstanceSupplier(getSysGroupMapperInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'sysGroupRoleMapper'.
   */
  private static BeanInstanceSupplier<MapperFactoryBean> getSysGroupRoleMapperInstanceSupplier() {
    return BeanInstanceSupplier.<MapperFactoryBean>forConstructor(Class.class)
            .withGenerator((registeredBean, args) -> new MapperFactoryBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'sysGroupRoleMapper'.
   */
  private static BeanDefinition getSysGroupRoleMapperBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MapperFactoryBean.class);
    beanDefinition.setTargetType(ResolvableType.forClass(MapperFactoryBean.class));
    beanDefinition.setLazyInit(false);
    beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("com.xiacong.mapper.SysGroupRoleMapper");
    beanDefinition.getPropertyValues().addPropertyValue("mapperInterface", SysGroupRoleMapper.class);
    beanDefinition.getPropertyValues().addPropertyValue("addToConfig", true);
    beanDefinition.setInstanceSupplier(getSysGroupRoleMapperInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'sysPermissionMapper'.
   */
  private static BeanInstanceSupplier<MapperFactoryBean> getSysPermissionMapperInstanceSupplier() {
    return BeanInstanceSupplier.<MapperFactoryBean>forConstructor(Class.class)
            .withGenerator((registeredBean, args) -> new MapperFactoryBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'sysPermissionMapper'.
   */
  private static BeanDefinition getSysPermissionMapperBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MapperFactoryBean.class);
    beanDefinition.setTargetType(ResolvableType.forClass(MapperFactoryBean.class));
    beanDefinition.setLazyInit(false);
    beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("com.xiacong.mapper.SysPermissionMapper");
    beanDefinition.getPropertyValues().addPropertyValue("mapperInterface", SysPermissionMapper.class);
    beanDefinition.getPropertyValues().addPropertyValue("addToConfig", true);
    beanDefinition.setInstanceSupplier(getSysPermissionMapperInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'sysRoleMapper'.
   */
  private static BeanInstanceSupplier<MapperFactoryBean> getSysRoleMapperInstanceSupplier() {
    return BeanInstanceSupplier.<MapperFactoryBean>forConstructor(Class.class)
            .withGenerator((registeredBean, args) -> new MapperFactoryBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'sysRoleMapper'.
   */
  private static BeanDefinition getSysRoleMapperBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MapperFactoryBean.class);
    beanDefinition.setTargetType(ResolvableType.forClass(MapperFactoryBean.class));
    beanDefinition.setLazyInit(false);
    beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("com.xiacong.mapper.SysRoleMapper");
    beanDefinition.getPropertyValues().addPropertyValue("mapperInterface", SysRoleMapper.class);
    beanDefinition.getPropertyValues().addPropertyValue("addToConfig", true);
    beanDefinition.setInstanceSupplier(getSysRoleMapperInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'sysRolePermissionMapper'.
   */
  private static BeanInstanceSupplier<MapperFactoryBean> getSysRolePermissionMapperInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MapperFactoryBean>forConstructor(Class.class)
            .withGenerator((registeredBean, args) -> new MapperFactoryBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'sysRolePermissionMapper'.
   */
  private static BeanDefinition getSysRolePermissionMapperBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MapperFactoryBean.class);
    beanDefinition.setTargetType(ResolvableType.forClass(MapperFactoryBean.class));
    beanDefinition.setLazyInit(false);
    beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("com.xiacong.mapper.SysRolePermissionMapper");
    beanDefinition.getPropertyValues().addPropertyValue("mapperInterface", SysRolePermissionMapper.class);
    beanDefinition.getPropertyValues().addPropertyValue("addToConfig", true);
    beanDefinition.setInstanceSupplier(getSysRolePermissionMapperInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'sysUsrGroupMapper'.
   */
  private static BeanInstanceSupplier<MapperFactoryBean> getSysUsrGroupMapperInstanceSupplier() {
    return BeanInstanceSupplier.<MapperFactoryBean>forConstructor(Class.class)
            .withGenerator((registeredBean, args) -> new MapperFactoryBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'sysUsrGroupMapper'.
   */
  private static BeanDefinition getSysUsrGroupMapperBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MapperFactoryBean.class);
    beanDefinition.setTargetType(ResolvableType.forClass(MapperFactoryBean.class));
    beanDefinition.setLazyInit(false);
    beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("com.xiacong.mapper.SysUsrGroupMapper");
    beanDefinition.getPropertyValues().addPropertyValue("mapperInterface", SysUsrGroupMapper.class);
    beanDefinition.getPropertyValues().addPropertyValue("addToConfig", true);
    beanDefinition.setInstanceSupplier(getSysUsrGroupMapperInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'sysUsrMapper'.
   */
  private static BeanInstanceSupplier<MapperFactoryBean> getSysUsrMapperInstanceSupplier() {
    return BeanInstanceSupplier.<MapperFactoryBean>forConstructor(Class.class)
            .withGenerator((registeredBean, args) -> new MapperFactoryBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'sysUsrMapper'.
   */
  private static BeanDefinition getSysUsrMapperBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MapperFactoryBean.class);
    beanDefinition.setTargetType(ResolvableType.forClass(MapperFactoryBean.class));
    beanDefinition.setLazyInit(false);
    beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("com.xiacong.mapper.SysUsrMapper");
    beanDefinition.getPropertyValues().addPropertyValue("mapperInterface", SysUsrMapper.class);
    beanDefinition.getPropertyValues().addPropertyValue("addToConfig", true);
    beanDefinition.setInstanceSupplier(getSysUsrMapperInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'sysUsrRoleMapper'.
   */
  private static BeanInstanceSupplier<MapperFactoryBean> getSysUsrRoleMapperInstanceSupplier() {
    return BeanInstanceSupplier.<MapperFactoryBean>forConstructor(Class.class)
            .withGenerator((registeredBean, args) -> new MapperFactoryBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'sysUsrRoleMapper'.
   */
  private static BeanDefinition getSysUsrRoleMapperBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MapperFactoryBean.class);
    beanDefinition.setTargetType(ResolvableType.forClass(MapperFactoryBean.class));
    beanDefinition.setLazyInit(false);
    beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("com.xiacong.mapper.SysUsrRoleMapper");
    beanDefinition.getPropertyValues().addPropertyValue("mapperInterface", SysUsrRoleMapper.class);
    beanDefinition.getPropertyValues().addPropertyValue("addToConfig", true);
    beanDefinition.setInstanceSupplier(getSysUsrRoleMapperInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'virtualTableColumnsMapper'.
   */
  private static BeanInstanceSupplier<MapperFactoryBean> getVirtualTableColumnsMapperInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MapperFactoryBean>forConstructor(Class.class)
            .withGenerator((registeredBean, args) -> new MapperFactoryBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'virtualTableColumnsMapper'.
   */
  private static BeanDefinition getVirtualTableColumnsMapperBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MapperFactoryBean.class);
    beanDefinition.setTargetType(ResolvableType.forClass(MapperFactoryBean.class));
    beanDefinition.setLazyInit(false);
    beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("com.xiacong.mapper.VirtualTableColumnsMapper");
    beanDefinition.getPropertyValues().addPropertyValue("mapperInterface", VirtualTableColumnsMapper.class);
    beanDefinition.getPropertyValues().addPropertyValue("addToConfig", true);
    beanDefinition.setInstanceSupplier(getVirtualTableColumnsMapperInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'virtualTableDataMapper'.
   */
  private static BeanInstanceSupplier<MapperFactoryBean> getVirtualTableDataMapperInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MapperFactoryBean>forConstructor(Class.class)
            .withGenerator((registeredBean, args) -> new MapperFactoryBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'virtualTableDataMapper'.
   */
  private static BeanDefinition getVirtualTableDataMapperBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MapperFactoryBean.class);
    beanDefinition.setTargetType(ResolvableType.forClass(MapperFactoryBean.class));
    beanDefinition.setLazyInit(false);
    beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("com.xiacong.mapper.VirtualTableDataMapper");
    beanDefinition.getPropertyValues().addPropertyValue("mapperInterface", VirtualTableDataMapper.class);
    beanDefinition.getPropertyValues().addPropertyValue("addToConfig", true);
    beanDefinition.setInstanceSupplier(getVirtualTableDataMapperInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'virtualTableIndexMapper'.
   */
  private static BeanInstanceSupplier<MapperFactoryBean> getVirtualTableIndexMapperInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MapperFactoryBean>forConstructor(Class.class)
            .withGenerator((registeredBean, args) -> new MapperFactoryBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'virtualTableIndexMapper'.
   */
  private static BeanDefinition getVirtualTableIndexMapperBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MapperFactoryBean.class);
    beanDefinition.setTargetType(ResolvableType.forClass(MapperFactoryBean.class));
    beanDefinition.setLazyInit(false);
    beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("com.xiacong.mapper.VirtualTableIndexMapper");
    beanDefinition.getPropertyValues().addPropertyValue("mapperInterface", VirtualTableIndexMapper.class);
    beanDefinition.getPropertyValues().addPropertyValue("addToConfig", true);
    beanDefinition.setInstanceSupplier(getVirtualTableIndexMapperInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'virtualTableMapper'.
   */
  private static BeanInstanceSupplier<MapperFactoryBean> getVirtualTableMapperInstanceSupplier() {
    return BeanInstanceSupplier.<MapperFactoryBean>forConstructor(Class.class)
            .withGenerator((registeredBean, args) -> new MapperFactoryBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'virtualTableMapper'.
   */
  private static BeanDefinition getVirtualTableMapperBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MapperFactoryBean.class);
    beanDefinition.setTargetType(ResolvableType.forClass(MapperFactoryBean.class));
    beanDefinition.setLazyInit(false);
    beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("com.xiacong.mapper.VirtualTableMapper");
    beanDefinition.getPropertyValues().addPropertyValue("mapperInterface", VirtualTableMapper.class);
    beanDefinition.getPropertyValues().addPropertyValue("addToConfig", true);
    beanDefinition.setInstanceSupplier(getVirtualTableMapperInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Register the bean definitions.
   */
  public void registerBeanDefinitions(DefaultListableBeanFactory beanFactory) {
    beanFactory.registerBeanDefinition("org.springframework.context.event.internalEventListenerProcessor", EventListenerMethodProcessor__BeanDefinitions.getInternalEventListenerProcessorBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.context.event.internalEventListenerFactory", DefaultEventListenerFactory__BeanDefinitions.getInternalEventListenerFactoryBeanDefinition());
    beanFactory.registerBeanDefinition("main", Main__BeanDefinitions.getMainBeanDefinition());
    beanFactory.registerBeanDefinition("myBeanFactoryPostProcessor", MyBeanFactoryPostProcessor__BeanDefinitions.getMyBeanFactoryPostProcessorBeanDefinition());
    beanFactory.registerBeanDefinition("bookController", BookController__BeanDefinitions.getBookControllerBeanDefinition());
    beanFactory.registerBeanDefinition("testController", TestController__BeanDefinitions.getTestControllerBeanDefinition());
    beanFactory.registerBeanDefinition("flowDataLoadListener", FlowDataLoadListener__BeanDefinitions.getFlowDataLoadListenerBeanDefinition());
    beanFactory.registerBeanDefinition("testProviderImpl", TestProviderImpl__BeanDefinitions.getTestProviderImplBeanDefinition());
    beanFactory.registerBeanDefinition("bookServiceImpl", BookServiceImpl__BeanDefinitions.getBookServiceImplBeanDefinition());
    beanFactory.registerBeanDefinition("localTaskExample", LocalTaskExample__BeanDefinitions.getLocalTaskExampleBeanDefinition());
    beanFactory.registerBeanDefinition("restExceptionHandler", RestExceptionHandler__BeanDefinitions.getRestExceptionHandlerBeanDefinition());
    beanFactory.registerBeanDefinition("rpcExceptionInterceptorConfig", RpcExceptionInterceptorConfig__BeanDefinitions.getRpcExceptionInterceptorConfigBeanDefinition());
    beanFactory.registerBeanDefinition("executorConfig", ExecutorConfig__BeanDefinitions.getExecutorConfigBeanDefinition());
    beanFactory.registerBeanDefinition("applicationContextUtil", ApplicationContextUtil__BeanDefinitions.getApplicationContextUtilBeanDefinition());
    beanFactory.registerBeanDefinition("securityConfiguration", SecurityConfiguration__BeanDefinitions.getSecurityConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("loginController", LoginController__BeanDefinitions.getLoginControllerBeanDefinition());
    beanFactory.registerBeanDefinition("jwtAuthenticationFilter", JwtAuthenticationFilter__BeanDefinitions.getJwtAuthenticationFilterBeanDefinition());
    beanFactory.registerBeanDefinition("appAuthenticationProviderImpl", AppAuthenticationProviderImpl__BeanDefinitions.getAppAuthenticationProviderImplBeanDefinition());
    beanFactory.registerBeanDefinition("jwtAccessDeniedHandler", JwtAccessDeniedHandler__BeanDefinitions.getJwtAccessDeniedHandlerBeanDefinition());
    beanFactory.registerBeanDefinition("jwtAuthenticationEntryPoint", JwtAuthenticationEntryPoint__BeanDefinitions.getJwtAuthenticationEntryPointBeanDefinition());
    beanFactory.registerBeanDefinition("jwtLogoutSuccessHandler", JwtLogoutSuccessHandler__BeanDefinitions.getJwtLogoutSuccessHandlerBeanDefinition());
    beanFactory.registerBeanDefinition("loginFailureHandler", LoginFailureHandler__BeanDefinitions.getLoginFailureHandlerBeanDefinition());
    beanFactory.registerBeanDefinition("loginSuccessHandler", LoginSuccessHandler__BeanDefinitions.getLoginSuccessHandlerBeanDefinition());
    beanFactory.registerBeanDefinition("loginServiceImpl", LoginServiceImpl__BeanDefinitions.getLoginServiceImplBeanDefinition());
    beanFactory.registerBeanDefinition("sysGroupRoleServiceImpl", SysGroupRoleServiceImpl__BeanDefinitions.getSysGroupRoleServiceImplBeanDefinition());
    beanFactory.registerBeanDefinition("sysGroupServiceImpl", SysGroupServiceImpl__BeanDefinitions.getSysGroupServiceImplBeanDefinition());
    beanFactory.registerBeanDefinition("sysPermissionServiceImpl", SysPermissionServiceImpl__BeanDefinitions.getSysPermissionServiceImplBeanDefinition());
    beanFactory.registerBeanDefinition("sysRolePermissionServiceImpl", SysRolePermissionServiceImpl__BeanDefinitions.getSysRolePermissionServiceImplBeanDefinition());
    beanFactory.registerBeanDefinition("sysRoleServiceImpl", SysRoleServiceImpl__BeanDefinitions.getSysRoleServiceImplBeanDefinition());
    beanFactory.registerBeanDefinition("sysUsrGroupServiceImpl", SysUsrGroupServiceImpl__BeanDefinitions.getSysUsrGroupServiceImplBeanDefinition());
    beanFactory.registerBeanDefinition("sysUsrRoleServiceImpl", SysUsrRoleServiceImpl__BeanDefinitions.getSysUsrRoleServiceImplBeanDefinition());
    beanFactory.registerBeanDefinition("sysUsrServiceImpl", SysUsrServiceImpl__BeanDefinitions.getSysUsrServiceImplBeanDefinition());
    beanFactory.registerBeanDefinition("userDetailsServiceImpl", UserDetailsServiceImpl__BeanDefinitions.getUserDetailsServiceImplBeanDefinition());
    beanFactory.registerBeanDefinition("jwtUtil", JwtUtil__BeanDefinitions.getJwtUtilBeanDefinition());
    beanFactory.registerBeanDefinition("userInfoRedisUtil", UserInfoRedisUtil__BeanDefinitions.getUserInfoRedisUtilBeanDefinition());
    beanFactory.registerBeanDefinition("redissionConverter", RedissionConverter__BeanDefinitions.getRedissionConverterBeanDefinition());
    beanFactory.registerBeanDefinition("redisRepositoryImpl", RedisRepositoryImpl__BeanDefinitions.getRedisRepositoryImplBeanDefinition());
    beanFactory.registerBeanDefinition("redisSequenceUtil", RedisSequenceUtil__BeanDefinitions.getRedisSequenceUtilBeanDefinition());
    beanFactory.registerBeanDefinition("redissonUtil", RedissonUtil__BeanDefinitions.getRedissonUtilBeanDefinition());
    beanFactory.registerBeanDefinition("virtualTableConverter", VirtualTableConverter__BeanDefinitions.getVirtualTableConverterBeanDefinition());
    beanFactory.registerBeanDefinition("cacheManagerRegister", CacheManagerRegister__BeanDefinitions.getCacheManagerRegisterBeanDefinition());
    beanFactory.registerBeanDefinition("virtualTableCache", VirtualTableCache__BeanDefinitions.getVirtualTableCacheBeanDefinition());
    beanFactory.registerBeanDefinition("virtualTableCacheManager", VirtualTableCacheManager__BeanDefinitions.getVirtualTableCacheManagerBeanDefinition());
    beanFactory.registerBeanDefinition("virtualTableColumnsCache", VirtualTableColumnsCache__BeanDefinitions.getVirtualTableColumnsCacheBeanDefinition());
    beanFactory.registerBeanDefinition("virtualTableColumnsCacheManager", VirtualTableColumnsCacheManager__BeanDefinitions.getVirtualTableColumnsCacheManagerBeanDefinition());
    beanFactory.registerBeanDefinition("virtualTableDataCache", VirtualTableDataCache__BeanDefinitions.getVirtualTableDataCacheBeanDefinition());
    beanFactory.registerBeanDefinition("virtualTableDataCacheManager", VirtualTableDataCacheManager__BeanDefinitions.getVirtualTableDataCacheManagerBeanDefinition());
    beanFactory.registerBeanDefinition("virtualTableIndexCache", VirtualTableIndexCache__BeanDefinitions.getVirtualTableIndexCacheBeanDefinition());
    beanFactory.registerBeanDefinition("virtualTableIndexCacheManager", VirtualTableIndexCacheManager__BeanDefinitions.getVirtualTableIndexCacheManagerBeanDefinition());
    beanFactory.registerBeanDefinition("virtualTableDbRepositoryImpl", VirtualTableDbRepositoryImpl__BeanDefinitions.getVirtualTableDbRepositoryImplBeanDefinition());
    beanFactory.registerBeanDefinition("virtualTableColumnsController", VirtualTableColumnsController__BeanDefinitions.getVirtualTableColumnsControllerBeanDefinition());
    beanFactory.registerBeanDefinition("virtualTableController", VirtualTableController__BeanDefinitions.getVirtualTableControllerBeanDefinition());
    beanFactory.registerBeanDefinition("virtualTableDataController", VirtualTableDataController__BeanDefinitions.getVirtualTableDataControllerBeanDefinition());
    beanFactory.registerBeanDefinition("virtualTableIndexController", VirtualTableIndexController__BeanDefinitions.getVirtualTableIndexControllerBeanDefinition());
    beanFactory.registerBeanDefinition("cacheRefershListener", CacheRefershListener__BeanDefinitions.getCacheRefershListenerBeanDefinition());
    beanFactory.registerBeanDefinition("virtualTableColumnsServiceImpl", VirtualTableColumnsServiceImpl__BeanDefinitions.getVirtualTableColumnsServiceImplBeanDefinition());
    beanFactory.registerBeanDefinition("virtualTableDataServiceImpl", VirtualTableDataServiceImpl__BeanDefinitions.getVirtualTableDataServiceImplBeanDefinition());
    beanFactory.registerBeanDefinition("virtualTableIndexServiceImpl", VirtualTableIndexServiceImpl__BeanDefinitions.getVirtualTableIndexServiceImplBeanDefinition());
    beanFactory.registerBeanDefinition("virtualTableServiceImpl", VirtualTableServiceImpl__BeanDefinitions.getVirtualTableServiceImplBeanDefinition());
    beanFactory.registerBeanDefinition("flowEngine", FlowEngine__BeanDefinitions.getFlowEngineBeanDefinition());
    beanFactory.registerBeanDefinition("flowFactory", FlowFactory__BeanDefinitions.getFlowFactoryBeanDefinition());
    beanFactory.registerBeanDefinition("defaultPointcutAdvisor2", RpcExceptionInterceptorConfig__BeanDefinitions.getDefaultPointcutAdvisorBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.scheduling.annotation.ProxyAsyncConfiguration", ProxyAsyncConfiguration__BeanDefinitions.getProxyAsyncConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.context.annotation.internalAsyncAnnotationProcessor", ProxyAsyncConfiguration__BeanDefinitions.getInternalAsyncAnnotationProcessorBeanDefinition());
    beanFactory.registerBeanDefinition("controlAsync", ExecutorConfig__BeanDefinitions.getControlAsyncBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.security.config.annotation.configuration.ObjectPostProcessorConfiguration", ObjectPostProcessorConfiguration__BeanDefinitions.getObjectPostProcessorConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("objectPostProcessor", ObjectPostProcessorConfiguration__BeanDefinitions.getObjectPostProcessorBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration", AuthenticationConfiguration__BeanDefinitions.getAuthenticationConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("authenticationManagerBuilder", AuthenticationConfiguration__BeanDefinitions.getAuthenticationManagerBuilderBeanDefinition());
    beanFactory.registerBeanDefinition("enableGlobalAuthenticationAutowiredConfigurer", AuthenticationConfiguration__BeanDefinitions.getEnableGlobalAuthenticationAutowiredConfigurerBeanDefinition());
    beanFactory.registerBeanDefinition("initializeUserDetailsBeanManagerConfigurer", AuthenticationConfiguration__BeanDefinitions.getInitializeUserDetailsBeanManagerConfigurerBeanDefinition());
    beanFactory.registerBeanDefinition("initializeAuthenticationProviderBeanManagerConfigurer", AuthenticationConfiguration__BeanDefinitions.getInitializeAuthenticationProviderBeanManagerConfigurerBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration", WebSecurityConfiguration__BeanDefinitions.getWebSecurityConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("delegatingApplicationListener", WebSecurityConfiguration__BeanDefinitions.getDelegatingApplicationListenerBeanDefinition());
    beanFactory.registerBeanDefinition("webSecurityExpressionHandler", WebSecurityConfiguration__BeanDefinitions.getWebSecurityExpressionHandlerBeanDefinition());
    beanFactory.registerBeanDefinition("privilegeEvaluator", WebSecurityConfiguration__BeanDefinitions.getPrivilegeEvaluatorBeanDefinition());
    beanFactory.registerBeanDefinition("conversionServicePostProcessor", WebSecurityConfiguration__BeanDefinitions.getConversionServicePostProcessorBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.security.config.annotation.web.configuration.WebMvcSecurityConfiguration", WebMvcSecurityConfiguration__BeanDefinitions.getWebMvcSecurityConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("requestDataValueProcessor", WebMvcSecurityConfiguration__BeanDefinitions.getRequestDataValueProcessorBeanDefinition());
    beanFactory.registerBeanDefinition("springSecurityHandlerMappingIntrospectorBeanDefinitionRegistryPostProcessor", WebMvcSecurityConfiguration__BeanDefinitions.getSpringSecurityHandlerMappingIntrospectorBeanDefinitionRegistryPostProcessorBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.security.config.annotation.web.configuration.HttpSecurityConfiguration", HttpSecurityConfiguration__BeanDefinitions.getHttpSecurityConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.security.config.annotation.web.configuration.HttpSecurityConfiguration.httpSecurity", HttpSecurityConfiguration__BeanDefinitions.getHttpSecurityBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration", GlobalMethodSecurityConfiguration__BeanDefinitions.getGlobalMethodSecurityConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("methodSecurityInterceptor", GlobalMethodSecurityConfiguration__BeanDefinitions.getMethodSecurityInterceptorBeanDefinition());
    beanFactory.registerBeanDefinition("methodSecurityMetadataSource", GlobalMethodSecurityConfiguration__BeanDefinitions.getMethodSecurityMetadataSourceBeanDefinition());
    beanFactory.registerBeanDefinition("preInvocationAuthorizationAdvice", GlobalMethodSecurityConfiguration__BeanDefinitions.getPreInvocationAuthorizationAdviceBeanDefinition());
    beanFactory.registerBeanDefinition("passwordEncoder", SecurityConfiguration__BeanDefinitions.getPasswordEncoderBeanDefinition());
    beanFactory.registerBeanDefinition("authenticationManager", SecurityConfiguration__BeanDefinitions.getAuthenticationManagerBeanDefinition());
    beanFactory.registerBeanDefinition("filterChain", SecurityConfiguration__BeanDefinitions.getFilterChainBeanDefinition());
    beanFactory.registerBeanDefinition("corsConfigurationSource", SecurityConfiguration__BeanDefinitions.getCorsConfigurationSourceBeanDefinition());
    beanFactory.registerBeanDefinition("metaDataSourceAdvisor", MethodSecurityMetadataSourceAdvisor__BeanDefinitions.getMetaDataSourceAdvisorBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.aop.config.internalAutoProxyCreator", AnnotationAwareAspectJAutoProxyCreator__BeanDefinitions.getInternalAutoProxyCreatorBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.scheduling.annotation.SchedulingConfiguration", SchedulingConfiguration__BeanDefinitions.getSchedulingConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.context.annotation.internalScheduledAnnotationProcessor", SchedulingConfiguration__BeanDefinitions.getInternalScheduledAnnotationProcessorBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.AutoConfigurationPackages", AutoConfigurationPackages__BeanDefinitions.BasePackages.getAutoConfigurationPackagesBeanDefinition());
    beanFactory.registerBeanDefinition("com.xiacong.Main#MapperScannerRegistrar#0", MapperScannerConfigurer__BeanDefinitions.getMainMapperScannerRegistrarBeanDefinition());
    beanFactory.registerBeanDefinition("dubboServicePackagesHolder", ServicePackagesHolder__BeanDefinitions.getDubboServicePackagesHolderBeanDefinition());
    beanFactory.registerBeanDefinition("dubboContextPostProcessor", DubboContextPostProcessor__BeanDefinitions.getDubboContextPostProcessorBeanDefinition());
    beanFactory.registerBeanDefinition("dubboReferenceBeanManager", ReferenceBeanManager__BeanDefinitions.getDubboReferenceBeanManagerBeanDefinition());
    beanFactory.registerBeanDefinition("dubboConfigAliasPostProcessor", DubboConfigAliasPostProcessor__BeanDefinitions.getDubboConfigAliasPostProcessorBeanDefinition());
    beanFactory.registerBeanDefinition("org.apache.dubbo.config.spring.context.DubboDeployApplicationListener", DubboDeployApplicationListener__BeanDefinitions.getDubboDeployApplicationListenerBeanDefinition());
    beanFactory.registerBeanDefinition("org.apache.dubbo.config.spring.context.DubboConfigApplicationListener", DubboConfigApplicationListener__BeanDefinitions.getDubboConfigApplicationListenerBeanDefinition());
    beanFactory.registerBeanDefinition("dubboConfigDefaultPropertyValueBeanPostProcessor", DubboConfigDefaultPropertyValueBeanPostProcessor__BeanDefinitions.getDubboConfigDefaultPropertyValueBeanPostProcessorBeanDefinition());
    beanFactory.registerBeanDefinition("dubboConfigBeanInitializer", DubboConfigBeanInitializer__BeanDefinitions.getDubboConfigBeanInitializerBeanDefinition());
    beanFactory.registerBeanDefinition("org.apache.dubbo.config.spring.beans.factory.annotation.ServiceAnnotationPostProcessor#0", ServiceAnnotationPostProcessor__BeanDefinitions.getServiceAnnotationPostProcessorBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationConfiguration", AutoServiceRegistrationConfiguration__BeanDefinitions.getAutoServiceRegistrationConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor", ConfigurationPropertiesBindingPostProcessor__BeanDefinitions.getConfigurationPropertiesBindingPostProcessorBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.context.internalConfigurationPropertiesBinder", ConfigurationPropertiesBinder__BeanDefinitions.ConfigurationPropertiesBinderFactory.getInternalConfigurationPropertiesBinderBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.context.properties.BoundConfigurationProperties", BoundConfigurationProperties__BeanDefinitions.getBoundConfigurationPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.context.properties.EnableConfigurationPropertiesRegistrar.methodValidationExcludeFilter", MethodValidationExcludeFilter__BeanDefinitions.getMethodValidationExcludeFilterBeanDefinition());
    beanFactory.registerBeanDefinition("spring.cloud.service-registry.auto-registration-org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationProperties", AutoServiceRegistrationProperties__BeanDefinitions.getAutoServiceRegistrationPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration", PropertyPlaceholderAutoConfiguration__BeanDefinitions.getPropertyPlaceholderAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("propertySourcesPlaceholderConfigurer", PropertyPlaceholderAutoConfiguration__BeanDefinitions.getPropertySourcesPlaceholderConfigurerBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.ssl.SslAutoConfiguration", SslAutoConfiguration__BeanDefinitions.getSslAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("fileWatcher", SslAutoConfiguration__BeanDefinitions.getFileWatcherBeanDefinition());
    beanFactory.registerBeanDefinition("sslPropertiesSslBundleRegistrar", SslAutoConfiguration__BeanDefinitions.getSslPropertiesSslBundleRegistrarBeanDefinition());
    beanFactory.registerBeanDefinition("sslBundleRegistry", SslAutoConfiguration__BeanDefinitions.getSslBundleRegistryBeanDefinition());
    beanFactory.registerBeanDefinition("spring.ssl-org.springframework.boot.autoconfigure.ssl.SslProperties", SslProperties__BeanDefinitions.getSslPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration$UndertowWebSocketConfiguration", WebSocketServletAutoConfiguration__BeanDefinitions.UndertowWebSocketConfiguration.getUndertowWebSocketConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("websocketServletWebServerCustomizer", WebSocketServletAutoConfiguration__BeanDefinitions.UndertowWebSocketConfiguration.getWebsocketServletWebServerCustomizerBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration", WebSocketServletAutoConfiguration__BeanDefinitions.getWebSocketServletAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryConfiguration$EmbeddedUndertow", ServletWebServerFactoryConfiguration__BeanDefinitions.EmbeddedUndertow.getEmbeddedUndertowBeanDefinition());
    beanFactory.registerBeanDefinition("undertowServletWebServerFactory", ServletWebServerFactoryConfiguration__BeanDefinitions.EmbeddedUndertow.getUndertowServletWebServerFactoryBeanDefinition());
    beanFactory.registerBeanDefinition("undertowServletWebServerFactoryCustomizer", ServletWebServerFactoryConfiguration__BeanDefinitions.EmbeddedUndertow.getUndertowServletWebServerFactoryCustomizerBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration", ServletWebServerFactoryAutoConfiguration__BeanDefinitions.getServletWebServerFactoryAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("servletWebServerFactoryCustomizer", ServletWebServerFactoryAutoConfiguration__BeanDefinitions.getServletWebServerFactoryCustomizerBeanDefinition());
    beanFactory.registerBeanDefinition("server-org.springframework.boot.autoconfigure.web.ServerProperties", ServerProperties__BeanDefinitions.getServerPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("webServerFactoryCustomizerBeanPostProcessor", WebServerFactoryCustomizerBeanPostProcessor__BeanDefinitions.getWebServerFactoryCustomizerBeanPostProcessorBeanDefinition());
    beanFactory.registerBeanDefinition("errorPageRegistrarBeanPostProcessor", ErrorPageRegistrarBeanPostProcessor__BeanDefinitions.getErrorPageRegistrarBeanPostProcessorBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration$DispatcherServletConfiguration", DispatcherServletAutoConfiguration__BeanDefinitions.DispatcherServletConfiguration.getDispatcherServletConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("dispatcherServlet", DispatcherServletAutoConfiguration__BeanDefinitions.DispatcherServletConfiguration.getDispatcherServletBeanDefinition());
    beanFactory.registerBeanDefinition("spring.mvc-org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties", WebMvcProperties__BeanDefinitions.getWebMvcPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration$DispatcherServletRegistrationConfiguration", DispatcherServletAutoConfiguration__BeanDefinitions.DispatcherServletRegistrationConfiguration.getDispatcherServletRegistrationConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("dispatcherServletRegistration", DispatcherServletAutoConfiguration__BeanDefinitions.DispatcherServletRegistrationConfiguration.getDispatcherServletRegistrationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration", DispatcherServletAutoConfiguration__BeanDefinitions.getDispatcherServletAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$Jackson2ObjectMapperBuilderCustomizerConfiguration", JacksonAutoConfiguration__BeanDefinitions.Jackson2ObjectMapperBuilderCustomizerConfiguration.getJacksonObjectMapperBuilderCustomizerConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("standardJacksonObjectMapperBuilderCustomizer", JacksonAutoConfiguration__BeanDefinitions.Jackson2ObjectMapperBuilderCustomizerConfiguration.getStandardJacksonObjectMapperBuilderCustomizerBeanDefinition());
    beanFactory.registerBeanDefinition("spring.jackson-org.springframework.boot.autoconfigure.jackson.JacksonProperties", JacksonProperties__BeanDefinitions.getJacksonPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonObjectMapperBuilderConfiguration", JacksonAutoConfiguration__BeanDefinitions.JacksonObjectMapperBuilderConfiguration.getJacksonObjectMapperBuilderConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("jacksonObjectMapperBuilder", JacksonAutoConfiguration__BeanDefinitions.JacksonObjectMapperBuilderConfiguration.getJacksonObjectMapperBuilderBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$ParameterNamesModuleConfiguration", JacksonAutoConfiguration__BeanDefinitions.ParameterNamesModuleConfiguration.getParameterNamesModuleConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("parameterNamesModule", JacksonAutoConfiguration__BeanDefinitions.ParameterNamesModuleConfiguration.getParameterNamesModuleBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonObjectMapperConfiguration", JacksonAutoConfiguration__BeanDefinitions.JacksonObjectMapperConfiguration.getJacksonObjectMapperConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("jacksonObjectMapper", JacksonAutoConfiguration__BeanDefinitions.JacksonObjectMapperConfiguration.getJacksonObjectMapperBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonMixinConfiguration", JacksonAutoConfiguration__BeanDefinitions.JacksonMixinConfiguration.getJacksonMixinConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("jsonMixinModuleEntries", JsonMixinModuleEntries__BeanDefinitions.getJsonMixinModuleEntriesBeanDefinition());
    beanFactory.registerBeanDefinition("jsonMixinModule", JacksonAutoConfiguration__BeanDefinitions.JacksonMixinConfiguration.getJsonMixinModuleBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration", JacksonAutoConfiguration__BeanDefinitions.getJacksonAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("jsonComponentModule", JacksonAutoConfiguration__BeanDefinitions.getJsonComponentModuleBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.http.codec.CodecsAutoConfiguration$DefaultCodecsConfiguration", CodecsAutoConfiguration__BeanDefinitions.DefaultCodecsConfiguration.getDefaultCodecsConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("defaultCodecCustomizer", CodecsAutoConfiguration__BeanDefinitions.DefaultCodecsConfiguration.getDefaultCodecCustomizerBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.http.codec.CodecsAutoConfiguration$JacksonCodecConfiguration", CodecsAutoConfiguration__BeanDefinitions.JacksonCodecConfiguration.getJacksonCodecConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("jacksonCodecCustomizer", CodecsAutoConfiguration__BeanDefinitions.JacksonCodecConfiguration.getJacksonCodecCustomizerBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.http.codec.CodecsAutoConfiguration", CodecsAutoConfiguration__BeanDefinitions.getCodecsAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("spring.codec-org.springframework.boot.autoconfigure.codec.CodecProperties", CodecProperties__BeanDefinitions.getCodecPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations$ThreadPoolTaskExecutorBuilderConfiguration", TaskExecutorConfigurations__BeanDefinitions.ThreadPoolTaskExecutorBuilderConfiguration.getThreadPoolTaskExecutorBuilderConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("threadPoolTaskExecutorBuilder", TaskExecutorConfigurations__BeanDefinitions.ThreadPoolTaskExecutorBuilderConfiguration.getThreadPoolTaskExecutorBuilderBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations$TaskExecutorBuilderConfiguration", TaskExecutorConfigurations__BeanDefinitions.TaskExecutorBuilderConfiguration.getTaskExecutorBuilderConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("taskExecutorBuilder", TaskExecutorConfigurations__BeanDefinitions.TaskExecutorBuilderConfiguration.getTaskExecutorBuilderBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations$SimpleAsyncTaskExecutorBuilderConfiguration", TaskExecutorConfigurations__BeanDefinitions.SimpleAsyncTaskExecutorBuilderConfiguration.getSimpleAsyncTaskExecutorBuilderConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("simpleAsyncTaskExecutorBuilder", TaskExecutorConfigurations__BeanDefinitions.SimpleAsyncTaskExecutorBuilderConfiguration.getSimpleAsyncTaskExecutorBuilderBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration", TaskExecutionAutoConfiguration__BeanDefinitions.getTaskExecutionAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("spring.task.execution-org.springframework.boot.autoconfigure.task.TaskExecutionProperties", TaskExecutionProperties__BeanDefinitions.getTaskExecutionPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$WhitelabelErrorViewConfiguration", ErrorMvcAutoConfiguration__BeanDefinitions.WhitelabelErrorViewConfiguration.getWhitelabelErrorViewConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("error", ErrorMvcAutoConfiguration__BeanDefinitions.WhitelabelErrorViewConfiguration.getErrorBeanDefinition());
    beanFactory.registerBeanDefinition("beanNameViewResolver", ErrorMvcAutoConfiguration__BeanDefinitions.WhitelabelErrorViewConfiguration.getBeanNameViewResolverBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$DefaultErrorViewResolverConfiguration", ErrorMvcAutoConfiguration__BeanDefinitions.DefaultErrorViewResolverConfiguration.getDefaultErrorViewResolverConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("conventionErrorViewResolver", ErrorMvcAutoConfiguration__BeanDefinitions.DefaultErrorViewResolverConfiguration.getConventionErrorViewResolverBeanDefinition());
    beanFactory.registerBeanDefinition("spring.web-org.springframework.boot.autoconfigure.web.WebProperties", WebProperties__BeanDefinitions.getWebPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration", ErrorMvcAutoConfiguration__BeanDefinitions.getErrorMvcAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("errorAttributes", ErrorMvcAutoConfiguration__BeanDefinitions.getErrorAttributesBeanDefinition());
    beanFactory.registerBeanDefinition("basicErrorController", ErrorMvcAutoConfiguration__BeanDefinitions.getBasicErrorControllerBeanDefinition());
    beanFactory.registerBeanDefinition("errorPageCustomizer", ErrorMvcAutoConfiguration__BeanDefinitions.getErrorPageCustomizerBeanDefinition());
    beanFactory.registerBeanDefinition("preserveErrorControllerTargetClassPostProcessor", ErrorMvcAutoConfiguration__BeanDefinitions.getPreserveErrorControllerTargetClassPostProcessorBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration", WebMvcAutoConfiguration__BeanDefinitions.EnableWebMvcConfiguration.getEnableWebMvcConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("welcomePageHandlerMapping", WebMvcAutoConfiguration__BeanDefinitions.EnableWebMvcConfiguration.getWelcomePageHandlerMappingBeanDefinition());
    beanFactory.registerBeanDefinition("welcomePageNotAcceptableHandlerMapping", WebMvcAutoConfiguration__BeanDefinitions.EnableWebMvcConfiguration.getWelcomePageNotAcceptableHandlerMappingBeanDefinition());
    beanFactory.registerBeanDefinition("localeResolver", WebMvcAutoConfiguration__BeanDefinitions.EnableWebMvcConfiguration.getLocaleResolverBeanDefinition());
    beanFactory.registerBeanDefinition("themeResolver", WebMvcAutoConfiguration__BeanDefinitions.EnableWebMvcConfiguration.getThemeResolverBeanDefinition());
    beanFactory.registerBeanDefinition("flashMapManager", WebMvcAutoConfiguration__BeanDefinitions.EnableWebMvcConfiguration.getFlashMapManagerBeanDefinition());
    beanFactory.registerBeanDefinition("mvcConversionService", WebMvcAutoConfiguration__BeanDefinitions.EnableWebMvcConfiguration.getMvcConversionServiceBeanDefinition());
    beanFactory.registerBeanDefinition("mvcValidator", WebMvcAutoConfiguration__BeanDefinitions.EnableWebMvcConfiguration.getMvcValidatorBeanDefinition());
    beanFactory.registerBeanDefinition("mvcContentNegotiationManager", WebMvcAutoConfiguration__BeanDefinitions.EnableWebMvcConfiguration.getMvcContentNegotiationManagerBeanDefinition());
    beanFactory.registerBeanDefinition("requestMappingHandlerMapping", WebMvcConfigurationSupport__BeanDefinitions.getRequestMappingHandlerMappingBeanDefinition());
    beanFactory.registerBeanDefinition("mvcPatternParser", WebMvcConfigurationSupport__BeanDefinitions.getMvcPatternParserBeanDefinition());
    beanFactory.registerBeanDefinition("mvcUrlPathHelper", WebMvcConfigurationSupport__BeanDefinitions.getMvcUrlPathHelperBeanDefinition());
    beanFactory.registerBeanDefinition("mvcPathMatcher", WebMvcConfigurationSupport__BeanDefinitions.getMvcPathMatcherBeanDefinition());
    beanFactory.registerBeanDefinition("viewControllerHandlerMapping", WebMvcConfigurationSupport__BeanDefinitions.getViewControllerHandlerMappingBeanDefinition());
    beanFactory.registerBeanDefinition("beanNameHandlerMapping", WebMvcConfigurationSupport__BeanDefinitions.getBeanNameHandlerMappingBeanDefinition());
    beanFactory.registerBeanDefinition("routerFunctionMapping", WebMvcConfigurationSupport__BeanDefinitions.getRouterFunctionMappingBeanDefinition());
    beanFactory.registerBeanDefinition("resourceHandlerMapping", WebMvcConfigurationSupport__BeanDefinitions.getResourceHandlerMappingBeanDefinition());
    beanFactory.registerBeanDefinition("mvcResourceUrlProvider", WebMvcConfigurationSupport__BeanDefinitions.getMvcResourceUrlProviderBeanDefinition());
    beanFactory.registerBeanDefinition("defaultServletHandlerMapping", WebMvcConfigurationSupport__BeanDefinitions.getDefaultServletHandlerMappingBeanDefinition());
    beanFactory.registerBeanDefinition("requestMappingHandlerAdapter", WebMvcConfigurationSupport__BeanDefinitions.getRequestMappingHandlerAdapterBeanDefinition());
    beanFactory.registerBeanDefinition("handlerFunctionAdapter", WebMvcConfigurationSupport__BeanDefinitions.getHandlerFunctionAdapterBeanDefinition());
    beanFactory.registerBeanDefinition("mvcUriComponentsContributor", WebMvcConfigurationSupport__BeanDefinitions.getMvcUriComponentsContributorBeanDefinition());
    beanFactory.registerBeanDefinition("httpRequestHandlerAdapter", WebMvcConfigurationSupport__BeanDefinitions.getHttpRequestHandlerAdapterBeanDefinition());
    beanFactory.registerBeanDefinition("simpleControllerHandlerAdapter", WebMvcConfigurationSupport__BeanDefinitions.getSimpleControllerHandlerAdapterBeanDefinition());
    beanFactory.registerBeanDefinition("handlerExceptionResolver", WebMvcConfigurationSupport__BeanDefinitions.getHandlerExceptionResolverBeanDefinition());
    beanFactory.registerBeanDefinition("mvcViewResolver", WebMvcConfigurationSupport__BeanDefinitions.getMvcViewResolverBeanDefinition());
    beanFactory.registerBeanDefinition("mvcHandlerMappingIntrospector", WebMvcConfigurationSupport__BeanDefinitions.getMvcHandlerMappingIntrospectorBeanDefinition());
    beanFactory.registerBeanDefinition("viewNameTranslator", WebMvcConfigurationSupport__BeanDefinitions.getViewNameTranslatorBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter", WebMvcAutoConfiguration__BeanDefinitions.WebMvcAutoConfigurationAdapter.getWebMvcAutoConfigurationAdapterBeanDefinition());
    beanFactory.registerBeanDefinition("defaultViewResolver", WebMvcAutoConfiguration__BeanDefinitions.WebMvcAutoConfigurationAdapter.getDefaultViewResolverBeanDefinition());
    beanFactory.registerBeanDefinition("viewResolver", WebMvcAutoConfiguration__BeanDefinitions.WebMvcAutoConfigurationAdapter.getViewResolverBeanDefinition());
    beanFactory.registerBeanDefinition("requestContextFilter", WebMvcAutoConfiguration__BeanDefinitions.WebMvcAutoConfigurationAdapter.getRequestContextFilterBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration", WebMvcAutoConfiguration__BeanDefinitions.getWebMvcAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("formContentFilter", WebMvcAutoConfiguration__BeanDefinitions.getFormContentFilterBeanDefinition());
    beanFactory.registerBeanDefinition("cn.hutool.extra.spring.SpringUtil", SpringUtil__BeanDefinitions.getSpringUtilBeanDefinition());
    beanFactory.registerBeanDefinition("com.alibaba.cloud.nacos.NacosServiceAutoConfiguration", NacosServiceAutoConfiguration__BeanDefinitions.getNacosServiceAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("nacosServiceManager", NacosServiceAutoConfiguration__BeanDefinitions.getNacosServiceManagerBeanDefinition());
    beanFactory.registerBeanDefinition("com.alibaba.cloud.nacos.discovery.NacosDiscoveryAutoConfiguration", NacosDiscoveryAutoConfiguration__BeanDefinitions.getNacosDiscoveryAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("nacosProperties", NacosDiscoveryAutoConfiguration__BeanDefinitions.getNacosPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("nacosServiceDiscovery", NacosDiscoveryAutoConfiguration__BeanDefinitions.getNacosServiceDiscoveryBeanDefinition());
    beanFactory.registerBeanDefinition("com.alibaba.cloud.nacos.discovery.NacosDiscoveryClientConfiguration", NacosDiscoveryClientConfiguration__BeanDefinitions.getNacosDiscoveryClientConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("nacosDiscoveryClient", NacosDiscoveryClientConfiguration__BeanDefinitions.getNacosDiscoveryClientBeanDefinition());
    beanFactory.registerBeanDefinition("com.alibaba.cloud.nacos.discovery.NacosDiscoveryHeartBeatConfiguration", NacosDiscoveryHeartBeatConfiguration__BeanDefinitions.getNacosDiscoveryHeartBeatConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.cloud.client.discovery.composite.reactive.ReactiveCompositeDiscoveryClientAutoConfiguration", ReactiveCompositeDiscoveryClientAutoConfiguration__BeanDefinitions.getReactiveCompositeDiscoveryClientAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("reactiveCompositeDiscoveryClient", ReactiveCompositeDiscoveryClientAutoConfiguration__BeanDefinitions.getReactiveCompositeDiscoveryClientBeanDefinition());
    beanFactory.registerBeanDefinition("com.alibaba.cloud.nacos.discovery.reactive.NacosReactiveDiscoveryClientConfiguration", NacosReactiveDiscoveryClientConfiguration__BeanDefinitions.getNacosReactiveDiscoveryClientConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("nacosReactiveDiscoveryClient", NacosReactiveDiscoveryClientConfiguration__BeanDefinitions.getNacosReactiveDiscoveryClientBeanDefinition());
    beanFactory.registerBeanDefinition("com.alibaba.cloud.nacos.endpoint.NacosDiscoveryEndpointAutoConfiguration", NacosDiscoveryEndpointAutoConfiguration__BeanDefinitions.getNacosDiscoveryEndpointAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("nacosDiscoveryEndpoint", NacosDiscoveryEndpointAutoConfiguration__BeanDefinitions.getNacosDiscoveryEndpointBeanDefinition());
    beanFactory.registerBeanDefinition("nacosDiscoveryHealthIndicator", NacosDiscoveryEndpointAutoConfiguration__BeanDefinitions.getNacosDiscoveryHealthIndicatorBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationAutoConfiguration", AutoServiceRegistrationAutoConfiguration__BeanDefinitions.getAutoServiceRegistrationAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("com.alibaba.cloud.nacos.registry.NacosServiceRegistryAutoConfiguration", NacosServiceRegistryAutoConfiguration__BeanDefinitions.getNacosServiceRegistryAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("nacosServiceRegistry", NacosServiceRegistryAutoConfiguration__BeanDefinitions.getNacosServiceRegistryBeanDefinition());
    beanFactory.registerBeanDefinition("nacosRegistration", NacosServiceRegistryAutoConfiguration__BeanDefinitions.getNacosRegistrationBeanDefinition());
    beanFactory.registerBeanDefinition("nacosAutoServiceRegistration", NacosServiceRegistryAutoConfiguration__BeanDefinitions.getNacosAutoServiceRegistrationBeanDefinition());
    beanFactory.registerBeanDefinition("com.alibaba.cloud.nacos.util.UtilIPv6AutoConfiguration", UtilIPv6AutoConfiguration__BeanDefinitions.getUtilIPvAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("inetIPv6Utils", UtilIPv6AutoConfiguration__BeanDefinitions.getInetIPvUtilsBeanDefinition());
    beanFactory.registerBeanDefinition("com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceCreatorAutoConfiguration$HikariDataSourceCreatorConfiguration", DynamicDataSourceCreatorAutoConfiguration__BeanDefinitions.HikariDataSourceCreatorConfiguration.getHikariDataSourceCreatorConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("hikariDataSourceCreator", DynamicDataSourceCreatorAutoConfiguration__BeanDefinitions.HikariDataSourceCreatorConfiguration.getHikariDataSourceCreatorBeanDefinition());
    beanFactory.registerBeanDefinition("com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceCreatorAutoConfiguration$DruidDataSourceCreatorConfiguration", DynamicDataSourceCreatorAutoConfiguration__BeanDefinitions.DruidDataSourceCreatorConfiguration.getDruidDataSourceCreatorConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("druidDataSourceCreator", DynamicDataSourceCreatorAutoConfiguration__BeanDefinitions.DruidDataSourceCreatorConfiguration.getDruidDataSourceCreatorBeanDefinition());
    beanFactory.registerBeanDefinition("com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceCreatorAutoConfiguration", DynamicDataSourceCreatorAutoConfiguration__BeanDefinitions.getDynamicDataSourceCreatorAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("basicDataSourceCreator", DynamicDataSourceCreatorAutoConfiguration__BeanDefinitions.getBasicDataSourceCreatorBeanDefinition());
    beanFactory.registerBeanDefinition("jndiDataSourceCreator", DynamicDataSourceCreatorAutoConfiguration__BeanDefinitions.getJndiDataSourceCreatorBeanDefinition());
    beanFactory.registerBeanDefinition("com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceAopConfiguration", DynamicDataSourceAopConfiguration__BeanDefinitions.getDynamicDataSourceAopConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("dynamicDataSourceProperties", DynamicDataSourceAopConfiguration__BeanDefinitions.getDynamicDataSourcePropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("dsProcessor", DynamicDataSourceAopConfiguration__BeanDefinitions.getDsProcessorBeanDefinition());
    beanFactory.registerBeanDefinition("dynamicDatasourceAnnotationAdvisor", DynamicDataSourceAopConfiguration__BeanDefinitions.getDynamicDatasourceAnnotationAdvisorBeanDefinition());
    beanFactory.registerBeanDefinition("dynamicTransactionAdvisor", DynamicDataSourceAopConfiguration__BeanDefinitions.getDynamicTransactionAdvisorBeanDefinition());
    beanFactory.registerBeanDefinition("com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceAssistConfiguration$DsTxEventListenerFactoryConfiguration", DynamicDataSourceAssistConfiguration__BeanDefinitions.DsTxEventListenerFactoryConfiguration.getDsTxEventListenerFactoryConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("dsTxEventListenerFactory", DynamicDataSourceAssistConfiguration__BeanDefinitions.DsTxEventListenerFactoryConfiguration.getDsTxEventListenerFactoryBeanDefinition());
    beanFactory.registerBeanDefinition("com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceAssistConfiguration", DynamicDataSourceAssistConfiguration__BeanDefinitions.getDynamicDataSourceAssistConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("ymlDynamicDataSourceProvider", DynamicDataSourceAssistConfiguration__BeanDefinitions.getYmlDynamicDataSourceProviderBeanDefinition());
    beanFactory.registerBeanDefinition("dataSourceInitEvent", DynamicDataSourceAssistConfiguration__BeanDefinitions.getDataSourceInitEventBeanDefinition());
    beanFactory.registerBeanDefinition("dataSourceCreator", DynamicDataSourceAssistConfiguration__BeanDefinitions.getDataSourceCreatorBeanDefinition());
    beanFactory.registerBeanDefinition("com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceAutoConfiguration", DynamicDataSourceAutoConfiguration__BeanDefinitions.getDynamicDataSourceAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("dataSource", DynamicDataSourceAutoConfiguration__BeanDefinitions.getDataSourceBeanDefinition());
    beanFactory.registerBeanDefinition("com.baomidou.mybatisplus.autoconfigure.MybatisPlusLanguageDriverAutoConfiguration", MybatisPlusLanguageDriverAutoConfiguration__BeanDefinitions.getMybatisPlusLanguageDriverAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.jdbc.metadata.DataSourcePoolMetadataProvidersConfiguration$HikariPoolDataSourceMetadataProviderConfiguration", DataSourcePoolMetadataProvidersConfiguration__BeanDefinitions.HikariPoolDataSourceMetadataProviderConfiguration.getHikariPoolDataSourceMetadataProviderConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("hikariPoolDataSourceMetadataProvider", DataSourcePoolMetadataProvidersConfiguration__BeanDefinitions.HikariPoolDataSourceMetadataProviderConfiguration.getHikariPoolDataSourceMetadataProviderBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.jdbc.metadata.DataSourcePoolMetadataProvidersConfiguration", DataSourcePoolMetadataProvidersConfiguration__BeanDefinitions.getDataSourcePoolMetadataProvidersConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration", DataSourceAutoConfiguration__BeanDefinitions.getDataSourceAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("spring.datasource-org.springframework.boot.autoconfigure.jdbc.DataSourceProperties", DataSourceProperties__BeanDefinitions.getDataSourcePropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration", MybatisPlusAutoConfiguration__BeanDefinitions.getMybatisPlusAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("sqlSessionFactory", MybatisPlusAutoConfiguration__BeanDefinitions.getSqlSessionFactoryBeanDefinition());
    beanFactory.registerBeanDefinition("sqlSessionTemplate", MybatisPlusAutoConfiguration__BeanDefinitions.getSqlSessionTemplateBeanDefinition());
    beanFactory.registerBeanDefinition("ddlApplicationRunner", MybatisPlusAutoConfiguration__BeanDefinitions.getDdlApplicationRunnerBeanDefinition());
    beanFactory.registerBeanDefinition("mybatis-plus-com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties", MybatisPlusProperties__BeanDefinitions.getMybatisPlusPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.mybatis.spring.boot.autoconfigure.MybatisLanguageDriverAutoConfiguration", MybatisLanguageDriverAutoConfiguration__BeanDefinitions.getMybatisLanguageDriverAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration", MybatisAutoConfiguration__BeanDefinitions.getMybatisAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("mybatis-org.mybatis.spring.boot.autoconfigure.MybatisProperties", MybatisProperties__BeanDefinitions.getMybatisPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration", PageHelperAutoConfiguration__BeanDefinitions.getPageHelperAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("pagehelper-com.github.pagehelper.autoconfigure.PageHelperProperties", PageHelperProperties__BeanDefinitions.getPageHelperPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("pagehelper-com.github.pagehelper.autoconfigure.PageHelperStandardProperties", PageHelperStandardProperties__BeanDefinitions.getPageHelperStandardPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizationAutoConfiguration", TransactionManagerCustomizationAutoConfiguration__BeanDefinitions.getTransactionManagerCustomizationAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("platformTransactionManagerCustomizers", TransactionManagerCustomizationAutoConfiguration__BeanDefinitions.getPlatformTransactionManagerCustomizersBeanDefinition());
    beanFactory.registerBeanDefinition("transactionExecutionListeners", TransactionManagerCustomizationAutoConfiguration__BeanDefinitions.getTransactionExecutionListenersBeanDefinition());
    beanFactory.registerBeanDefinition("spring.transaction-org.springframework.boot.autoconfigure.transaction.TransactionProperties", TransactionProperties__BeanDefinitions.getTransactionPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.cloud.autoconfigure.RefreshAutoConfiguration$RefreshScopeBeanDefinitionEnhancer", RefreshAutoConfiguration__BeanDefinitions.RefreshScopeBeanDefinitionEnhancer.getRefreshScopeBeanDefinitionEnhancerBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.cloud.autoconfigure.RefreshAutoConfiguration", RefreshAutoConfiguration__BeanDefinitions.getRefreshAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("refreshScope", RefreshAutoConfiguration__BeanDefinitions.getRefreshScopeBeanDefinition());
    beanFactory.registerBeanDefinition("loggingRebinder", RefreshAutoConfiguration__BeanDefinitions.getLoggingRebinderBeanDefinition());
    beanFactory.registerBeanDefinition("configDataContextRefresher", RefreshAutoConfiguration__BeanDefinitions.getConfigDataContextRefresherBeanDefinition());
    beanFactory.registerBeanDefinition("refreshScopeLifecycle", RefreshAutoConfiguration__BeanDefinitions.getRefreshScopeLifecycleBeanDefinition());
    beanFactory.registerBeanDefinition("refreshEventListener", RefreshAutoConfiguration__BeanDefinitions.getRefreshEventListenerBeanDefinition());
    beanFactory.registerBeanDefinition("spring.cloud.refresh-org.springframework.cloud.autoconfigure.RefreshAutoConfiguration$RefreshProperties", RefreshAutoConfiguration__BeanDefinitions.RefreshProperties.getRefreshPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.flowable.spring.boot.app.AppEngineAutoConfiguration", AppEngineAutoConfiguration__BeanDefinitions.getAppEngineAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("springAppEngineConfiguration", AppEngineAutoConfiguration__BeanDefinitions.getSpringAppEngineConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("flowable-org.flowable.spring.boot.FlowableProperties", FlowableProperties__BeanDefinitions.getFlowablePropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("flowable.auto-deployment-org.flowable.spring.boot.FlowableAutoDeploymentProperties", FlowableAutoDeploymentProperties__BeanDefinitions.getFlowableAutoDeploymentPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("flowable.idm-org.flowable.spring.boot.idm.FlowableIdmProperties", FlowableIdmProperties__BeanDefinitions.getFlowableIdmPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("flowable.app-org.flowable.spring.boot.app.FlowableAppProperties", FlowableAppProperties__BeanDefinitions.getFlowableAppPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("flowable.eventregistry-org.flowable.spring.boot.eventregistry.FlowableEventRegistryProperties", FlowableEventRegistryProperties__BeanDefinitions.getFlowableEventRegistryPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.flowable.spring.boot.ProcessEngineAutoConfiguration$ProcessEngineAppConfiguration", ProcessEngineAutoConfiguration__BeanDefinitions.ProcessEngineAppConfiguration.getProcessEngineAppConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("processAppEngineConfigurationConfigurer", ProcessEngineAutoConfiguration__BeanDefinitions.ProcessEngineAppConfiguration.getProcessAppEngineConfigurationConfigurerBeanDefinition());
    beanFactory.registerBeanDefinition("processEngineConfigurator", ProcessEngineAutoConfiguration__BeanDefinitions.ProcessEngineAppConfiguration.getProcessEngineConfiguratorBeanDefinition());
    beanFactory.registerBeanDefinition("org.flowable.spring.boot.FlowableJobConfiguration", FlowableJobConfiguration__BeanDefinitions.getFlowableJobConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("taskExecutor", FlowableJobConfiguration__BeanDefinitions.getTaskExecutorBeanDefinition());
    beanFactory.registerBeanDefinition("flowableAsyncTaskInvokerTaskExecutorConfiguration", FlowableJobConfiguration__BeanDefinitions.getFlowableAsyncTaskInvokerTaskExecutorConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("flowableAsyncTaskInvokerTaskExecutor", FlowableJobConfiguration__BeanDefinitions.getFlowableAsyncTaskInvokerTaskExecutorBeanDefinition());
    beanFactory.registerBeanDefinition("org.flowable.spring.boot.ProcessEngineAutoConfiguration", ProcessEngineAutoConfiguration__BeanDefinitions.getProcessEngineAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("processAsyncExecutorConfiguration", ProcessEngineAutoConfiguration__BeanDefinitions.getProcessAsyncExecutorConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("processAsyncExecutor", ProcessEngineAutoConfiguration__BeanDefinitions.getProcessAsyncExecutorBeanDefinition());
    beanFactory.registerBeanDefinition("springProcessEngineConfiguration", ProcessEngineAutoConfiguration__BeanDefinitions.getSpringProcessEngineConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("flowable.mail.server-org.flowable.spring.boot.FlowableMailProperties", FlowableMailProperties__BeanDefinitions.getFlowableMailPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("flowable.process-org.flowable.spring.boot.process.FlowableProcessProperties", FlowableProcessProperties__BeanDefinitions.getFlowableProcessPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("flowable.http-org.flowable.spring.boot.FlowableHttpProperties", FlowableHttpProperties__BeanDefinitions.getFlowableHttpPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.flowable.spring.boot.cmmn.CmmnEngineAutoConfiguration$CmmnEngineAppConfiguration", CmmnEngineAutoConfiguration__BeanDefinitions.CmmnEngineAppConfiguration.getCmmnEngineAppConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("cmmnAppEngineConfigurationConfigurer", CmmnEngineAutoConfiguration__BeanDefinitions.CmmnEngineAppConfiguration.getCmmnAppEngineConfigurationConfigurerBeanDefinition());
    beanFactory.registerBeanDefinition("cmmnEngineConfigurator", CmmnEngineAutoConfiguration__BeanDefinitions.CmmnEngineAppConfiguration.getCmmnEngineConfiguratorBeanDefinition());
    beanFactory.registerBeanDefinition("org.flowable.spring.boot.cmmn.CmmnEngineAutoConfiguration", CmmnEngineAutoConfiguration__BeanDefinitions.getCmmnEngineAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("cmmnAsyncExecutorConfiguration", CmmnEngineAutoConfiguration__BeanDefinitions.getCmmnAsyncExecutorConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("cmmnAsyncExecutor", CmmnEngineAutoConfiguration__BeanDefinitions.getCmmnAsyncExecutorBeanDefinition());
    beanFactory.registerBeanDefinition("cmmnEngineConfiguration", CmmnEngineAutoConfiguration__BeanDefinitions.getCmmnEngineConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("flowable.cmmn-org.flowable.spring.boot.cmmn.FlowableCmmnProperties", FlowableCmmnProperties__BeanDefinitions.getFlowableCmmnPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.flowable.spring.boot.dmn.DmnEngineAutoConfiguration$DmnEngineAppConfiguration", DmnEngineAutoConfiguration__BeanDefinitions.DmnEngineAppConfiguration.getDmnEngineAppConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("dmnAppEngineConfigurationConfigurer", DmnEngineAutoConfiguration__BeanDefinitions.DmnEngineAppConfiguration.getDmnAppEngineConfigurationConfigurerBeanDefinition());
    beanFactory.registerBeanDefinition("dmnEngineConfigurator", DmnEngineAutoConfiguration__BeanDefinitions.DmnEngineAppConfiguration.getDmnEngineConfiguratorBeanDefinition());
    beanFactory.registerBeanDefinition("org.flowable.spring.boot.dmn.DmnEngineAutoConfiguration", DmnEngineAutoConfiguration__BeanDefinitions.getDmnEngineAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("dmnEngineConfiguration", DmnEngineAutoConfiguration__BeanDefinitions.getDmnEngineConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("flowable.dmn-org.flowable.spring.boot.dmn.FlowableDmnProperties", FlowableDmnProperties__BeanDefinitions.getFlowableDmnPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.flowable.spring.boot.eventregistry.EventRegistryAutoConfiguration$EventRegistryAppEngineConfiguration", EventRegistryAutoConfiguration__BeanDefinitions.EventRegistryAppEngineConfiguration.getEventRegistryAppEngineConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("eventAppEngineConfigurationConfigurer", EventRegistryAutoConfiguration__BeanDefinitions.EventRegistryAppEngineConfiguration.getEventAppEngineConfigurationConfigurerBeanDefinition());
    beanFactory.registerBeanDefinition("eventEngineConfigurator", EventRegistryAutoConfiguration__BeanDefinitions.EventRegistryAppEngineConfiguration.getEventEngineConfiguratorBeanDefinition());
    beanFactory.registerBeanDefinition("org.flowable.spring.boot.eventregistry.EventRegistryAutoConfiguration", EventRegistryAutoConfiguration__BeanDefinitions.getEventRegistryAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("eventEngineConfiguration", EventRegistryAutoConfiguration__BeanDefinitions.getEventEngineConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.flowable.spring.boot.idm.IdmEngineAutoConfiguration$IdmEngineAppConfiguration", IdmEngineAutoConfiguration__BeanDefinitions.IdmEngineAppConfiguration.getIdmEngineAppConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("idmAppEngineConfigurationConfigurer", IdmEngineAutoConfiguration__BeanDefinitions.IdmEngineAppConfiguration.getIdmAppEngineConfigurationConfigurerBeanDefinition());
    beanFactory.registerBeanDefinition("idmEngineConfigurator", IdmEngineAutoConfiguration__BeanDefinitions.IdmEngineAppConfiguration.getIdmEngineConfiguratorBeanDefinition());
    beanFactory.registerBeanDefinition("org.flowable.spring.boot.idm.IdmEngineAutoConfiguration$PasswordEncoderConfiguration", IdmEngineAutoConfiguration__BeanDefinitions.PasswordEncoderConfiguration.getPasswordEncoderConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("passwordEncoderIdmEngineConfigurationConfigurer", IdmEngineAutoConfiguration__BeanDefinitions.PasswordEncoderConfiguration.getPasswordEncoderIdmEngineConfigurationConfigurerBeanDefinition());
    beanFactory.registerBeanDefinition("org.flowable.spring.boot.idm.IdmEngineAutoConfiguration", IdmEngineAutoConfiguration__BeanDefinitions.getIdmEngineAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("idmEngineConfiguration", IdmEngineAutoConfiguration__BeanDefinitions.getIdmEngineConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.flowable.spring.boot.app.AppEngineServicesAutoConfiguration", AppEngineServicesAutoConfiguration__BeanDefinitions.getAppEngineServicesAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("flowableAppEngine", AppEngineServicesAutoConfiguration__BeanDefinitions.getFlowableAppEngineBeanDefinition());
    beanFactory.registerBeanDefinition("appRepositoryServiceBean", AppEngineServicesAutoConfiguration__BeanDefinitions.getAppRepositoryServiceBeanBeanDefinition());
    beanFactory.registerBeanDefinition("appManagementServiceBean", AppEngineServicesAutoConfiguration__BeanDefinitions.getAppManagementServiceBeanBeanDefinition());
    beanFactory.registerBeanDefinition("org.flowable.spring.boot.ProcessEngineServicesAutoConfiguration$AlreadyInitializedAppEngineConfiguration", ProcessEngineServicesAutoConfiguration__BeanDefinitions.AlreadyInitializedAppEngineConfiguration.getAlreadyInitializedAppEngineConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("processEngine", ProcessEngineServicesAutoConfiguration__BeanDefinitions.AlreadyInitializedAppEngineConfiguration.getProcessEngineBeanDefinition());
    beanFactory.registerBeanDefinition("org.flowable.spring.boot.ProcessEngineServicesAutoConfiguration", ProcessEngineServicesAutoConfiguration__BeanDefinitions.getProcessEngineServicesAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("runtimeServiceBean", ProcessEngineServicesAutoConfiguration__BeanDefinitions.getRuntimeServiceBeanBeanDefinition());
    beanFactory.registerBeanDefinition("repositoryServiceBean", ProcessEngineServicesAutoConfiguration__BeanDefinitions.getRepositoryServiceBeanBeanDefinition());
    beanFactory.registerBeanDefinition("taskServiceBean", ProcessEngineServicesAutoConfiguration__BeanDefinitions.getTaskServiceBeanBeanDefinition());
    beanFactory.registerBeanDefinition("historyServiceBean", ProcessEngineServicesAutoConfiguration__BeanDefinitions.getHistoryServiceBeanBeanDefinition());
    beanFactory.registerBeanDefinition("managementServiceBean", ProcessEngineServicesAutoConfiguration__BeanDefinitions.getManagementServiceBeanBeanDefinition());
    beanFactory.registerBeanDefinition("dynamicBpmnServiceBean", ProcessEngineServicesAutoConfiguration__BeanDefinitions.getDynamicBpmnServiceBeanBeanDefinition());
    beanFactory.registerBeanDefinition("processInstanceMigrationService", ProcessEngineServicesAutoConfiguration__BeanDefinitions.getProcessInstanceMigrationServiceBeanDefinition());
    beanFactory.registerBeanDefinition("formServiceBean", ProcessEngineServicesAutoConfiguration__BeanDefinitions.getFormServiceBeanBeanDefinition());
    beanFactory.registerBeanDefinition("identityServiceBean", ProcessEngineServicesAutoConfiguration__BeanDefinitions.getIdentityServiceBeanBeanDefinition());
    beanFactory.registerBeanDefinition("org.flowable.spring.boot.idm.IdmEngineServicesAutoConfiguration$AlreadyInitializedAppEngineConfiguration", IdmEngineServicesAutoConfiguration__BeanDefinitions.AlreadyInitializedAppEngineConfiguration.getAlreadyInitializedAppEngineConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("idmEngine", IdmEngineServicesAutoConfiguration__BeanDefinitions.AlreadyInitializedAppEngineConfiguration.getIdmEngineBeanDefinition());
    beanFactory.registerBeanDefinition("org.flowable.spring.boot.idm.IdmEngineServicesAutoConfiguration", IdmEngineServicesAutoConfiguration__BeanDefinitions.getIdmEngineServicesAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("idmManagementService", IdmEngineServicesAutoConfiguration__BeanDefinitions.getIdmManagementServiceBeanDefinition());
    beanFactory.registerBeanDefinition("idmIdentityService", IdmEngineServicesAutoConfiguration__BeanDefinitions.getIdmIdentityServiceBeanDefinition());
    beanFactory.registerBeanDefinition("org.flowable.spring.boot.FlowableSecurityAutoConfiguration$SpringSecurityAuthenticationContextConfiguration", FlowableSecurityAutoConfiguration__BeanDefinitions.SpringSecurityAuthenticationContextConfiguration.getSpringSecurityAuthenticationContextConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.flowable.spring.boot.FlowableSecurityAutoConfiguration", FlowableSecurityAutoConfiguration__BeanDefinitions.getFlowableSecurityAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.flowable.spring.boot.cmmn.CmmnEngineServicesAutoConfiguration$AlreadyInitializedAppEngineConfiguration", CmmnEngineServicesAutoConfiguration__BeanDefinitions.AlreadyInitializedAppEngineConfiguration.getAlreadyInitializedAppEngineConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("cmmnEngine", CmmnEngineServicesAutoConfiguration__BeanDefinitions.AlreadyInitializedAppEngineConfiguration.getCmmnEngineBeanDefinition());
    beanFactory.registerBeanDefinition("org.flowable.spring.boot.cmmn.CmmnEngineServicesAutoConfiguration", CmmnEngineServicesAutoConfiguration__BeanDefinitions.getCmmnEngineServicesAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("cmmnRuntimeService", CmmnEngineServicesAutoConfiguration__BeanDefinitions.getCmmnRuntimeServiceBeanDefinition());
    beanFactory.registerBeanDefinition("dynamicCmmnService", CmmnEngineServicesAutoConfiguration__BeanDefinitions.getDynamicCmmnServiceBeanDefinition());
    beanFactory.registerBeanDefinition("cmmnTaskService", CmmnEngineServicesAutoConfiguration__BeanDefinitions.getCmmnTaskServiceBeanDefinition());
    beanFactory.registerBeanDefinition("cmmnManagementService", CmmnEngineServicesAutoConfiguration__BeanDefinitions.getCmmnManagementServiceBeanDefinition());
    beanFactory.registerBeanDefinition("cmmnRepositoryService", CmmnEngineServicesAutoConfiguration__BeanDefinitions.getCmmnRepositoryServiceBeanDefinition());
    beanFactory.registerBeanDefinition("cmmnHistoryService", CmmnEngineServicesAutoConfiguration__BeanDefinitions.getCmmnHistoryServiceBeanDefinition());
    beanFactory.registerBeanDefinition("cmmnMigrationService", CmmnEngineServicesAutoConfiguration__BeanDefinitions.getCmmnMigrationServiceBeanDefinition());
    beanFactory.registerBeanDefinition("org.flowable.spring.boot.dmn.DmnEngineServicesAutoConfiguration$AlreadyInitializedAppEngineConfiguration", DmnEngineServicesAutoConfiguration__BeanDefinitions.AlreadyInitializedAppEngineConfiguration.getAlreadyInitializedAppEngineConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("dmnEngine", DmnEngineServicesAutoConfiguration__BeanDefinitions.AlreadyInitializedAppEngineConfiguration.getDmnEngineBeanDefinition());
    beanFactory.registerBeanDefinition("org.flowable.spring.boot.dmn.DmnEngineServicesAutoConfiguration", DmnEngineServicesAutoConfiguration__BeanDefinitions.getDmnEngineServicesAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("dmnManagementService", DmnEngineServicesAutoConfiguration__BeanDefinitions.getDmnManagementServiceBeanDefinition());
    beanFactory.registerBeanDefinition("dmnRepositoryService", DmnEngineServicesAutoConfiguration__BeanDefinitions.getDmnRepositoryServiceBeanDefinition());
    beanFactory.registerBeanDefinition("dmnRuleService", DmnEngineServicesAutoConfiguration__BeanDefinitions.getDmnRuleServiceBeanDefinition());
    beanFactory.registerBeanDefinition("dmnHistoryService", DmnEngineServicesAutoConfiguration__BeanDefinitions.getDmnHistoryServiceBeanDefinition());
    beanFactory.registerBeanDefinition("org.flowable.spring.boot.eventregistry.EventRegistryServicesAutoConfiguration$AlreadyInitializedAppEngineConfiguration", EventRegistryServicesAutoConfiguration__BeanDefinitions.AlreadyInitializedAppEngineConfiguration.getAlreadyInitializedAppEngineConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("eventRegistryEngine", EventRegistryServicesAutoConfiguration__BeanDefinitions.AlreadyInitializedAppEngineConfiguration.getEventRegistryEngineBeanDefinition());
    beanFactory.registerBeanDefinition("org.flowable.spring.boot.eventregistry.EventRegistryServicesAutoConfiguration", EventRegistryServicesAutoConfiguration__BeanDefinitions.getEventRegistryServicesAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("eventRepositoryService", EventRegistryServicesAutoConfiguration__BeanDefinitions.getEventRepositoryServiceBeanDefinition());
    beanFactory.registerBeanDefinition("eventManagementService", EventRegistryServicesAutoConfiguration__BeanDefinitions.getEventManagementServiceBeanDefinition());
    beanFactory.registerBeanDefinition("eventRegistry", EventRegistryServicesAutoConfiguration__BeanDefinitions.getEventRegistryBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration", MultipartAutoConfiguration__BeanDefinitions.getMultipartAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("multipartConfigElement", MultipartAutoConfiguration__BeanDefinitions.getMultipartConfigElementBeanDefinition());
    beanFactory.registerBeanDefinition("multipartResolver", MultipartAutoConfiguration__BeanDefinitions.getMultipartResolverBeanDefinition());
    beanFactory.registerBeanDefinition("spring.servlet.multipart-org.springframework.boot.autoconfigure.web.servlet.MultipartProperties", MultipartProperties__BeanDefinitions.getMultipartPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.flowable.spring.boot.actuate.info.FlowableInfoAutoConfiguration", FlowableInfoAutoConfiguration__BeanDefinitions.getFlowableInfoAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("flowableInfoContributor", FlowableInfoAutoConfiguration__BeanDefinitions.getFlowableInfoContributorBeanDefinition());
    beanFactory.registerBeanDefinition("org.flowable.spring.boot.EndpointAutoConfiguration", EndpointAutoConfiguration__BeanDefinitions.getEndpointAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("processEngineEndpoint", EndpointAutoConfiguration__BeanDefinitions.getProcessEngineEndpointBeanDefinition());
    beanFactory.registerBeanDefinition("org.redisson.spring.starter.RedissonAutoConfigurationV2", RedissonAutoConfigurationV2__BeanDefinitions.getRedissonAutoConfigurationVBeanDefinition());
    beanFactory.registerBeanDefinition("redisTemplate", RedissonAutoConfiguration__BeanDefinitions.getRedisTemplateBeanDefinition());
    beanFactory.registerBeanDefinition("stringRedisTemplate", RedissonAutoConfiguration__BeanDefinitions.getStringRedisTemplateBeanDefinition());
    beanFactory.registerBeanDefinition("redissonConnectionFactory", RedissonAutoConfiguration__BeanDefinitions.getRedissonConnectionFactoryBeanDefinition());
    beanFactory.registerBeanDefinition("redissonReactive", RedissonAutoConfiguration__BeanDefinitions.getRedissonReactiveBeanDefinition());
    beanFactory.registerBeanDefinition("redissonRxJava", RedissonAutoConfiguration__BeanDefinitions.getRedissonRxJavaBeanDefinition());
    beanFactory.registerBeanDefinition("redisson", RedissonAutoConfiguration__BeanDefinitions.getRedissonBeanDefinition());
    beanFactory.registerBeanDefinition("spring.data.redis-org.springframework.boot.autoconfigure.data.redis.RedisProperties", RedisProperties__BeanDefinitions.getRedisPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("spring.redis.redisson-org.redisson.spring.starter.RedissonProperties", RedissonProperties__BeanDefinitions.getRedissonPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.audit.AuditEventsEndpointAutoConfiguration", AuditEventsEndpointAutoConfiguration__BeanDefinitions.getAuditEventsEndpointAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.availability.ApplicationAvailabilityAutoConfiguration", ApplicationAvailabilityAutoConfiguration__BeanDefinitions.getApplicationAvailabilityAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("applicationAvailability", ApplicationAvailabilityAutoConfiguration__BeanDefinitions.getApplicationAvailabilityBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.availability.AvailabilityHealthContributorAutoConfiguration", AvailabilityHealthContributorAutoConfiguration__BeanDefinitions.getAvailabilityHealthContributorAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.beans.BeansEndpointAutoConfiguration", BeansEndpointAutoConfiguration__BeanDefinitions.getBeansEndpointAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("beansEndpoint", BeansEndpointAutoConfiguration__BeanDefinitions.getBeansEndpointBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration", RedisAutoConfiguration__BeanDefinitions.getRedisAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("redisConnectionDetails", RedisAutoConfiguration__BeanDefinitions.getRedisConnectionDetailsBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.cache.CachesEndpointAutoConfiguration", CachesEndpointAutoConfiguration__BeanDefinitions.getCachesEndpointAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("cachesEndpoint", CachesEndpointAutoConfiguration__BeanDefinitions.getCachesEndpointBeanDefinition());
    beanFactory.registerBeanDefinition("cachesEndpointWebExtension", CachesEndpointAutoConfiguration__BeanDefinitions.getCachesEndpointWebExtensionBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.health.HealthEndpointConfiguration", HealthEndpointConfiguration__BeanDefinitions.getHealthEndpointConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("healthStatusAggregator", HealthEndpointConfiguration__BeanDefinitions.getHealthStatusAggregatorBeanDefinition());
    beanFactory.registerBeanDefinition("healthHttpCodeStatusMapper", HealthEndpointConfiguration__BeanDefinitions.getHealthHttpCodeStatusMapperBeanDefinition());
    beanFactory.registerBeanDefinition("healthEndpointGroups", HealthEndpointConfiguration__BeanDefinitions.getHealthEndpointGroupsBeanDefinition());
    beanFactory.registerBeanDefinition("healthContributorRegistry", HealthEndpointConfiguration__BeanDefinitions.getHealthContributorRegistryBeanDefinition());
    beanFactory.registerBeanDefinition("healthEndpointGroupMembershipValidator", HealthEndpointConfiguration__BeanDefinitions.getHealthEndpointGroupMembershipValidatorBeanDefinition());
    beanFactory.registerBeanDefinition("healthEndpoint", HealthEndpointConfiguration__BeanDefinitions.getHealthEndpointBeanDefinition());
    beanFactory.registerBeanDefinition("healthEndpointGroupsBeanPostProcessor", HealthEndpointConfiguration__BeanDefinitions.getHealthEndpointGroupsBeanPostProcessorBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.health.ReactiveHealthEndpointConfiguration", ReactiveHealthEndpointConfiguration__BeanDefinitions.getReactiveHealthEndpointConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("reactiveHealthContributorRegistry", ReactiveHealthEndpointConfiguration__BeanDefinitions.getReactiveHealthContributorRegistryBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.health.HealthEndpointWebExtensionConfiguration$MvcAdditionalHealthEndpointPathsConfiguration", HealthEndpointWebExtensionConfiguration__BeanDefinitions.MvcAdditionalHealthEndpointPathsConfiguration.getMvcAdditionalHealthEndpointPathsConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("healthEndpointWebMvcHandlerMapping", HealthEndpointWebExtensionConfiguration__BeanDefinitions.MvcAdditionalHealthEndpointPathsConfiguration.getHealthEndpointWebMvcHandlerMappingBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.health.HealthEndpointWebExtensionConfiguration", HealthEndpointWebExtensionConfiguration__BeanDefinitions.getHealthEndpointWebExtensionConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("healthEndpointWebExtension", HealthEndpointWebExtensionConfiguration__BeanDefinitions.getHealthEndpointWebExtensionBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.health.HealthEndpointAutoConfiguration", HealthEndpointAutoConfiguration__BeanDefinitions.getHealthEndpointAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("management.endpoint.health-org.springframework.boot.actuate.autoconfigure.health.HealthEndpointProperties", HealthEndpointProperties__BeanDefinitions.getHealthEndpointPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration", ProjectInfoAutoConfiguration__BeanDefinitions.getProjectInfoAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("spring.info-org.springframework.boot.autoconfigure.info.ProjectInfoProperties", ProjectInfoProperties__BeanDefinitions.getProjectInfoPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.info.InfoContributorAutoConfiguration", InfoContributorAutoConfiguration__BeanDefinitions.getInfoContributorAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("management.info-org.springframework.boot.actuate.autoconfigure.info.InfoContributorProperties", InfoContributorProperties__BeanDefinitions.getInfoContributorPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.info.InfoEndpointAutoConfiguration", InfoEndpointAutoConfiguration__BeanDefinitions.getInfoEndpointAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("infoEndpoint", InfoEndpointAutoConfiguration__BeanDefinitions.getInfoEndpointBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.web.servlet.ServletManagementContextAutoConfiguration", ServletManagementContextAutoConfiguration__BeanDefinitions.getServletManagementContextAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("servletWebChildContextFactory", ServletManagementContextAutoConfiguration__BeanDefinitions.getServletWebChildContextFactoryBeanDefinition());
    beanFactory.registerBeanDefinition("managementServletContext", ServletManagementContextAutoConfiguration__BeanDefinitions.getManagementServletContextBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.condition.ConditionsReportEndpointAutoConfiguration", ConditionsReportEndpointAutoConfiguration__BeanDefinitions.getConditionsReportEndpointAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("conditionsReportEndpoint", ConditionsReportEndpointAutoConfiguration__BeanDefinitions.getConditionsReportEndpointBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.context.ShutdownEndpointAutoConfiguration", ShutdownEndpointAutoConfiguration__BeanDefinitions.getShutdownEndpointAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("shutdownEndpoint", ShutdownEndpointAutoConfiguration__BeanDefinitions.getShutdownEndpointBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.context.properties.ConfigurationPropertiesReportEndpointAutoConfiguration", ConfigurationPropertiesReportEndpointAutoConfiguration__BeanDefinitions.getConfigurationPropertiesReportEndpointAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("configurationPropertiesReportEndpoint", ConfigurationPropertiesReportEndpointAutoConfiguration__BeanDefinitions.getConfigurationPropertiesReportEndpointBeanDefinition());
    beanFactory.registerBeanDefinition("configurationPropertiesReportEndpointWebExtension", ConfigurationPropertiesReportEndpointAutoConfiguration__BeanDefinitions.getConfigurationPropertiesReportEndpointWebExtensionBeanDefinition());
    beanFactory.registerBeanDefinition("management.endpoint.configprops-org.springframework.boot.actuate.autoconfigure.context.properties.ConfigurationPropertiesReportEndpointProperties", ConfigurationPropertiesReportEndpointProperties__BeanDefinitions.getConfigurationPropertiesReportEndpointPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.data.redis.RedisReactiveAutoConfiguration", RedisReactiveAutoConfiguration__BeanDefinitions.getRedisReactiveAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("reactiveRedisTemplate", RedisReactiveAutoConfiguration__BeanDefinitions.getReactiveRedisTemplateBeanDefinition());
    beanFactory.registerBeanDefinition("reactiveStringRedisTemplate", RedisReactiveAutoConfiguration__BeanDefinitions.getReactiveStringRedisTemplateBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.data.redis.RedisReactiveHealthContributorAutoConfiguration", RedisReactiveHealthContributorAutoConfiguration__BeanDefinitions.getRedisReactiveHealthContributorAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("redisHealthContributor", RedisReactiveHealthContributorAutoConfiguration__BeanDefinitions.getRedisHealthContributorBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.data.redis.RedisHealthContributorAutoConfiguration", RedisHealthContributorAutoConfiguration__BeanDefinitions.getRedisHealthContributorAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.endpoint.EndpointAutoConfiguration", org.springframework.boot.actuate.autoconfigure.endpoint.EndpointAutoConfiguration__BeanDefinitions.getEndpointAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("endpointOperationParameterMapper", org.springframework.boot.actuate.autoconfigure.endpoint.EndpointAutoConfiguration__BeanDefinitions.getEndpointOperationParameterMapperBeanDefinition());
    beanFactory.registerBeanDefinition("endpointCachingOperationInvokerAdvisor", org.springframework.boot.actuate.autoconfigure.endpoint.EndpointAutoConfiguration__BeanDefinitions.getEndpointCachingOperationInvokerAdvisorBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.endpoint.jackson.JacksonEndpointAutoConfiguration", JacksonEndpointAutoConfiguration__BeanDefinitions.getJacksonEndpointAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("endpointObjectMapper", JacksonEndpointAutoConfiguration__BeanDefinitions.getEndpointObjectMapperBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration$WebEndpointServletConfiguration", WebEndpointAutoConfiguration__BeanDefinitions.WebEndpointServletConfiguration.getWebEndpointServletConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("servletEndpointDiscoverer", WebEndpointAutoConfiguration__BeanDefinitions.WebEndpointServletConfiguration.getServletEndpointDiscovererBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration", WebEndpointAutoConfiguration__BeanDefinitions.getWebEndpointAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("webEndpointPathMapper", WebEndpointAutoConfiguration__BeanDefinitions.getWebEndpointPathMapperBeanDefinition());
    beanFactory.registerBeanDefinition("endpointMediaTypes", WebEndpointAutoConfiguration__BeanDefinitions.getEndpointMediaTypesBeanDefinition());
    beanFactory.registerBeanDefinition("webEndpointDiscoverer", WebEndpointAutoConfiguration__BeanDefinitions.getWebEndpointDiscovererBeanDefinition());
    beanFactory.registerBeanDefinition("controllerEndpointDiscoverer", WebEndpointAutoConfiguration__BeanDefinitions.getControllerEndpointDiscovererBeanDefinition());
    beanFactory.registerBeanDefinition("pathMappedEndpoints", WebEndpointAutoConfiguration__BeanDefinitions.getPathMappedEndpointsBeanDefinition());
    beanFactory.registerBeanDefinition("webExposeExcludePropertyEndpointFilter", WebEndpointAutoConfiguration__BeanDefinitions.getWebExposeExcludePropertyEndpointFilterBeanDefinition());
    beanFactory.registerBeanDefinition("controllerExposeExcludePropertyEndpointFilter", WebEndpointAutoConfiguration__BeanDefinitions.getControllerExposeExcludePropertyEndpointFilterBeanDefinition());
    beanFactory.registerBeanDefinition("management.endpoints.web-org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties", WebEndpointProperties__BeanDefinitions.getWebEndpointPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.cloud.autoconfigure.LifecycleMvcEndpointAutoConfiguration", LifecycleMvcEndpointAutoConfiguration__BeanDefinitions.getLifecycleMvcEndpointAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("environmentManager", LifecycleMvcEndpointAutoConfiguration__BeanDefinitions.getEnvironmentManagerBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.env.EnvironmentEndpointAutoConfiguration", EnvironmentEndpointAutoConfiguration__BeanDefinitions.getEnvironmentEndpointAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("environmentEndpoint", EnvironmentEndpointAutoConfiguration__BeanDefinitions.getEnvironmentEndpointBeanDefinition());
    beanFactory.registerBeanDefinition("environmentEndpointWebExtension", EnvironmentEndpointAutoConfiguration__BeanDefinitions.getEnvironmentEndpointWebExtensionBeanDefinition());
    beanFactory.registerBeanDefinition("management.endpoint.env-org.springframework.boot.actuate.autoconfigure.env.EnvironmentEndpointProperties", EnvironmentEndpointProperties__BeanDefinitions.getEnvironmentEndpointPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.system.DiskSpaceHealthContributorAutoConfiguration", DiskSpaceHealthContributorAutoConfiguration__BeanDefinitions.getDiskSpaceHealthContributorAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("diskSpaceHealthIndicator", DiskSpaceHealthContributorAutoConfiguration__BeanDefinitions.getDiskSpaceHealthIndicatorBeanDefinition());
    beanFactory.registerBeanDefinition("management.health.diskspace-org.springframework.boot.actuate.autoconfigure.system.DiskSpaceHealthIndicatorProperties", DiskSpaceHealthIndicatorProperties__BeanDefinitions.getDiskSpaceHealthIndicatorPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.health.HealthContributorAutoConfiguration", HealthContributorAutoConfiguration__BeanDefinitions.getHealthContributorAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("pingHealthContributor", HealthContributorAutoConfiguration__BeanDefinitions.getPingHealthContributorBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.jdbc.DataSourceHealthContributorAutoConfiguration", DataSourceHealthContributorAutoConfiguration__BeanDefinitions.getDataSourceHealthContributorAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("dbHealthContributor", DataSourceHealthContributorAutoConfiguration__BeanDefinitions.getDbHealthContributorBeanDefinition());
    beanFactory.registerBeanDefinition("management.health.db-org.springframework.boot.actuate.autoconfigure.jdbc.DataSourceHealthIndicatorProperties", DataSourceHealthIndicatorProperties__BeanDefinitions.getDataSourceHealthIndicatorPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.liquibase.LiquibaseEndpointAutoConfiguration", LiquibaseEndpointAutoConfiguration__BeanDefinitions.getLiquibaseEndpointAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.logging.LogFileWebEndpointAutoConfiguration", LogFileWebEndpointAutoConfiguration__BeanDefinitions.getLogFileWebEndpointAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("management.endpoint.logfile-org.springframework.boot.actuate.autoconfigure.logging.LogFileWebEndpointProperties", LogFileWebEndpointProperties__BeanDefinitions.getLogFileWebEndpointPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.logging.LoggersEndpointAutoConfiguration", LoggersEndpointAutoConfiguration__BeanDefinitions.getLoggersEndpointAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("loggersEndpoint", LoggersEndpointAutoConfiguration__BeanDefinitions.getLoggersEndpointBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.management.HeapDumpWebEndpointAutoConfiguration", HeapDumpWebEndpointAutoConfiguration__BeanDefinitions.getHeapDumpWebEndpointAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("heapDumpWebEndpoint", HeapDumpWebEndpointAutoConfiguration__BeanDefinitions.getHeapDumpWebEndpointBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.management.ThreadDumpEndpointAutoConfiguration", ThreadDumpEndpointAutoConfiguration__BeanDefinitions.getThreadDumpEndpointAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("dumpEndpoint", ThreadDumpEndpointAutoConfiguration__BeanDefinitions.getDumpEndpointBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.metrics.MetricsAutoConfiguration", MetricsAutoConfiguration__BeanDefinitions.getMetricsAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("micrometerClock", MetricsAutoConfiguration__BeanDefinitions.getMicrometerClockBeanDefinition());
    beanFactory.registerBeanDefinition("meterRegistryPostProcessor", MetricsAutoConfiguration__BeanDefinitions.getMeterRegistryPostProcessorBeanDefinition());
    beanFactory.registerBeanDefinition("propertiesMeterFilter", MetricsAutoConfiguration__BeanDefinitions.getPropertiesMeterFilterBeanDefinition());
    beanFactory.registerBeanDefinition("meterRegistryCloser", MetricsAutoConfiguration__BeanDefinitions.getMeterRegistryCloserBeanDefinition());
    beanFactory.registerBeanDefinition("management.metrics-org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties", MetricsProperties__BeanDefinitions.getMetricsPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.metrics.export.simple.SimpleMetricsExportAutoConfiguration", SimpleMetricsExportAutoConfiguration__BeanDefinitions.getSimpleMetricsExportAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("simpleMeterRegistry", SimpleMetricsExportAutoConfiguration__BeanDefinitions.getSimpleMeterRegistryBeanDefinition());
    beanFactory.registerBeanDefinition("simpleConfig", SimpleMetricsExportAutoConfiguration__BeanDefinitions.getSimpleConfigBeanDefinition());
    beanFactory.registerBeanDefinition("management.simple.metrics.export-org.springframework.boot.actuate.autoconfigure.metrics.export.simple.SimpleProperties", SimpleProperties__BeanDefinitions.getSimplePropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.metrics.CompositeMeterRegistryAutoConfiguration", CompositeMeterRegistryAutoConfiguration__BeanDefinitions.getCompositeMeterRegistryAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.metrics.JvmMetricsAutoConfiguration", JvmMetricsAutoConfiguration__BeanDefinitions.getJvmMetricsAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("jvmGcMetrics", JvmMetricsAutoConfiguration__BeanDefinitions.getJvmGcMetricsBeanDefinition());
    beanFactory.registerBeanDefinition("jvmHeapPressureMetrics", JvmMetricsAutoConfiguration__BeanDefinitions.getJvmHeapPressureMetricsBeanDefinition());
    beanFactory.registerBeanDefinition("jvmMemoryMetrics", JvmMetricsAutoConfiguration__BeanDefinitions.getJvmMemoryMetricsBeanDefinition());
    beanFactory.registerBeanDefinition("jvmThreadMetrics", JvmMetricsAutoConfiguration__BeanDefinitions.getJvmThreadMetricsBeanDefinition());
    beanFactory.registerBeanDefinition("classLoaderMetrics", JvmMetricsAutoConfiguration__BeanDefinitions.getClassLoaderMetricsBeanDefinition());
    beanFactory.registerBeanDefinition("jvmInfoMetrics", JvmMetricsAutoConfiguration__BeanDefinitions.getJvmInfoMetricsBeanDefinition());
    beanFactory.registerBeanDefinition("jvmCompilationMetrics", JvmMetricsAutoConfiguration__BeanDefinitions.getJvmCompilationMetricsBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.metrics.LogbackMetricsAutoConfiguration", LogbackMetricsAutoConfiguration__BeanDefinitions.getLogbackMetricsAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("logbackMetrics", LogbackMetricsAutoConfiguration__BeanDefinitions.getLogbackMetricsBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.metrics.MetricsEndpointAutoConfiguration", MetricsEndpointAutoConfiguration__BeanDefinitions.getMetricsEndpointAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("metricsEndpoint", MetricsEndpointAutoConfiguration__BeanDefinitions.getMetricsEndpointBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.metrics.SystemMetricsAutoConfiguration", SystemMetricsAutoConfiguration__BeanDefinitions.getSystemMetricsAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("uptimeMetrics", SystemMetricsAutoConfiguration__BeanDefinitions.getUptimeMetricsBeanDefinition());
    beanFactory.registerBeanDefinition("processorMetrics", SystemMetricsAutoConfiguration__BeanDefinitions.getProcessorMetricsBeanDefinition());
    beanFactory.registerBeanDefinition("fileDescriptorMetrics", SystemMetricsAutoConfiguration__BeanDefinitions.getFileDescriptorMetricsBeanDefinition());
    beanFactory.registerBeanDefinition("diskSpaceMetrics", SystemMetricsAutoConfiguration__BeanDefinitions.getDiskSpaceMetricsBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.metrics.data.RepositoryMetricsAutoConfiguration", RepositoryMetricsAutoConfiguration__BeanDefinitions.getRepositoryMetricsAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("repositoryTagsProvider", RepositoryMetricsAutoConfiguration__BeanDefinitions.getRepositoryTagsProviderBeanDefinition());
    beanFactory.registerBeanDefinition("metricsRepositoryMethodInvocationListener", RepositoryMetricsAutoConfiguration__BeanDefinitions.getMetricsRepositoryMethodInvocationListenerBeanDefinition());
    beanFactory.registerBeanDefinition("metricsRepositoryMethodInvocationListenerBeanPostProcessor", RepositoryMetricsAutoConfiguration__BeanDefinitions.getMetricsRepositoryMethodInvocationListenerBeanPostProcessorBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.metrics.integration.IntegrationMetricsAutoConfiguration", IntegrationMetricsAutoConfiguration__BeanDefinitions.getIntegrationMetricsAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.metrics.jdbc.DataSourcePoolMetricsAutoConfiguration$HikariDataSourceMetricsConfiguration", DataSourcePoolMetricsAutoConfiguration__BeanDefinitions.HikariDataSourceMetricsConfiguration.getHikariDataSourceMetricsConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("hikariDataSourceMeterBinder", DataSourcePoolMetricsAutoConfiguration__BeanDefinitions.HikariDataSourceMetricsConfiguration.getHikariDataSourceMeterBinderBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.metrics.jdbc.DataSourcePoolMetricsAutoConfiguration$DataSourcePoolMetadataMetricsConfiguration", DataSourcePoolMetricsAutoConfiguration__BeanDefinitions.DataSourcePoolMetadataMetricsConfiguration.getDataSourcePoolMetadataMetricsConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("dataSourcePoolMetadataMeterBinder", DataSourcePoolMetricsAutoConfiguration__BeanDefinitions.DataSourcePoolMetadataMetricsConfiguration.getDataSourcePoolMetadataMeterBinderBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.metrics.jdbc.DataSourcePoolMetricsAutoConfiguration", DataSourcePoolMetricsAutoConfiguration__BeanDefinitions.getDataSourcePoolMetricsAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.metrics.startup.StartupTimeMetricsListenerAutoConfiguration", StartupTimeMetricsListenerAutoConfiguration__BeanDefinitions.getStartupTimeMetricsListenerAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("startupTimeMetrics", StartupTimeMetricsListenerAutoConfiguration__BeanDefinitions.getStartupTimeMetricsBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.task.TaskSchedulingConfigurations$ThreadPoolTaskSchedulerBuilderConfiguration", TaskSchedulingConfigurations__BeanDefinitions.ThreadPoolTaskSchedulerBuilderConfiguration.getThreadPoolTaskSchedulerBuilderConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("threadPoolTaskSchedulerBuilder", TaskSchedulingConfigurations__BeanDefinitions.ThreadPoolTaskSchedulerBuilderConfiguration.getThreadPoolTaskSchedulerBuilderBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.task.TaskSchedulingConfigurations$TaskSchedulerBuilderConfiguration", TaskSchedulingConfigurations__BeanDefinitions.TaskSchedulerBuilderConfiguration.getTaskSchedulerBuilderConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("taskSchedulerBuilder", TaskSchedulingConfigurations__BeanDefinitions.TaskSchedulerBuilderConfiguration.getTaskSchedulerBuilderBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.task.TaskSchedulingConfigurations$SimpleAsyncTaskSchedulerBuilderConfiguration", TaskSchedulingConfigurations__BeanDefinitions.SimpleAsyncTaskSchedulerBuilderConfiguration.getSimpleAsyncTaskSchedulerBuilderConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("simpleAsyncTaskSchedulerBuilder", TaskSchedulingConfigurations__BeanDefinitions.SimpleAsyncTaskSchedulerBuilderConfiguration.getSimpleAsyncTaskSchedulerBuilderBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.task.TaskSchedulingConfigurations$TaskSchedulerConfiguration", TaskSchedulingConfigurations__BeanDefinitions.TaskSchedulerConfiguration.getTaskSchedulerConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("taskScheduler", TaskSchedulingConfigurations__BeanDefinitions.TaskSchedulerConfiguration.getTaskSchedulerBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration", TaskSchedulingAutoConfiguration__BeanDefinitions.getTaskSchedulingAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("scheduledBeanLazyInitializationExcludeFilter", TaskSchedulingAutoConfiguration__BeanDefinitions.getScheduledBeanLazyInitializationExcludeFilterBeanDefinition());
    beanFactory.registerBeanDefinition("spring.task.scheduling-org.springframework.boot.autoconfigure.task.TaskSchedulingProperties", TaskSchedulingProperties__BeanDefinitions.getTaskSchedulingPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.metrics.task.TaskExecutorMetricsAutoConfiguration", TaskExecutorMetricsAutoConfiguration__BeanDefinitions.getTaskExecutorMetricsAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("eagerTaskExecutorMetrics", TaskExecutorMetricsAutoConfiguration__BeanDefinitions.getEagerTaskExecutorMetricsBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.observation.ObservationAutoConfiguration$ObservedAspectConfiguration", ObservationAutoConfiguration__BeanDefinitions.ObservedAspectConfiguration.getObservedAspectConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("observedAspect", ObservationAutoConfiguration__BeanDefinitions.ObservedAspectConfiguration.getObservedAspectBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.observation.ObservationAutoConfiguration$MeterObservationHandlerConfiguration$OnlyMetricsMeterObservationHandlerConfiguration", ObservationAutoConfiguration__BeanDefinitions.MeterObservationHandlerConfiguration.OnlyMetricsMeterObservationHandlerConfiguration.getOnlyMetricsMeterObservationHandlerConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("defaultMeterObservationHandler", ObservationAutoConfiguration__BeanDefinitions.MeterObservationHandlerConfiguration.OnlyMetricsMeterObservationHandlerConfiguration.getDefaultMeterObservationHandlerBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.observation.ObservationAutoConfiguration$MeterObservationHandlerConfiguration", ObservationAutoConfiguration__BeanDefinitions.MeterObservationHandlerConfiguration.getMeterObservationHandlerConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.observation.ObservationAutoConfiguration$OnlyMetricsConfiguration", ObservationAutoConfiguration__BeanDefinitions.OnlyMetricsConfiguration.getOnlyMetricsConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("metricsObservationHandlerGrouping", ObservationAutoConfiguration__BeanDefinitions.OnlyMetricsConfiguration.getMetricsObservationHandlerGroupingBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.observation.ObservationAutoConfiguration", ObservationAutoConfiguration__BeanDefinitions.getObservationAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("observationRegistryPostProcessor", ObservationAutoConfiguration__BeanDefinitions.getObservationRegistryPostProcessorBeanDefinition());
    beanFactory.registerBeanDefinition("observationRegistry", ObservationAutoConfiguration__BeanDefinitions.getObservationRegistryBeanDefinition());
    beanFactory.registerBeanDefinition("propertiesObservationFilter", ObservationAutoConfiguration__BeanDefinitions.getPropertiesObservationFilterBeanDefinition());
    beanFactory.registerBeanDefinition("management.observations-org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties", ObservationProperties__BeanDefinitions.getObservationPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration$StringHttpMessageConverterConfiguration", HttpMessageConvertersAutoConfiguration__BeanDefinitions.StringHttpMessageConverterConfiguration.getStringHttpMessageConverterConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("stringHttpMessageConverter", HttpMessageConvertersAutoConfiguration__BeanDefinitions.StringHttpMessageConverterConfiguration.getStringHttpMessageConverterBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.http.JacksonHttpMessageConvertersConfiguration$MappingJackson2HttpMessageConverterConfiguration", JacksonHttpMessageConvertersConfiguration__BeanDefinitions.MappingJackson2HttpMessageConverterConfiguration.getMappingJacksonHttpMessageConverterConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("mappingJackson2HttpMessageConverter", JacksonHttpMessageConvertersConfiguration__BeanDefinitions.MappingJackson2HttpMessageConverterConfiguration.getMappingJacksonHttpMessageConverterBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.http.JacksonHttpMessageConvertersConfiguration", JacksonHttpMessageConvertersConfiguration__BeanDefinitions.getJacksonHttpMessageConvertersConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration", HttpMessageConvertersAutoConfiguration__BeanDefinitions.getHttpMessageConvertersAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("messageConverters", HttpMessageConvertersAutoConfiguration__BeanDefinitions.getMessageConvertersBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.web.client.RestClientAutoConfiguration", RestClientAutoConfiguration__BeanDefinitions.getRestClientAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("httpMessageConvertersRestClientCustomizer", RestClientAutoConfiguration__BeanDefinitions.getHttpMessageConvertersRestClientCustomizerBeanDefinition());
    beanFactory.registerBeanDefinition("restClientSsl", RestClientAutoConfiguration__BeanDefinitions.getRestClientSslBeanDefinition());
    beanFactory.registerBeanDefinition("restClientBuilderConfigurer", RestClientAutoConfiguration__BeanDefinitions.getRestClientBuilderConfigurerBeanDefinition());
    beanFactory.registerBeanDefinition("restClientBuilder", RestClientAutoConfiguration__BeanDefinitions.getRestClientBuilderBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration", RestTemplateAutoConfiguration__BeanDefinitions.getRestTemplateAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("restTemplateBuilderConfigurer", RestTemplateAutoConfiguration__BeanDefinitions.getRestTemplateBuilderConfigurerBeanDefinition());
    beanFactory.registerBeanDefinition("restTemplateBuilder", RestTemplateAutoConfiguration__BeanDefinitions.getRestTemplateBuilderBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.reactor.netty.ReactorNettyConfigurations$ReactorResourceFactoryConfiguration", ReactorNettyConfigurations__BeanDefinitions.ReactorResourceFactoryConfiguration.getReactorResourceFactoryConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("reactorResourceFactory", ReactorNettyConfigurations__BeanDefinitions.ReactorResourceFactoryConfiguration.getReactorResourceFactoryBeanDefinition());
    beanFactory.registerBeanDefinition("spring.reactor.netty-org.springframework.boot.autoconfigure.reactor.netty.ReactorNettyProperties", ReactorNettyProperties__BeanDefinitions.getReactorNettyPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.web.reactive.function.client.ClientHttpConnectorFactoryConfiguration$ReactorNetty", ClientHttpConnectorFactoryConfiguration__BeanDefinitions.ReactorNetty.getReactorNettyBeanDefinition());
    beanFactory.registerBeanDefinition("reactorClientHttpConnectorFactory", ClientHttpConnectorFactoryConfiguration__BeanDefinitions.ReactorNetty.getReactorClientHttpConnectorFactoryBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.web.reactive.function.client.ClientHttpConnectorAutoConfiguration", ClientHttpConnectorAutoConfiguration__BeanDefinitions.getClientHttpConnectorAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("webClientHttpConnector", ClientHttpConnectorAutoConfiguration__BeanDefinitions.getWebClientHttpConnectorBeanDefinition());
    beanFactory.registerBeanDefinition("webClientHttpConnectorCustomizer", ClientHttpConnectorAutoConfiguration__BeanDefinitions.getWebClientHttpConnectorCustomizerBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration$WebClientCodecsConfiguration", WebClientAutoConfiguration__BeanDefinitions.WebClientCodecsConfiguration.getWebClientCodecsConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("exchangeStrategiesCustomizer", WebClientAutoConfiguration__BeanDefinitions.WebClientCodecsConfiguration.getExchangeStrategiesCustomizerBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration", WebClientAutoConfiguration__BeanDefinitions.getWebClientAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("webClientBuilder", WebClientAutoConfiguration__BeanDefinitions.getWebClientBuilderBeanDefinition());
    beanFactory.registerBeanDefinition("webClientSsl", WebClientAutoConfiguration__BeanDefinitions.getWebClientSslBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.observation.web.client.HttpClientObservationsAutoConfiguration$MeterFilterConfiguration", HttpClientObservationsAutoConfiguration__BeanDefinitions.MeterFilterConfiguration.getMeterFilterConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("metricsHttpClientUriTagFilter", HttpClientObservationsAutoConfiguration__BeanDefinitions.MeterFilterConfiguration.getMetricsHttpClientUriTagFilterBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.observation.web.client.RestTemplateObservationConfiguration", RestTemplateObservationConfiguration__BeanDefinitions.getRestTemplateObservationConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("observationRestTemplateCustomizer", RestTemplateObservationConfiguration__BeanDefinitions.getObservationRestTemplateCustomizerBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.observation.web.client.WebClientObservationConfiguration", WebClientObservationConfiguration__BeanDefinitions.getWebClientObservationConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("observationWebClientCustomizer", WebClientObservationConfiguration__BeanDefinitions.getObservationWebClientCustomizerBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.observation.web.client.RestClientObservationConfiguration", RestClientObservationConfiguration__BeanDefinitions.getRestClientObservationConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("observationRestClientCustomizer", RestClientObservationConfiguration__BeanDefinitions.getObservationRestClientCustomizerBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.observation.web.client.HttpClientObservationsAutoConfiguration", HttpClientObservationsAutoConfiguration__BeanDefinitions.getHttpClientObservationsAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.observation.web.servlet.WebMvcObservationAutoConfiguration$MeterFilterConfiguration", WebMvcObservationAutoConfiguration__BeanDefinitions.MeterFilterConfiguration.getMeterFilterConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("metricsHttpServerUriTagFilter", WebMvcObservationAutoConfiguration__BeanDefinitions.MeterFilterConfiguration.getMetricsHttpServerUriTagFilterBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.observation.web.servlet.WebMvcObservationAutoConfiguration", WebMvcObservationAutoConfiguration__BeanDefinitions.getWebMvcObservationAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("webMvcObservationFilter", WebMvcObservationAutoConfiguration__BeanDefinitions.getWebMvcObservationFilterBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.scheduling.ScheduledTasksEndpointAutoConfiguration", ScheduledTasksEndpointAutoConfiguration__BeanDefinitions.getScheduledTasksEndpointAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("scheduledTasksEndpoint", ScheduledTasksEndpointAutoConfiguration__BeanDefinitions.getScheduledTasksEndpointBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.scheduling.ScheduledTasksObservabilityAutoConfiguration", ScheduledTasksObservabilityAutoConfiguration__BeanDefinitions.getScheduledTasksObservabilityAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("observabilitySchedulingConfigurer", ScheduledTasksObservabilityAutoConfiguration__BeanDefinitions.getObservabilitySchedulingConfigurerBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.web.exchanges.HttpExchangesEndpointAutoConfiguration", HttpExchangesEndpointAutoConfiguration__BeanDefinitions.getHttpExchangesEndpointAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.web.mappings.MappingsEndpointAutoConfiguration$ServletWebConfiguration$SpringMvcConfiguration", MappingsEndpointAutoConfiguration__BeanDefinitions.ServletWebConfiguration.SpringMvcConfiguration.getSpringMvcConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("dispatcherServletMappingDescriptionProvider", MappingsEndpointAutoConfiguration__BeanDefinitions.ServletWebConfiguration.SpringMvcConfiguration.getDispatcherServletMappingDescriptionProviderBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.web.mappings.MappingsEndpointAutoConfiguration$ServletWebConfiguration", MappingsEndpointAutoConfiguration__BeanDefinitions.ServletWebConfiguration.getServletWebConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("servletMappingDescriptionProvider", MappingsEndpointAutoConfiguration__BeanDefinitions.ServletWebConfiguration.getServletMappingDescriptionProviderBeanDefinition());
    beanFactory.registerBeanDefinition("filterMappingDescriptionProvider", MappingsEndpointAutoConfiguration__BeanDefinitions.ServletWebConfiguration.getFilterMappingDescriptionProviderBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.web.mappings.MappingsEndpointAutoConfiguration", MappingsEndpointAutoConfiguration__BeanDefinitions.getMappingsEndpointAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("mappingsEndpoint", MappingsEndpointAutoConfiguration__BeanDefinitions.getMappingsEndpointBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.aop.AopAutoConfiguration$AspectJAutoProxyingConfiguration$CglibAutoProxyConfiguration", AopAutoConfiguration__BeanDefinitions.AspectJAutoProxyingConfiguration.CglibAutoProxyConfiguration.getCglibAutoProxyConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.aop.AopAutoConfiguration$AspectJAutoProxyingConfiguration", AopAutoConfiguration__BeanDefinitions.AspectJAutoProxyingConfiguration.getAspectJAutoProxyingConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.aop.AopAutoConfiguration", AopAutoConfiguration__BeanDefinitions.getAopAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration", ConfigurationPropertiesAutoConfiguration__BeanDefinitions.getConfigurationPropertiesAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration", LifecycleAutoConfiguration__BeanDefinitions.getLifecycleAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("lifecycleProcessor", LifecycleAutoConfiguration__BeanDefinitions.getLifecycleProcessorBeanDefinition());
    beanFactory.registerBeanDefinition("spring.lifecycle-org.springframework.boot.autoconfigure.context.LifecycleProperties", LifecycleProperties__BeanDefinitions.getLifecyclePropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration", PersistenceExceptionTranslationAutoConfiguration__BeanDefinitions.getPersistenceExceptionTranslationAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("persistenceExceptionTranslationPostProcessor", PersistenceExceptionTranslationAutoConfiguration__BeanDefinitions.getPersistenceExceptionTranslationPostProcessorBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration", RedisRepositoriesAutoConfiguration__BeanDefinitions.getRedisRepositoriesAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("redisIndexConfiguration#0", IndexConfiguration__BeanDefinitions.getRedisIndexConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("redisKeyspaceConfiguration#0", KeyspaceConfiguration__BeanDefinitions.getRedisKeyspaceConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("redisMappingConfiguration#0", MappingConfiguration__BeanDefinitions.getRedisMappingConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("keyValueMappingContext", RedisMappingContext__BeanDefinitions.getKeyValueMappingContextBeanDefinition());
    beanFactory.registerBeanDefinition("redisCustomConversions", RedisCustomConversions__BeanDefinitions.getRedisCustomConversionsBeanDefinition());
    beanFactory.registerBeanDefinition("redisReferenceResolver", ReferenceResolverImpl__BeanDefinitions.getRedisReferenceResolverBeanDefinition());
    beanFactory.registerBeanDefinition("redisConverter", MappingRedisConverter__BeanDefinitions.getRedisConverterBeanDefinition());
    beanFactory.registerBeanDefinition("redisKeyValueAdapter", RedisKeyValueAdapter__BeanDefinitions.getRedisKeyValueAdapterBeanDefinition());
    beanFactory.registerBeanDefinition("redisKeyValueTemplate", RedisKeyValueTemplate__BeanDefinitions.getRedisKeyValueTemplateBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.data.web.config.ProjectingArgumentResolverRegistrar", ProjectingArgumentResolverRegistrar__BeanDefinitions.getProjectingArgumentResolverRegistrarBeanDefinition());
    beanFactory.registerBeanDefinition("projectingArgumentResolverBeanPostProcessor", ProjectingArgumentResolverRegistrar__BeanDefinitions.getProjectingArgumentResolverBeanPostProcessorBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.data.web.config.SpringDataWebConfiguration", SpringDataWebConfiguration__BeanDefinitions.getSpringDataWebConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("pageableResolver", SpringDataWebConfiguration__BeanDefinitions.getPageableResolverBeanDefinition());
    beanFactory.registerBeanDefinition("sortResolver", SpringDataWebConfiguration__BeanDefinitions.getSortResolverBeanDefinition());
    beanFactory.registerBeanDefinition("offsetResolver", SpringDataWebConfiguration__BeanDefinitions.getOffsetResolverBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.data.web.config.SpringDataJacksonConfiguration", SpringDataJacksonConfiguration__BeanDefinitions.getSpringDataJacksonConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("jacksonGeoModule", SpringDataJacksonConfiguration__BeanDefinitions.getJacksonGeoModuleBeanDefinition());
    beanFactory.registerBeanDefinition("pageModule", SpringDataJacksonConfiguration__BeanDefinitions.getPageModuleBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration", SpringDataWebAutoConfiguration__BeanDefinitions.getSpringDataWebAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("pageableCustomizer", SpringDataWebAutoConfiguration__BeanDefinitions.getPageableCustomizerBeanDefinition());
    beanFactory.registerBeanDefinition("sortCustomizer", SpringDataWebAutoConfiguration__BeanDefinitions.getSortCustomizerBeanDefinition());
    beanFactory.registerBeanDefinition("spring.data.web-org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties", SpringDataWebProperties__BeanDefinitions.getSpringDataWebPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.jdbc.JdbcTemplateConfiguration", JdbcTemplateConfiguration__BeanDefinitions.getJdbcTemplateConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("jdbcTemplate", JdbcTemplateConfiguration__BeanDefinitions.getJdbcTemplateBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.jdbc.NamedParameterJdbcTemplateConfiguration", NamedParameterJdbcTemplateConfiguration__BeanDefinitions.getNamedParameterJdbcTemplateConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("namedParameterJdbcTemplate", NamedParameterJdbcTemplateConfiguration__BeanDefinitions.getNamedParameterJdbcTemplateBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration", JdbcTemplateAutoConfiguration__BeanDefinitions.getJdbcTemplateAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("spring.jdbc-org.springframework.boot.autoconfigure.jdbc.JdbcProperties", JdbcProperties__BeanDefinitions.getJdbcPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.sql.init.dependency.DatabaseInitializationDependencyConfigurer$DependsOnDatabaseInitializationPostProcessor", DatabaseInitializationDependencyConfigurer__BeanDefinitions.DependsOnDatabaseInitializationPostProcessor.getDependsOnDatabaseInitializationPostProcessorBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.jdbc.JdbcClientAutoConfiguration", JdbcClientAutoConfiguration__BeanDefinitions.getJdbcClientAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("jdbcClient", JdbcClientAutoConfiguration__BeanDefinitions.getJdbcClientBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.netty.NettyAutoConfiguration", NettyAutoConfiguration__BeanDefinitions.getNettyAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("spring.netty-org.springframework.boot.autoconfigure.netty.NettyProperties", NettyProperties__BeanDefinitions.getNettyPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.reactor.ReactorAutoConfiguration", ReactorAutoConfiguration__BeanDefinitions.getReactorAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("spring.reactor-org.springframework.boot.autoconfigure.reactor.ReactorProperties", ReactorProperties__BeanDefinitions.getReactorPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration", ReactiveSecurityAutoConfiguration__BeanDefinitions.getReactiveSecurityAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("spring.security-org.springframework.boot.autoconfigure.security.SecurityProperties", SecurityProperties__BeanDefinitions.getSecurityPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.security.servlet.SpringBootWebSecurityConfiguration", SpringBootWebSecurityConfiguration__BeanDefinitions.getSpringBootWebSecurityConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration", SecurityAutoConfiguration__BeanDefinitions.getSecurityAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("authenticationEventPublisher", SecurityAutoConfiguration__BeanDefinitions.getAuthenticationEventPublisherBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration", SecurityFilterAutoConfiguration__BeanDefinitions.getSecurityFilterAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("securityFilterChainRegistration", SecurityFilterAutoConfiguration__BeanDefinitions.getSecurityFilterChainRegistrationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.sql.init.DataSourceInitializationConfiguration", DataSourceInitializationConfiguration__BeanDefinitions.getDataSourceInitializationConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("dataSourceScriptDatabaseInitializer", DataSourceInitializationConfiguration__BeanDefinitions.getDataSourceScriptDatabaseInitializerBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration", SqlInitializationAutoConfiguration__BeanDefinitions.getSqlInitializationAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("spring.sql.init-org.springframework.boot.autoconfigure.sql.init.SqlInitializationProperties", SqlInitializationProperties__BeanDefinitions.getSqlInitializationPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration$JdbcTransactionManagerConfiguration", DataSourceTransactionManagerAutoConfiguration__BeanDefinitions.JdbcTransactionManagerConfiguration.getJdbcTransactionManagerConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("transactionManager", DataSourceTransactionManagerAutoConfiguration__BeanDefinitions.JdbcTransactionManagerConfiguration.getTransactionManagerBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration", DataSourceTransactionManagerAutoConfiguration__BeanDefinitions.getDataSourceTransactionManagerAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration", ProxyTransactionManagementConfiguration__BeanDefinitions.getProxyTransactionManagementConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.transaction.config.internalTransactionAdvisor", ProxyTransactionManagementConfiguration__BeanDefinitions.getInternalTransactionAdvisorBeanDefinition());
    beanFactory.registerBeanDefinition("transactionAttributeSource", ProxyTransactionManagementConfiguration__BeanDefinitions.getTransactionAttributeSourceBeanDefinition());
    beanFactory.registerBeanDefinition("transactionInterceptor", ProxyTransactionManagementConfiguration__BeanDefinitions.getTransactionInterceptorBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.transaction.config.internalTransactionalEventListenerFactory", AbstractTransactionManagementConfiguration__BeanDefinitions.getInternalTransactionalEventListenerFactoryBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration$EnableTransactionManagementConfiguration$CglibAutoProxyConfiguration", TransactionAutoConfiguration__BeanDefinitions.EnableTransactionManagementConfiguration.CglibAutoProxyConfiguration.getCglibAutoProxyConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration$EnableTransactionManagementConfiguration", TransactionAutoConfiguration__BeanDefinitions.EnableTransactionManagementConfiguration.getEnableTransactionManagementConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration$TransactionTemplateConfiguration", TransactionAutoConfiguration__BeanDefinitions.TransactionTemplateConfiguration.getTransactionTemplateConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("transactionTemplate", TransactionAutoConfiguration__BeanDefinitions.TransactionTemplateConfiguration.getTransactionTemplateBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration", TransactionAutoConfiguration__BeanDefinitions.getTransactionAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration$NettyWebServerFactoryCustomizerConfiguration", EmbeddedWebServerFactoryCustomizerAutoConfiguration__BeanDefinitions.NettyWebServerFactoryCustomizerConfiguration.getNettyWebServerFactoryCustomizerConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("nettyWebServerFactoryCustomizer", EmbeddedWebServerFactoryCustomizerAutoConfiguration__BeanDefinitions.NettyWebServerFactoryCustomizerConfiguration.getNettyWebServerFactoryCustomizerBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration$UndertowWebServerFactoryCustomizerConfiguration", EmbeddedWebServerFactoryCustomizerAutoConfiguration__BeanDefinitions.UndertowWebServerFactoryCustomizerConfiguration.getUndertowWebServerFactoryCustomizerConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("undertowWebServerFactoryCustomizer", EmbeddedWebServerFactoryCustomizerAutoConfiguration__BeanDefinitions.UndertowWebServerFactoryCustomizerConfiguration.getUndertowWebServerFactoryCustomizerBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration", EmbeddedWebServerFactoryCustomizerAutoConfiguration__BeanDefinitions.getEmbeddedWebServerFactoryCustomizerAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration", HttpEncodingAutoConfiguration__BeanDefinitions.getHttpEncodingAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("characterEncodingFilter", HttpEncodingAutoConfiguration__BeanDefinitions.getCharacterEncodingFilterBeanDefinition());
    beanFactory.registerBeanDefinition("localeCharsetMappingsCustomizer", HttpEncodingAutoConfiguration__BeanDefinitions.getLocaleCharsetMappingsCustomizerBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.cloud.autoconfigure.ConfigurationPropertiesRebinderAutoConfiguration", ConfigurationPropertiesRebinderAutoConfiguration__BeanDefinitions.getConfigurationPropertiesRebinderAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("configurationPropertiesBeans", ConfigurationPropertiesRebinderAutoConfiguration__BeanDefinitions.getConfigurationPropertiesBeansBeanDefinition());
    beanFactory.registerBeanDefinition("configurationPropertiesRebinder", ConfigurationPropertiesRebinderAutoConfiguration__BeanDefinitions.getConfigurationPropertiesRebinderBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.cloud.autoconfigure.RefreshEndpointAutoConfiguration$RefreshEndpointConfiguration", RefreshEndpointAutoConfiguration__BeanDefinitions.RefreshEndpointConfiguration.getRefreshEndpointConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("refreshEndpoint", RefreshEndpointAutoConfiguration__BeanDefinitions.RefreshEndpointConfiguration.getRefreshEndpointBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.cloud.autoconfigure.RestartEndpointWithoutIntegrationConfiguration", RestartEndpointWithoutIntegrationConfiguration__BeanDefinitions.getRestartEndpointWithoutIntegrationConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.cloud.autoconfigure.PauseResumeEndpointsConfiguration", PauseResumeEndpointsConfiguration__BeanDefinitions.getPauseResumeEndpointsConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.cloud.autoconfigure.RefreshEndpointAutoConfiguration", RefreshEndpointAutoConfiguration__BeanDefinitions.getRefreshEndpointAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("refreshScopeHealthIndicator", RefreshEndpointAutoConfiguration__BeanDefinitions.getRefreshScopeHealthIndicatorBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.cloud.client.discovery.composite.CompositeDiscoveryClientAutoConfiguration", CompositeDiscoveryClientAutoConfiguration__BeanDefinitions.getCompositeDiscoveryClientAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("compositeDiscoveryClient", CompositeDiscoveryClientAutoConfiguration__BeanDefinitions.getCompositeDiscoveryClientBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.cloud.client.discovery.simple.SimpleDiscoveryClientAutoConfiguration", SimpleDiscoveryClientAutoConfiguration__BeanDefinitions.getSimpleDiscoveryClientAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("simpleDiscoveryProperties", SimpleDiscoveryClientAutoConfiguration__BeanDefinitions.getSimpleDiscoveryPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("simpleDiscoveryClient", SimpleDiscoveryClientAutoConfiguration__BeanDefinitions.getSimpleDiscoveryClientBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.cloud.client.CommonsClientAutoConfiguration$ActuatorConfiguration", CommonsClientAutoConfiguration__BeanDefinitions.ActuatorConfiguration.getActuatorConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("featuresEndpoint", CommonsClientAutoConfiguration__BeanDefinitions.ActuatorConfiguration.getFeaturesEndpointBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.cloud.client.CommonsClientAutoConfiguration$DiscoveryLoadBalancerConfiguration", CommonsClientAutoConfiguration__BeanDefinitions.DiscoveryLoadBalancerConfiguration.getDiscoveryLoadBalancerConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("discoveryClientHealthIndicator", CommonsClientAutoConfiguration__BeanDefinitions.DiscoveryLoadBalancerConfiguration.getDiscoveryClientHealthIndicatorBeanDefinition());
    beanFactory.registerBeanDefinition("discoveryCompositeHealthContributor", CommonsClientAutoConfiguration__BeanDefinitions.DiscoveryLoadBalancerConfiguration.getDiscoveryCompositeHealthContributorBeanDefinition());
    beanFactory.registerBeanDefinition("springCloudCommonsFeatures", CommonsClientAutoConfiguration__BeanDefinitions.DiscoveryLoadBalancerConfiguration.getSpringCloudCommonsFeaturesBeanDefinition());
    beanFactory.registerBeanDefinition("spring.cloud.discovery.client.health-indicator-org.springframework.cloud.client.discovery.health.DiscoveryClientHealthIndicatorProperties", DiscoveryClientHealthIndicatorProperties__BeanDefinitions.getDiscoveryClientHealthIndicatorPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.cloud.client.CommonsClientAutoConfiguration", CommonsClientAutoConfiguration__BeanDefinitions.getCommonsClientAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.cloud.client.discovery.simple.reactive.SimpleReactiveDiscoveryClientAutoConfiguration$HealthConfiguration", SimpleReactiveDiscoveryClientAutoConfiguration__BeanDefinitions.HealthConfiguration.getHealthConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("simpleReactiveDiscoveryClientHealthIndicator", SimpleReactiveDiscoveryClientAutoConfiguration__BeanDefinitions.HealthConfiguration.getSimpleReactiveDiscoveryClientHealthIndicatorBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.cloud.client.discovery.simple.reactive.SimpleReactiveDiscoveryClientAutoConfiguration", SimpleReactiveDiscoveryClientAutoConfiguration__BeanDefinitions.getSimpleReactiveDiscoveryClientAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("simpleReactiveDiscoveryProperties", SimpleReactiveDiscoveryClientAutoConfiguration__BeanDefinitions.getSimpleReactiveDiscoveryPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("simpleReactiveDiscoveryClient", SimpleReactiveDiscoveryClientAutoConfiguration__BeanDefinitions.getSimpleReactiveDiscoveryClientBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.cloud.client.ReactiveCommonsClientAutoConfiguration$ReactiveDiscoveryLoadBalancerConfiguration", ReactiveCommonsClientAutoConfiguration__BeanDefinitions.ReactiveDiscoveryLoadBalancerConfiguration.getReactiveDiscoveryLoadBalancerConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("reactiveDiscoveryClients", ReactiveCommonsClientAutoConfiguration__BeanDefinitions.ReactiveDiscoveryLoadBalancerConfiguration.getReactiveDiscoveryClientsBeanDefinition());
    beanFactory.registerBeanDefinition("reactiveCommonsFeatures", ReactiveCommonsClientAutoConfiguration__BeanDefinitions.ReactiveDiscoveryLoadBalancerConfiguration.getReactiveCommonsFeaturesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.cloud.client.ReactiveCommonsClientAutoConfiguration", ReactiveCommonsClientAutoConfiguration__BeanDefinitions.getReactiveCommonsClientAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.cloud.client.loadbalancer.LoadBalancerDefaultMappingsProviderAutoConfiguration", LoadBalancerDefaultMappingsProviderAutoConfiguration__BeanDefinitions.getLoadBalancerDefaultMappingsProviderAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("loadBalancerClientsDefaultsMappingsProvider", LoadBalancerDefaultMappingsProviderAutoConfiguration__BeanDefinitions.getLoadBalancerClientsDefaultsMappingsProviderBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.cloud.client.serviceregistry.ServiceRegistryAutoConfiguration$ServiceRegistryEndpointConfiguration", ServiceRegistryAutoConfiguration__BeanDefinitions.ServiceRegistryEndpointConfiguration.getServiceRegistryEndpointConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("serviceRegistryEndpoint", ServiceRegistryAutoConfiguration__BeanDefinitions.ServiceRegistryEndpointConfiguration.getServiceRegistryEndpointBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.cloud.client.serviceregistry.ServiceRegistryAutoConfiguration", ServiceRegistryAutoConfiguration__BeanDefinitions.getServiceRegistryAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.cloud.commons.config.CommonsConfigAutoConfiguration", CommonsConfigAutoConfiguration__BeanDefinitions.getCommonsConfigAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("defaultsBindHandlerAdvisor", CommonsConfigAutoConfiguration__BeanDefinitions.getDefaultsBindHandlerAdvisorBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.cloud.commons.security.ResourceServerTokenRelayAutoConfiguration$ResourceServerTokenRelayRegistrationAutoConfiguration", ResourceServerTokenRelayAutoConfiguration__BeanDefinitions.ResourceServerTokenRelayRegistrationAutoConfiguration.getResourceServerTokenRelayRegistrationAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.cloud.commons.security.ResourceServerTokenRelayAutoConfiguration", ResourceServerTokenRelayAutoConfiguration__BeanDefinitions.getResourceServerTokenRelayAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.cloud.commons.util.UtilAutoConfiguration", UtilAutoConfiguration__BeanDefinitions.getUtilAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("inetUtilsProperties", UtilAutoConfiguration__BeanDefinitions.getInetUtilsPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("inetUtils", UtilAutoConfiguration__BeanDefinitions.getInetUtilsBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.cloud.configuration.CompatibilityVerifierAutoConfiguration", CompatibilityVerifierAutoConfiguration__BeanDefinitions.getCompatibilityVerifierAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("compositeCompatibilityVerifier", CompatibilityVerifierAutoConfiguration__BeanDefinitions.getCompositeCompatibilityVerifierBeanDefinition());
    beanFactory.registerBeanDefinition("springBootVersionVerifier", CompatibilityVerifierAutoConfiguration__BeanDefinitions.getSpringBootVersionVerifierBeanDefinition());
    beanFactory.registerBeanDefinition("sleuthPresentVerifier", CompatibilityVerifierAutoConfiguration__BeanDefinitions.getSleuthPresentVerifierBeanDefinition());
    beanFactory.registerBeanDefinition("spring.cloud.compatibility-verifier-org.springframework.cloud.configuration.CompatibilityVerifierProperties", CompatibilityVerifierProperties__BeanDefinitions.getCompatibilityVerifierPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.endpoint.web.ServletEndpointManagementContextConfiguration$WebMvcServletEndpointManagementContextConfiguration", ServletEndpointManagementContextConfiguration__BeanDefinitions.WebMvcServletEndpointManagementContextConfiguration.getWebMvcServletEndpointManagementContextConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("servletEndpointRegistrar", ServletEndpointManagementContextConfiguration__BeanDefinitions.WebMvcServletEndpointManagementContextConfiguration.getServletEndpointRegistrarBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.endpoint.web.ServletEndpointManagementContextConfiguration", ServletEndpointManagementContextConfiguration__BeanDefinitions.getServletEndpointManagementContextConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("servletExposeExcludePropertyEndpointFilter", ServletEndpointManagementContextConfiguration__BeanDefinitions.getServletExposeExcludePropertyEndpointFilterBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.endpoint.web.servlet.WebMvcEndpointManagementContextConfiguration", WebMvcEndpointManagementContextConfiguration__BeanDefinitions.getWebMvcEndpointManagementContextConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("webEndpointServletHandlerMapping", WebMvcEndpointManagementContextConfiguration__BeanDefinitions.getWebEndpointServletHandlerMappingBeanDefinition());
    beanFactory.registerBeanDefinition("controllerEndpointHandlerMapping", WebMvcEndpointManagementContextConfiguration__BeanDefinitions.getControllerEndpointHandlerMappingBeanDefinition());
    beanFactory.registerBeanDefinition("endpointObjectMapperWebMvcConfigurer", WebMvcEndpointManagementContextConfiguration__BeanDefinitions.getEndpointObjectMapperWebMvcConfigurerBeanDefinition());
    beanFactory.registerBeanDefinition("management.endpoints.web.cors-org.springframework.boot.actuate.autoconfigure.endpoint.web.CorsEndpointProperties", CorsEndpointProperties__BeanDefinitions.getCorsEndpointPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.security.servlet.SecurityRequestMatchersManagementContextConfiguration$MvcRequestMatcherConfiguration", SecurityRequestMatchersManagementContextConfiguration__BeanDefinitions.MvcRequestMatcherConfiguration.getMvcRequestMatcherConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("requestMatcherProvider", SecurityRequestMatchersManagementContextConfiguration__BeanDefinitions.MvcRequestMatcherConfiguration.getRequestMatcherProviderBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.security.servlet.SecurityRequestMatchersManagementContextConfiguration", SecurityRequestMatchersManagementContextConfiguration__BeanDefinitions.getSecurityRequestMatchersManagementContextConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.web.server.ManagementContextAutoConfiguration$SameManagementContextConfiguration$EnableSameManagementContextConfiguration", ManagementContextAutoConfiguration__BeanDefinitions.SameManagementContextConfiguration.EnableSameManagementContextConfiguration.getEnableSameManagementContextConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.web.server.ManagementContextAutoConfiguration$SameManagementContextConfiguration", ManagementContextAutoConfiguration__BeanDefinitions.SameManagementContextConfiguration.getSameManagementContextConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("org.springframework.boot.actuate.autoconfigure.web.server.ManagementContextAutoConfiguration", ManagementContextAutoConfiguration__BeanDefinitions.getManagementContextAutoConfigurationBeanDefinition());
    beanFactory.registerBeanDefinition("management.server-org.springframework.boot.actuate.autoconfigure.web.server.ManagementServerProperties", ManagementServerProperties__BeanDefinitions.getManagementServerPropertiesBeanDefinition());
    beanFactory.registerBeanDefinition("mvcHandlerMappingIntrospectorRequestTransformer", HandlerMappingIntrospectorRequestTransformer__BeanDefinitions.getMvcHandlerMappingIntrospectorRequestTransformerBeanDefinition());
    beanFactory.registerBeanDefinition("springSecurityFilterChain", WebMvcSecurityConfiguration__BeanDefinitions.CompositeFilterChainProxy.getSpringSecurityFilterChainBeanDefinition());
    beanFactory.registerBeanDefinition("bookMapper", getBookMapperBeanDefinition());
    beanFactory.registerBeanDefinition("sysGroupMapper", getSysGroupMapperBeanDefinition());
    beanFactory.registerBeanDefinition("sysGroupRoleMapper", getSysGroupRoleMapperBeanDefinition());
    beanFactory.registerBeanDefinition("sysPermissionMapper", getSysPermissionMapperBeanDefinition());
    beanFactory.registerBeanDefinition("sysRoleMapper", getSysRoleMapperBeanDefinition());
    beanFactory.registerBeanDefinition("sysRolePermissionMapper", getSysRolePermissionMapperBeanDefinition());
    beanFactory.registerBeanDefinition("sysUsrGroupMapper", getSysUsrGroupMapperBeanDefinition());
    beanFactory.registerBeanDefinition("sysUsrMapper", getSysUsrMapperBeanDefinition());
    beanFactory.registerBeanDefinition("sysUsrRoleMapper", getSysUsrRoleMapperBeanDefinition());
    beanFactory.registerBeanDefinition("virtualTableColumnsMapper", getVirtualTableColumnsMapperBeanDefinition());
    beanFactory.registerBeanDefinition("virtualTableDataMapper", getVirtualTableDataMapperBeanDefinition());
    beanFactory.registerBeanDefinition("virtualTableIndexMapper", getVirtualTableIndexMapperBeanDefinition());
    beanFactory.registerBeanDefinition("virtualTableMapper", getVirtualTableMapperBeanDefinition());
    beanFactory.registerBeanDefinition("ServiceBean:com.xiacong.provider.TestProvider::", ServiceBean__BeanDefinitions.getTestProviderBeanDefinition());
    beanFactory.registerBeanDefinition("traceIdFilter", FilterRegistrationBean__BeanDefinitions.getTraceIdFilterBeanDefinition());
  }

  /**
   * Register the aliases.
   */
  public void registerAliases(DefaultListableBeanFactory beanFactory) {
  }
}
