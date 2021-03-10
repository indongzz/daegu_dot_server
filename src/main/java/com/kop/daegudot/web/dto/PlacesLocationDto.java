package com.kop.daegudot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PlacesLocationDto {
    private long id;
    private String longitude; //경도
    private String latitude; //위도

    @Builder
    public PlacesLocationDto(long id, String longitude, String latitude){
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
