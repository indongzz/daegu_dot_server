package com.kop.daegudot.web.JWT;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class JwtUtilImpl implements JwtUtil{
    private String TEST_SIGN_KEY = "TESTKEY";
    private Date EXPIRED_TIME = new Date(System.currentTimeMillis() + 1000 * 10);
    private String ISSUER = "OHG";

    @Override
    public String createToken() {
        return JWT.create()
                .withIssuer(ISSUER)
                .withExpiresAt(EXPIRED_TIME)
                .sign(Algorithm.HMAC256(TEST_SIGN_KEY));
    }

    @Override
    public void verifyToken(String token) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(TEST_SIGN_KEY))
                .withIssuer(ISSUER)
                .build();

        jwtVerifier.verify(token);
    }
}
