package com.kop.daegudot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PlacesLocationDto {
    private long id;
    private Float longitude; //경도
    private Float latitude; //위도

    @Builder
    public PlacesLocationDto(long id, Float longitude, Float latitude){
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
