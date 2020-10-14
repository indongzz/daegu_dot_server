package com.kop.daegudot.web.dto.subschedule;


import com.kop.daegudot.domain.mainschedule.MainSchedule;
import com.kop.daegudot.domain.places.Places;
import com.kop.daegudot.domain.subschedule.SubSchedule;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Getter
public class SubScheduleRegisterDto {
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Places places;
    private MainSchedule mainSchedule;

    public SubScheduleRegisterDto(LocalDate date, LocalTime startTime, LocalTime endTime,
                                  Places places, MainSchedule mainSchedule) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.places = places;
        this.mainSchedule = mainSchedule;
    }

    public SubSchedule toEntity() {
        return SubSchedule.builder().date(date).startTime(startTime).endTime(endTime).
                places(places).mainSchedule(mainSchedule).build();
    }
}
