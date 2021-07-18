package com.kop.daegudot.web.dto.recommend;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class HashtagResponseListDto {
    private ArrayList<HashtagResponseDto> hashtagResponseDtoArrayList;
    private Long status;

    public HashtagResponseListDto(ArrayList<HashtagResponseDto> hashtagResponseDtoArrayList, long status){
        this.hashtagResponseDtoArrayList = hashtagResponseDtoArrayList;
        this.status = status;
    }
}
