package com.kop.daegudot.web.JWT;

import com.kop.daegudot.domain.user.User;
import com.kop.daegudot.domain.user.UserRepository;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtAuthInterceptor implements HandlerInterceptor {
    private JwtUtil jwtUtil;
    private UserRepository userRepository;

    private String HEADER_TOKEN_KEY = "token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = userRepository.findById(Long.parseLong(request.getHeader("userId")))
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않습니다."));
        String givenToken = request.getHeader(HEADER_TOKEN_KEY);
        verifyToken(givenToken, user.getToken());

        return true;
    }
    private void verifyToken(String givenToken, String membersToken){
        if(!givenToken.equals(membersToken)){
            throw new IllegalArgumentException("토큰 불일치");
        }
        jwtUtil.verifyToken(givenToken);
    }
}
