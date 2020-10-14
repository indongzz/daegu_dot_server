package com.kop.daegudot.web.dto.mainshcedule;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class MainScheduleUpdateDto {
    private LocalDate startDate;
    private LocalDate endDate;
    private String title;

    public MainScheduleUpdateDto(LocalDate startDate, LocalDate endDate, String title) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
    }
}
