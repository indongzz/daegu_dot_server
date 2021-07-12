package com.kop.daegudot.service.user;

import com.kop.daegudot.domain.user.User;
import com.kop.daegudot.domain.user.UserRepository;
import com.kop.daegudot.web.JWT.JwtTokenProvider;
import com.kop.daegudot.web.dto.TokenResponseDto;
import com.kop.daegudot.web.dto.user.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository mUserRepository;
    private final JwtTokenProvider mJwtTokenProvider;

    // INSERT
    @Transactional
    public ResponseEntity<TokenResponseDto> save(UserRegisterDto userSaveRequestDto) {
        String token = mJwtTokenProvider.createToken(userSaveRequestDto.getEmail());
        mUserRepository.save(userSaveRequestDto.toEntity(token));

        return ResponseEntity.ok().body(new TokenResponseDto(token, "bearer"));
    }

    // SELECT * FROM USER WHERE email = ?
    public UserResponseDto findByEmail(String email) {
        User user = mUserRepository.findByEmail(email);
        return new UserResponseDto(user);
    }

    // SELECT * FROM USER WHERE nickname = ?
    public UserResponseDto findByNickname(String nickname) {
        System.out.println(nickname);
        User user = mUserRepository.findByNickname(nickname);
        return new UserResponseDto(user);
    }

    // UPDATE NICKNAME
    public Long updateNicknameById(long userId, UserUpdateNicknameDto userUpdateNicknameDto){
        User user = mUserRepository.findById(userId)
                .orElseThrow(()->new IllegalArgumentException("There is no places id = " + userId));
        user.nicknameUpdate(userUpdateNicknameDto.getNickname());
        mUserRepository.save(user);
        return userId;
    }

    //UPDATE PASSWORD
    public Long updatePasswordById(long userId, UserUpdatePasswordDto userUpdatePasswordDto){
        User user = mUserRepository.findById(userId)
                .orElseThrow(()->new IllegalArgumentException("There is no places id = " + userId));
        user.passwordUpdate(userUpdatePasswordDto.getPassword());
        mUserRepository.save(user);
        return userId;
    }

    // SELECT * FROM USER WHERE email = ? AND password = ?
    public UserResponseDto findByEmailAndPassword(UserLoginDto userLoginDto) {
        User user = mUserRepository.findByEmailAndPassword(userLoginDto.getEmail(),
                userLoginDto.getPassword());
        return new UserResponseDto(user);
    }

}
