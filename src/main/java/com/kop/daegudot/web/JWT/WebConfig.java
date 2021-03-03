package com.kop.daegudot.web.JWT;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
    private String[] INTERCEPTOR_WHITE_LIST = {
            "/user/register",
            "user/login"
    };

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtAuthInterceptor())
                .addPathPatterns("/*")
                .excludePathPatterns("/user/register", "/user/login");
    }
}
