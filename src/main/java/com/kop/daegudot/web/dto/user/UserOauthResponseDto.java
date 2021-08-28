package com.kop.daegudot.web.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserOauthResponseDto {
    private long status;
    private String email;
    private String nickname;

    public UserOauthResponseDto(long status, String email, String nickname){
        this.status = status;
        this.email = email;
        this.nickname = nickname;
    }
}
