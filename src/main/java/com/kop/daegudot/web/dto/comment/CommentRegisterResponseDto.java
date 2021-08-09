package com.kop.daegudot.web.dto.comment;

import com.kop.daegudot.domain.comment.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentRegisterResponseDto {
    private long id;
    private String localTime;

    public CommentRegisterResponseDto(long id, LocalDateTime localTime){
        this.id = id;
        this.localTime = localTime.toString();
    }
}
