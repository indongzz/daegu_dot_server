package com.kop.daegudot.web.dto.mainshcedule;

import java.time.LocalDate;
import com.kop.daegudot.domain.mainschedule.MainSchedule;
import com.kop.daegudot.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MainScheduleRegisterDto {
    private LocalDate startDate;
    private LocalDate endDate;
    private String title;
    private User user;

    public MainScheduleRegisterDto(LocalDate startDate, LocalDate endDate, String title, User user) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.user = user;
    }

    public MainSchedule toEntity() {
        return MainSchedule.builder().startDate(startDate).endDate(endDate).title(title).user(user).build();
    }
}
