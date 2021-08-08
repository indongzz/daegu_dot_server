package com.kop.daegudot.web.dto.user;

import lombok.Getter;

@Getter
public class UserOauthRegisterDto {
    private String oauthToken;

    public UserOauthRegisterDto(String oauthToken) {
        this.oauthToken = oauthToken;
    }

}
