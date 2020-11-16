package com.kop.daegudot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TokenResponseDto {
    private String token;
    private String tokenType;

    public TokenResponseDto(String token, String tokenType){
        this.token = token;
        this.tokenType = tokenType;
    }
}
