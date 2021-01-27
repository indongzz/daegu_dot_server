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
    private String startTime;
    private String endTime;
    private long placesId;
    private long mainScheduleId;

    public SubScheduleRegisterDto(String date, String startTime, String endTime,
                                  long placesId, long mainScheduleId) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.placesId = placesId;
        this.mainScheduleId = mainScheduleId;
    }

    public SubSchedule toEntity(Places places, MainSchedule mainSchedule) {
        return SubSchedule.builder().date(LocalDate.parse(date, DateTimeFormatter.ISO_DATE))
                .startTime(LocalTime.parse(startTime,DateTimeFormatter.ISO_LOCAL_TIME))
                .endTime(LocalTime.parse(endTime, DateTimeFormatter.ISO_LOCAL_TIME))
                .places(places).mainSchedule(mainSchedule).build();
    }
}
