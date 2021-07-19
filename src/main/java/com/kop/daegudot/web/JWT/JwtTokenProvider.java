package com.kop.daegudot.web.JWT;

import com.kop.daegudot.domain.user.User;
import com.kop.daegudot.web.dto.user.UserRegisterDto;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import org.springframework.stereotype.Component;

import java.util.Date;


@RequiredArgsConstructor
@Component
public class JwtTokenProvider {
    //@Value를 통해 값을 가져올 수 있도록 하는 방법을 추천
    private String secretKey = "SOME_SECRET_KEY";
    //private long validityInMilliseconds = 1000 * 60 * 60 * 24;

    //JWT 만들기
    public String createToken(String subject){
        Claims claims = Jwts.claims()
                .setSubject(subject);

        Date now = new Date();
        //Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                //.setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    //JWT에서 값 추출하기
    public String getSubeject(String token){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    //JWT 유효성 확인
    public boolean validateToken(String token){
        try{
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            if(claimsJws.getBody().getExpiration().before(new Date())) return false;
            return true;
        } catch (JwtException | IllegalArgumentException e){
            return false;
        }
    }
}
