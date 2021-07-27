package com.kop.daegudot.web.dto.comment;

import com.kop.daegudot.domain.comment.Comment;
import com.kop.daegudot.domain.recommendschedule.RecommendSchedule;
import com.kop.daegudot.domain.user.User;
import com.kop.daegudot.web.dto.recommend.RecommendScheduleResponseDto;
import com.kop.daegudot.web.dto.user.UserResponseDto;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private long id;
    private String dateTime;
    private String comments;
    private UserResponseDto userResponseDto;
    private RecommendScheduleResponseDto recommendScheduleResponseDto;

    public CommentResponseDto(Comment comment){
        this.id = comment.getId();
        this.dateTime = comment.getDateTime().toString();
        this.comments = comment.getComments();
        this.userResponseDto = new UserResponseDto(comment.getUser());
        this.recommendScheduleResponseDto = new RecommendScheduleResponseDto(comment.getRecommendSchedule());
    }
}
