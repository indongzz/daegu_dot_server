package com.kop.daegudot.web.dto.recommend;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class RecommendScheduleResponseWithUserListDto {
    private ArrayList<RecommendScheduleResponseWithUserDto> recommendScheduleResponseDtoArrayList;
    private Long status;

    public RecommendScheduleResponseWithUserListDto(ArrayList<RecommendScheduleResponseWithUserDto> recommendScheduleResponseDtoArrayList, long status){
        this.recommendScheduleResponseDtoArrayList = recommendScheduleResponseDtoArrayList;
        this.status = status;
    }
}
