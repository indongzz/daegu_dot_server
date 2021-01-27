package com.kop.daegudot.web.dto.comment;

import com.kop.daegudot.domain.comment.Comment;
import com.kop.daegudot.domain.recommendschedule.RecommendSchedule;
import com.kop.daegudot.domain.user.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private LocalDateTime dateTime;
    private String comments;
    private int star;
    private User user;
    private RecommendSchedule recommendSchedule;

    public CommentResponseDto(Comment comment){
        this.dateTime = comment.getDateTime();
        this.comments = comment.getComments();
        this.star = comment.getStar();
        this.user = comment.getUser();
        this.recommendSchedule = comment.getRecommendSchedule();
    }
}
