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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.Collections;


@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository mUserRepository;
    private final JwtTokenProvider mJwtTokenProvider;

    @Value("${custom.oauth2.google.client-id}")
    private String GoogleOauthClientId;

    // INSERT
    @Transactional
    public String save(UserRegisterDto userSaveRequestDto) {
        String token = mJwtTokenProvider.createToken(userSaveRequestDto.getEmail());
        mUserRepository.save(userSaveRequestDto.toEntity(token));

        return token;
    }

    public Long saveGoogle(UserOauthRegisterDto userOauthRegisterDto){
        HttpTransport transport = new NetHttpTransport();
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();

        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                .setAudience(Collections.singletonList(GoogleOauthClientId))
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

    //kakao
    public Long saveKakao(UserOauthRegisterDto userOauthRegisterDto) {
        try{
            URL url = new URL("https://kapi.kakao.com/v1/user/access_token_info");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestProperty("Authorization", "Bearer " + userOauthRegisterDto.getOauthToken().trim());
            int responseCode = conn.getResponseCode();

            if(responseCode > 0) return 1L;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0L;
    }

    // SELECT * FROM USER WHERE email = ?
    public UserResponseStatusDto findByEmail(String email) {
        UserResponseStatusDto userResponseStatusDto;
        User user = mUserRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User 조회 오류: " + email));
        UserResponseDto userResponseDto = new UserResponseDto(user);

        if(userResponseDto != null) userResponseStatusDto = new UserResponseStatusDto(userResponseDto, 1L);
        else userResponseStatusDto = new UserResponseStatusDto(userResponseDto, 0L);
        return userResponseStatusDto;
    }

    // SELECT * FROM USER WHERE nickname = ?
    public UserResponseStatusDto findByNickname(String nickname) {
        UserResponseStatusDto userResponseStatusDto;
        User user = mUserRepository.findByNickname(nickname)
                .orElseThrow(() -> new IllegalArgumentException("User 조회 오류: " + nickname));
        UserResponseDto userResponseDto = new UserResponseDto(user);

        if(userResponseDto != null) userResponseStatusDto = new UserResponseStatusDto(userResponseDto, 1L);
        else userResponseStatusDto = new UserResponseStatusDto(userResponseDto, 0L);
        return userResponseStatusDto;
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
