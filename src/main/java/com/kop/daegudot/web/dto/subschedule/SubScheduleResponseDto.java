package com.kop.daegudot.web.dto.subschedule;

import com.kop.daegudot.domain.subschedule.SubSchedule;
import com.kop.daegudot.web.dto.PlacesResponseDto;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class SubScheduleResponseDto {
    private long id;
    private String date;
    private PlacesResponseDto placesResponseDto;

    public SubScheduleResponseDto(SubSchedule subSchedule) {
        this.id = subSchedule.getId();
        this.date = subSchedule.getDate().toString();
        this.placesResponseDto = new PlacesResponseDto(subSchedule.getPlaces());
    }
}
