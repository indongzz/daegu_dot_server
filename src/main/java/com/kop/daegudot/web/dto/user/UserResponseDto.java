package com.kop.daegudot.web.dto.user;

import com.kop.daegudot.domain.user.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private long id;
    private String email;
    private String nickname;
    private String password;
    private String token;
    private char type;

    public UserResponseDto(User userEntity) {
        this.id = userEntity.getId();
        this.email = userEntity.getEmail();
        this.nickname = userEntity.getNickname();
        this.password = userEntity.getPassword();
        this.token = userEntity.getToken();
        this.type = userEntity.getType();
    }
}
