package com.kop.daegudot.web;

import com.kop.daegudot.domain.user.User;
import com.kop.daegudot.service.user.UserService;
import com.kop.daegudot.web.dto.TokenResponseDto;
import com.kop.daegudot.web.dto.user.UserLoginDto;
import com.kop.daegudot.web.dto.user.UserResponseDto;
import com.kop.daegudot.web.dto.user.UserRegisterDto;
import com.kop.daegudot.web.dto.user.UserUpdateDto;
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
    @PutMapping("/user/update/{userId}")
    public Long updateById(@PathVariable long userId, @RequestBody UserUpdateDto userUpdateDto){
        return mUserService.updateById(userId, userUpdateDto);
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
