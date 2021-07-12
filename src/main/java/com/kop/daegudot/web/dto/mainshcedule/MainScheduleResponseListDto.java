package com.kop.daegudot.web.dto.mainshcedule;

import com.kop.daegudot.domain.mainschedule.MainSchedule;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class MainScheduleResponseListDto {
    private ArrayList<MainScheduleResponseDto> mainScheduleResponseDtoArrayList;
    private Long status;

    public MainScheduleResponseListDto(ArrayList<MainScheduleResponseDto> mainScheduleResponseDtoArrayList, Long status){
        this.mainScheduleResponseDtoArrayList = mainScheduleResponseDtoArrayList;
        this.status = status;
    }
}
