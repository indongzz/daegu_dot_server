package com.kop.daegudot.web.dto.user;

import lombok.Getter;

@Getter
public class UserResponseStatusDto {
    private UserResponseDto userResponseDto;
    private Long status;

    public UserResponseStatusDto(UserResponseDto userResponseDto, Long status){
        this.userResponseDto = userResponseDto;
        this.status = status;
    }
}
