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
    public ResponseEntity<String> save(@RequestBody UserRegisterDto userSaveRequestDto) {
        return mUserService.save(userSaveRequestDto);
    }

    //google
    @PostMapping("/user/register/google")
    public ResponseEntity<Long> saveGoogle(@RequestBody UserOauthRegisterDto userOauthRegisterDto){
        Long status = mUserService.saveGoogle(userOauthRegisterDto);
        return ResponseEntity.ok().body(status);
    }

    //Duplicate Check - Email
    @GetMapping("/user/register/email/{email}")
    public UserResponseDto findByEmail(@PathVariable String email) {
        return mUserService.findByEmail(email);
    }

    //토큰으로 닉네임 변경
    @PutMapping("/user/update/nickname")
    public ResponseEntity<Long> updateNickname(HttpServletRequest request, @RequestBody UserUpdateNicknameDto userUpdateNicknameDto){
        String email = (String) request.getAttribute("email");
        UserResponseDto userResponseDto = mUserService.findByEmail((String) request.getAttribute("email"));
        Long userId = mUserService.updateNicknameById(userResponseDto.getId(), userUpdateNicknameDto);
        return ResponseEntity.ok().body(userId);
    }

    //토큰으로 비밀번호 변경
    @PutMapping("/user/update/password")
    public ResponseEntity<Long> updatePassword(HttpServletRequest request, @RequestBody UserUpdatePasswordDto userUpdatePasswordDto){
        String email = (String) request.getAttribute("email");
        UserResponseDto userResponseDto = mUserService.findByEmail((String) request.getAttribute("email"));
        Long userId = mUserService.updatePasswordById(userResponseDto.getId(), userUpdatePasswordDto);
        return ResponseEntity.ok().body(userId);
    }

    //Login
    @PostMapping("/user/login")
    public UserResponseDto findByEmailANDPassword(@RequestBody UserLoginDto userLoginDto) {
        return mUserService.findByEmailAndPassword(userLoginDto);
    }

    //토큰으로 사용자 정보 접근
    @GetMapping("/user/info")
    public ResponseEntity<UserResponseDto> getUserFromToken(HttpServletRequest request){
        String email = (String) request.getAttribute("email");
        UserResponseDto userResponseDto = mUserService.findByEmail((String) request.getAttribute("email"));
        return ResponseEntity.ok().body(userResponseDto);
    }
}
