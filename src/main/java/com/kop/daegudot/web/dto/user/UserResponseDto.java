package com.kop.daegudot.web.dto.user;

import com.kop.daegudot.domain.user.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private String email;
    private String nickname;
    private String password;
    private char type;

    public UserResponseDto(User userEntity) {
        this.email = userEntity.getEmail();
        this.nickname = userEntity.getNickname();
        this.password = userEntity.getPassword();
        this.type = userEntity.getType();
    }
}
