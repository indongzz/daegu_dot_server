package com.kop.daegudot.web.dto.mainshcedule;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.kop.daegudot.domain.mainschedule.MainSchedule;
import com.kop.daegudot.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MainScheduleRegisterDto {
    private String startDate;
    private String endDate;
    private String title;
    private long userId;

    public MainScheduleRegisterDto(String startDate, String endDate, String title, long userId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.userId = userId;
    }

    public MainSchedule toEntity(User user) {
        return MainSchedule.builder().startDate(LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE))
                .endDate(LocalDate.parse(endDate, DateTimeFormatter.ISO_DATE))
                .title(title).user(user).build();
    }
}
