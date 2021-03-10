package com.kop.daegudot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PlacesLocationDto {
    private long id;
    private float longitude; //경도
    private float latitude; //위도

    @Builder
    public PlacesLocationDto(long id, float longitude, float latitude){
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
