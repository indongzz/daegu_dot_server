package com.kop.daegudot.web.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import org.springframework.stereotype.Component;

import java.util.Date;


@RequiredArgsConstructor
@Component
public class JwtTokenProvider {
    //@Value를 통해 값을 가져올 수 있도록 하는 방법을 추천
    private String secretKey = "SOME_SECRET_KEY";
    private long validityInMilliseconds = 1000 * 60 * 60 * 24;

    //JWT 만들기
    public String createToken(String subject){
        Claims claims = Jwts.claims().setSubject(subject);

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
}
