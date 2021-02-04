package com.kop.daegudot.web.dto.subschedule;


import com.kop.daegudot.domain.mainschedule.MainSchedule;
import com.kop.daegudot.domain.places.Places;
import com.kop.daegudot.domain.subschedule.SubSchedule;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@Getter
public class SubScheduleRegisterDto {
    private String date;
    private long placesId;
    private long mainScheduleId;

    public SubScheduleRegisterDto(String date, long placesId, long mainScheduleId) {
        this.date = date;
        this.placesId = placesId;
        this.mainScheduleId = mainScheduleId;
    }

    public SubSchedule toEntity(Places places, MainSchedule mainSchedule) {
        return SubSchedule.builder().date(LocalDate.parse(date, DateTimeFormatter.ISO_DATE))
                .places(places).mainSchedule(mainSchedule).build();
    }
}
