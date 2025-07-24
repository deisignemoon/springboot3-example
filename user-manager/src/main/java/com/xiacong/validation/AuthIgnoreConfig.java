package com.xiacong.validation;
import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PathPatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

@Slf4j
@Configuration
public class AuthIgnoreConfig implements InitializingBean {

    @Value("${server.servlet.context-path}")
    private String commonPath;

    @Resource
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    private static final Pattern PATTERN = Pattern.compile("\\{(.*?)\\}");
    private static final String ASTERISK = "*";

    @Getter
    @Setter
    private List<String> ignoreUrls = new ArrayList<>();

    @Override
    public void afterPropertiesSet() {
        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();
        map.keySet().forEach(mappingInfo -> {
            HandlerMethod handlerMethod = map.get(mappingInfo);
            AuthIgnore method = AnnotationUtils.findAnnotation(handlerMethod.getMethod(), AuthIgnore.class);
            if (method != null) {
                PathPatternsRequestCondition condition = mappingInfo.getPathPatternsCondition();
                Set<String> patternValues = condition.getPatternValues();
                if (StringUtils.isNotBlank(commonPath)) {
                    for (String patternValue : patternValues) {
                        patternValue = commonPath + patternValue;
                        patternValues.add(patternValue);
                    }
                }
                ignoreUrls.addAll(patternValues);
            }
        });
    }
}
