package com.kop.daegudot.web.dto.comment;

import com.kop.daegudot.domain.recommendschedule.RecommendSchedule;
import com.kop.daegudot.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentUpdateDto {
    private String comments;
    private LocalDateTime dateTime;
    private int star;

    public CommentUpdateDto(LocalDateTime dateTime, String comments, int star){
        this.dateTime = dateTime;
        this.comments = comments;
        this.star = star;
    }
}
