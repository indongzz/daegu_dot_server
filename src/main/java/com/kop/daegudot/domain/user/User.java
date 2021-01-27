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

    @Column(length = 512)
    private String password;

    private String email;
    private String nickname;
    private char type; //G: google, K: kakao, N: normal

    @Builder
    public User (String email, String nickname, String password, char type) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.type = type;
    }

    public void update(String nickname, String password){
        this.nickname = nickname;
        this.password = password;
    }
}
