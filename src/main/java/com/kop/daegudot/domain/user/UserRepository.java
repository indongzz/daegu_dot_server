package com.kop.daegudot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByNickname(String nickname);
    User findByEmailAndPassword(String email, String password);
}
