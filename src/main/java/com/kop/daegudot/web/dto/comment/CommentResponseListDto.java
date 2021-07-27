package com.kop.daegudot.web.dto.comment;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class CommentResponseListDto {
    private Long status;
    private ArrayList<CommentResponseDto> commentResponseDtoArrayList;

    public CommentResponseListDto(ArrayList<CommentResponseDto> commentResponseDtoArrayList, long status){
        this.status = status;
        this.commentResponseDtoArrayList = commentResponseDtoArrayList;
    }
}
