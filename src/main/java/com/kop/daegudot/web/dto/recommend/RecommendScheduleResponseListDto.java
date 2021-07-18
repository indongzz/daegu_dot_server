package com.kop.daegudot.web.dto.recommend;

import com.kop.daegudot.web.dto.subschedule.SubScheduleResponseListDto;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class RecommendScheduleResponseListDto {
    private ArrayList<RecommendScheduleResponseDto> recommendScheduleResponseDtoArrayList;
    private Long status;

    public RecommendScheduleResponseListDto(ArrayList<RecommendScheduleResponseDto> recommendScheduleResponseDtoArrayList, long status){
        this.recommendScheduleResponseDtoArrayList = recommendScheduleResponseDtoArrayList;
        this.status = status;
    }
}
