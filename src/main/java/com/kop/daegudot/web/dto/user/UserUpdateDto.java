package com.kop.daegudot.web.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateDto {
    private String password;
    private String nickname;

    public UserUpdateDto(String password, String nickname){
        this.password = password;
        this.nickname = nickname;
    }
}
