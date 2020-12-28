package com.kop.daegudot.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    ArrayList<Comment> findByRecommendScheduleId(long id);
}
