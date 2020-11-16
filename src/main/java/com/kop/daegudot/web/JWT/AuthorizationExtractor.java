package com.kop.daegudot.web.JWT;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Component
public class AuthorizationExtractor {
    public static final String AUTHORIZATION = "Authorization";
    public static final String ACCESS_TOKEN_TYPE = AuthorizationExtractor.class.getSimpleName()
            + ".ACCESS_TOKEN_TYPE";

    /* 프론트엔드에서 보낸 request JWT에 header의 "Authorization"이라는 key로 담아서 보냄
       request의 header 중에서 Authorization 항목 값을 가진 토큰 자체를 가져옴
     */
    public String extract(HttpServletRequest request, String type){
        Enumeration<String> headers = request.getHeaders(AUTHORIZATION);
        while(headers.hasMoreElements()){
            String value = headers.nextElement();
            if(value.toLowerCase().startsWith(type.toLowerCase())){
                return value.substring(type.length()).trim();
            }
        }

        return Strings.EMPTY;
    }
}
