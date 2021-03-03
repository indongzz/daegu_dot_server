package com.kop.daegudot.web.JWT;

import com.kop.daegudot.domain.user.User;
import com.kop.daegudot.domain.user.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class BearerAuthInterceptor implements HandlerInterceptor {
    private AuthorizationExtractor authorizationExtractor;
    private JwtTokenProvider jwtTokenProvider;
    private UserRepository userRepository;

    public BearerAuthInterceptor(AuthorizationExtractor authorizationExtractor,
                                 JwtTokenProvider jwtTokenProvider){
        this.authorizationExtractor = authorizationExtractor;
        this.jwtTokenProvider = jwtTokenProvider;
    }


    /* 1. request로부터 authExtractor.extract로 토큰 추출
       2. jwtTokenProvider.getSubject로 토큰을 디코딩
       3. request.setAttribute로 요청에 디코딩한 값을 설정
    */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = authorizationExtractor.extract(request, "Bearer");
        if(!StringUtils.isEmpty(token)){
            return true;
        }
        if(!jwtTokenProvider.validateToken(token)){
            throw new IllegalArgumentException("유효하지 않은 토큰");
        }

        String email = jwtTokenProvider.getSubeject(token);
        request.setAttribute("email", email);
        return true;
    }
}
