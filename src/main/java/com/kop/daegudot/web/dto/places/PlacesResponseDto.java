package com.kop.daegudot.web.dto.places;

import com.kop.daegudot.domain.places.Places;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PlacesResponseDto {
    private long id;
    private String longitude;
    private String latitude;
    private String address;
    private String attractContents;
    private String attractName;
    private String homepage;
    private String telephone;

    public PlacesResponseDto(Places places){
        this.id = places.getId();
        this.longitude = places.getLongitude();
        this.latitude = places.getLatitude();
        this.address = places.getAddress();
        this.attractContents = places.getAttractContents();
        this.attractName = places.getAttractName();
        this.homepage = places.getHomepage();
        this.telephone = places.getHomepage();
    }
}
