package com.kop.daegudot.web.JWT;

public interface JwtUtil {
    String createToken();
    void verifyToken(String token);
}
