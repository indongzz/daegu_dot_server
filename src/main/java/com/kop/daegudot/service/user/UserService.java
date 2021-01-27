package com.kop.daegudot.service.user;

import com.kop.daegudot.domain.user.User;
import com.kop.daegudot.domain.user.UserRepository;
import com.kop.daegudot.web.dto.user.UserLoginDto;
import com.kop.daegudot.web.dto.user.UserResponseDto;
import com.kop.daegudot.web.dto.user.UserRegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository mUserRepository;

    // INSERT
    @Transactional
    public long save(UserRegisterDto userSaveRequestDto) {
        return mUserRepository.save(userSaveRequestDto.toEntity()).getId();
    }

    // SELECT * FROM USER WHERE email = ?
    public UserResponseDto findByEmail(String email) {
        User userEntity = mUserRepository.findByEmail(email);
        return new UserResponseDto(userEntity);
    }

    // SELECT * FROM USER WHERE nickname = ?
    public UserResponseDto findByNickname(String nickname) {
        User userEntity = mUserRepository.findByNickname(nickname);
        return new UserResponseDto(userEntity);
    }

    // SELECT * FROM USER WHERE email = ? AND password = ?
    public UserResponseDto findByEmailAndPassword(UserLoginDto userLoginDto) {
        User userEntity = mUserRepository.findByEmailAndPassword(userLoginDto.getEmail(),
                userLoginDto.getPassword());
        return new UserResponseDto(userEntity);
    }
}
