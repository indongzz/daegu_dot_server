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
    private long userId;

    public MainScheduleRegisterDto(LocalDate startDate, LocalDate endDate, String title, long userId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.userId = userId;
    }

    public MainSchedule toEntity(User user) {
        return MainSchedule.builder().startDate(startDate).endDate(endDate).title(title).user(user).build();
    }
}
