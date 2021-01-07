package com.kop.daegudot.web.dto.mainshcedule;

import com.kop.daegudot.domain.mainschedule.MainSchedule;
import com.kop.daegudot.domain.user.User;
import lombok.Getter;
import java.time.LocalDate;

@Getter
public class MainScheduleResponseDto {
    private LocalDate startDate;
    private LocalDate endDate;
    private String title;
    private User user;

    public MainScheduleResponseDto(MainSchedule mainSchedule) {
        this.startDate = mainSchedule.getStartDate();
        this.endDate = mainSchedule.getEndDate();
        this.title = mainSchedule.getTitle();
        this.user = mainSchedule.getUser();
    }
}
