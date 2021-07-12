package com.kop.daegudot.web.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdatePasswordDto {
    private String password;

    public UserUpdatePasswordDto(String password){
        this.password = password;
    }
}
