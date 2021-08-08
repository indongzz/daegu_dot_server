package com.kop.daegudot.web.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserOauthRegisterDto {
    private String oauthToken;

    public UserOauthRegisterDto(String oauthToken) {
        this.oauthToken = oauthToken;
    }

}
