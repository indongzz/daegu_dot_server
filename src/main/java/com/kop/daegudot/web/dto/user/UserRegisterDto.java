package com.kop.daegudot.web.dto.user;

import com.kop.daegudot.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRegisterDto {
    private String email;
    private String nickname;
    private String password;
    private char type;

    @Builder
    public UserRegisterDto(String email, String nickname, String password, char type) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.type = type;
    }

    public User toEntity() {
        return User.builder().email(email).nickname(nickname).password(password).type(type).build();
    }
}
