package com.kop.daegudot.web.dto.mainshcedule;

import com.kop.daegudot.domain.mainschedule.MainSchedule;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class MainScheduleResponseListDto {
    private ArrayList<MainSchedule> mainScheduleArrayList;
    private Long status;

    public MainScheduleResponseListDto(ArrayList<MainSchedule> mainScheduleArrayList, Long status){
        this.mainScheduleArrayList = mainScheduleArrayList;
        this.status = status;
    }
}
