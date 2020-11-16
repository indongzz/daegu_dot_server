package com.kop.daegudot.service.user;

import com.kop.daegudot.domain.user.User;
import com.kop.daegudot.domain.user.UserRepository;
import com.kop.daegudot.web.JWT.JwtTokenProvider;
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
    private final JwtTokenProvider mJwtTokenProvider;

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

    //Make a JWT when user logins.
    public String createToken(String email, String password){
        User user = mUserRepository.findByEmail(email);
        if(!user.getPassword().equals(password));
        return mJwtTokenProvider.createToken(email);
    }
}
