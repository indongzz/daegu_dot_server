package com.kop.daegudot.web.dto.mainshcedule;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class MainScheduleUpdateDto {
    private String startDate;
    private String endDate;
    private String title;

    public MainScheduleUpdateDto(String startDate, String endDate, String title) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
    }
}
