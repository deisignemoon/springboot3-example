package com.xiacong.validation;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.servlet.ControllerEndpointHandlerMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.*;
import java.util.regex.Pattern;

@Slf4j
@Configuration
public class AuthIgnoreConfig implements InitializingBean {

    @Autowired
    private ApplicationContext applicationContext;

    private static final Pattern PATTERN = Pattern.compile("\\{(.*?)\\}");
    private static final String ASTERISK = "*";

    @Getter
    @Setter
    private List<String> ignoreUrls = new ArrayList<>();

    @Override
    public void afterPropertiesSet() {
        RequestMappingHandlerMapping mapping = applicationContext.getBean(ControllerEndpointHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();
        map.keySet().forEach(mappingInfo -> {
            HandlerMethod handlerMethod = map.get(mappingInfo);
            AuthIgnore method = AnnotationUtils.findAnnotation(handlerMethod.getMethod(), AuthIgnore.class);
            Optional.ofNullable(method)
                    .ifPresent(authIgnore -> mappingInfo
                            .getPatternsCondition()
                            .getPatterns()
                            .forEach(url -> ignoreUrls.add(ReUtil.replaceAll(url, PATTERN, ASTERISK))));
        });
        Optional.ofNullable(applicationContext.getBeansWithAnnotation(AuthIgnore.class))
                .ifPresent(stringObjectMap -> stringObjectMap.values()
                        .forEach(object -> Arrays.asList(object.getClass().getInterfaces()[0].getDeclaredMethods()).forEach(method -> {
                            List<Annotation> annotations = Arrays.asList(method.getAnnotation(RequestMapping.class), method.getAnnotation(PostMapping.class),
                                    method.getAnnotation(GetMapping.class));
                            annotations.forEach(annotation -> {
                                if (ObjectUtil.isNotEmpty(annotation)) {
                                    try {
                                        Field field = Proxy.getInvocationHandler(annotation).getClass().getDeclaredField("memberValues");
                                        field.setAccessible(true);
                                        Map valueMap = (Map) field.get(Proxy.getInvocationHandler(annotation));
                                        String[] string = (String[]) valueMap.get("value");
                                        ignoreUrls.add(StrUtil.SLASH.concat(ReUtil.replaceAll(string[0], PATTERN, ASTERISK)));
                                    } catch (Exception e) {
                                        log.error(e.getMessage(), e);
                                    }
                                }
                            });
                        })));
    }
}
