package com.kop.daegudot.service.user;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.kop.daegudot.domain.user.User;
import com.kop.daegudot.domain.user.UserRepository;
import com.kop.daegudot.web.JWT.JwtTokenProvider;
import com.kop.daegudot.web.dto.user.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;


@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository mUserRepository;
    private final JwtTokenProvider mJwtTokenProvider;

    // INSERT
    @Transactional
    public ResponseEntity<String> save(UserRegisterDto userSaveRequestDto) {
        String token = mJwtTokenProvider.createToken(userSaveRequestDto.getEmail());
        mUserRepository.save(userSaveRequestDto.toEntity(token));

        return ResponseEntity.ok().body(token);
    }

    @Transactional
    public Long saveGoogle(UserOauthRegisterDto userOauthRegisterDto){
        HttpTransport transport = new NetHttpTransport();
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();

        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                .setAudience(Collections.singletonList(OauthClientID.GoogleOauthClientId))
                .build();

        try {
            GoogleIdToken idToken = verifier.verify(userOauthRegisterDto.getOauthToken());
            return 1L;
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0L;
    }

    // SELECT * FROM USER WHERE email = ?
    public UserResponseDto findByEmail(String email) {
        User user = mUserRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User 조회 오류: " + email));
        return new UserResponseDto(user);
    }

    // SELECT * FROM USER WHERE nickname = ?
    public UserResponseDto findByNickname(String nickname) {
        System.out.println(nickname);
        User user = mUserRepository.findByNickname(nickname)
                .orElseThrow(() -> new IllegalArgumentException("User 조회 오류: " + nickname));
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
        User user = mUserRepository.findByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword())
                .orElseThrow(() -> new IllegalArgumentException("User 조회 오류: " + userLoginDto.getEmail() + " " + userLoginDto.getPassword()));
        return new UserResponseDto(user);
    }

}
