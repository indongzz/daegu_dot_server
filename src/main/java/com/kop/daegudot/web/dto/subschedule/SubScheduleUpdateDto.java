package com.kop.daegudot.web.dto.subschedule;

import com.kop.daegudot.domain.places.Places;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
public class SubScheduleUpdateDto {
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Places places;

    public SubScheduleUpdateDto(LocalDate date, LocalTime startTime, LocalTime endTime, Places places){
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.places = places;
    }
}
