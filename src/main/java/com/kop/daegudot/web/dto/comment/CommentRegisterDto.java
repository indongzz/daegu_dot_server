package com.kop.daegudot.web.dto.comment;

import com.kop.daegudot.domain.comment.Comment;
import com.kop.daegudot.domain.recommendschedule.RecommendSchedule;
import com.kop.daegudot.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
public class CommentRegisterDto {
    private String comments;
    private long recommendScheduleId;

    public CommentRegisterDto(String comments,long recommendScheduleId){
        this.comments = comments;
        this.recommendScheduleId = recommendScheduleId;
    }

    public Comment toEntity(User user, RecommendSchedule recommendSchedule, LocalDateTime datetime){
        return Comment.builder().comments(comments).user(user).recommendSchedule(recommendSchedule).dateTime(datetime).build();
    }
}
