package com.kop.daegudot.web;

import com.kop.daegudot.domain.user.User;
import com.kop.daegudot.service.user.UserService;
import com.kop.daegudot.web.dto.TokenResponseDto;
import com.kop.daegudot.web.dto.user.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService mUserService;

    //Register
    //TODO: 회원가입 -> 디비 저장, 로그인 -> 토큰 주기
    @PostMapping("/user/register")
    public ResponseEntity<TokenResponseDto> save(@RequestBody UserRegisterDto userSaveRequestDto) {
        return mUserService.save(userSaveRequestDto);
    }

    //Duplicate Check - Email
    @GetMapping("/user/register/email/{email}")
    public UserResponseDto findByEmail(@PathVariable String email) {
        return mUserService.findByEmail(email);
    }

    //Duplicate Check - nickname
    @GetMapping("/user/register/nickname/{nickname}")
    public UserResponseDto findByNickname(@PathVariable String nickname) {
        return mUserService.findByNickname(nickname);
    }

    //TODO:닉네임 변경 및 비밀번호 변경 기능 추가
    @PutMapping("/user/update/nickname/{userId}")
    public Long updateNicknameById(@PathVariable long userId, @RequestBody UserUpdateNicknameDto userUpdateNicknameDto){
        return mUserService.updateNicknameById(userId, userUpdateNicknameDto);
    }

    @PutMapping("/user/update/password/{userId}")
    public Long updatePasswordById(@PathVariable long userId, @RequestBody UserUpdatePasswordDto userUpdatePasswordDto){
        return mUserService.updatePasswordById(userId, userUpdatePasswordDto);
    }

    //Login
    @PostMapping("/user/login")
    public UserResponseDto findByEmailANDPassword(@RequestBody UserLoginDto userLoginDto) {
        return mUserService.findByEmailAndPassword(userLoginDto);
    }

    //헤더 테스트
    @GetMapping("/user/info")
    public ResponseEntity<UserResponseDto> getUserFromToken(HttpServletRequest request){
        String email = (String) request.getAttribute("email");
        UserResponseDto userResponseDto = mUserService.findByEmail((String) request.getAttribute("email"));
        return ResponseEntity.ok().body(userResponseDto);
    }
}
