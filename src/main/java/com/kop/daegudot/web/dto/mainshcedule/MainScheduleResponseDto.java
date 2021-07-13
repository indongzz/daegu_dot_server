package com.kop.daegudot.web.dto.mainshcedule;

import com.kop.daegudot.domain.mainschedule.MainSchedule;
import lombok.Getter;

@Getter
public class MainScheduleResponseDto {
    private long id;
    private String startDate;
    private String endDate;

    public MainScheduleResponseDto(MainSchedule mainSchedule) {
        this.id = mainSchedule.getId();
        this.startDate = mainSchedule.getStartDate().toString();
        this.endDate = mainSchedule.getEndDate().toString();
    }
}
