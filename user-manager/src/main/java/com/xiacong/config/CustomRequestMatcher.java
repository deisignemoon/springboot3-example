package com.xiacong.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class CustomRequestMatcher implements RequestMatcher {
    public String[] URL_WHITELIST = {"", ""};

    @Override
    public boolean matches(HttpServletRequest request) {
        String path = request.getRequestURI();
        for (String url : URL_WHITELIST) {
            if (path.startsWith(url)) {
                return true;
            }
        }
        return false;
    }

    public String[] getURL_WHITELIST() {
        return URL_WHITELIST;
    }

    public void setURL_WHITELIST(String[] URL_WHITELIST) {
        this.URL_WHITELIST = URL_WHITELIST;
    }
}
