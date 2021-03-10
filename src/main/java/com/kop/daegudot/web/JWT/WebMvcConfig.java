package com.kop.daegudot.web.JWT;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private final BearerAuthInterceptor bearerAuthInterceptor;

    public WebMvcConfig(BearerAuthInterceptor bearerAuthInterceptor){
        this.bearerAuthInterceptor = bearerAuthInterceptor;
    }

    /* controller에 도달하기 전 Interceptor의 요청으로 request 가로챔
    어떤 request를 가로챌지 Interceptor에 등록
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(bearerAuthInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/places", "/places/list", "/places/location", "/user/login", "/user/register/email", "/user/register/nickname", "/user/register");
    }
}
