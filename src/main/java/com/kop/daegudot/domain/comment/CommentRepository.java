package com.kop.daegudot.domain.comment;

import com.kop.daegudot.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    ArrayList<Comment> findByRecommendScheduleId(long id);
}
