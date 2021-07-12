package com.kop.daegudot.web.dto.mainshcedule;

import com.kop.daegudot.domain.mainschedule.MainSchedule;
import com.kop.daegudot.domain.user.User;
import lombok.Getter;
import java.time.LocalDate;

@Getter
public class MainScheduleResponseDto {
    private long id;
    private LocalDate startDate;
    private LocalDate endDate;

    public MainScheduleResponseDto(MainSchedule mainSchedule) {
        this.id = mainSchedule.getId();
        this.startDate = mainSchedule.getStartDate();
        this.endDate = mainSchedule.getEndDate();
    }
}
