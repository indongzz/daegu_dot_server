package com.kop.daegudot.web.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateNicknameDto {
    private String nickname;

    public UserUpdateNicknameDto(String nickname){
        this.nickname = nickname;
    }
}
