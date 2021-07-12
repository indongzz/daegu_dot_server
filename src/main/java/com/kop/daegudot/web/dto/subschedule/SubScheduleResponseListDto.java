package com.kop.daegudot.web.dto.subschedule;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class SubScheduleResponseListDto {
    private ArrayList<SubScheduleResponseDto> subScheduleResponseDtoArrayList;
    private Long status;

    public SubScheduleResponseListDto(ArrayList<SubScheduleResponseDto> subScheduleResponseDtoArrayList, long status){
        this.subScheduleResponseDtoArrayList = subScheduleResponseDtoArrayList;
        this.status = status;
    }
}
