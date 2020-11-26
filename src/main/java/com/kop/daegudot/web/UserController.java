package com.kop.daegudot.web;

import com.kop.daegudot.domain.user.User;
import com.kop.daegudot.service.user.UserService;
import com.kop.daegudot.web.dto.TokenResponseDto;
import com.kop.daegudot.web.dto.user.UserLoginDto;
import com.kop.daegudot.web.dto.user.UserResponseDto;
import com.kop.daegudot.web.dto.user.UserRegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService mUserService;

    //Register
    @PostMapping("/user/register")
    public Long save(@RequestBody UserRegisterDto userSaveRequestDto) {
        return mUserService.save(userSaveRequestDto);
    }

    //Duplicate Check - Email
    @GetMapping("/user/register/{email}")
    public UserResponseDto findByEmail(@PathVariable String email) {
        return mUserService.findByEmail(email);
    }

    //Duplicate Check - nickname
    @GetMapping("/user/register/{nickname}")
    public UserResponseDto findByNickname(@PathVariable String nickname) {
        return mUserService.findByNickname(nickname);
    }

    //Login
    @PostMapping("user/login2")
    public UserResponseDto findByEmailANDPassword(@RequestBody UserLoginDto userLoginDto) {
        return mUserService.findByEmailAndPassword(userLoginDto);
    }

    //Login test용 -> postmapping으로 변경 필요
    @GetMapping("user/login/test/{email}/{password}")
    public ResponseEntity<TokenResponseDto> login(@PathVariable String email, @PathVariable String password){
        String token = mUserService.createToken(email, password);
        return ResponseEntity.ok().body(new TokenResponseDto(token, "bearer"));
    }

    @GetMapping("user/login")
    public ResponseEntity<UserResponseDto> getUserFromToken(HttpServletRequest request){
        String email = (String) request.getAttribute("email");
        System.out.println("email ::: " + email);
        UserResponseDto userResponseDto = mUserService.findByEmail((String) request.getAttribute("email"));
        return ResponseEntity.ok().body(userResponseDto);
    }
}
