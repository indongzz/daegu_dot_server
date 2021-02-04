package com.kop.daegudot.web.dto.subschedule;

import com.kop.daegudot.domain.places.Places;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
public class SubScheduleUpdateDto {
    private String date;
    private long placesId;

    public SubScheduleUpdateDto(String date, String startTime, String endTime, long placesId) {
        this.date = date;
        this.placesId = placesId;
    }
}
