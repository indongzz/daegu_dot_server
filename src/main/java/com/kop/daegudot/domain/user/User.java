package com.kop.daegudot.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;
    @Column(length = 512)
    private String password;
    private String nickname;
    private char type; //G: google, K: kakao, N: normal

    private String token;

    @Builder
    public User (String email, String nickname, String password, String token, char type) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.token = token;
        this.type = type;
    }

    public void nicknameUpdate(String nickname){
        this.nickname = nickname;
    }

    public void passwordUpdate(String password){
        this.password = password;
    }
}
