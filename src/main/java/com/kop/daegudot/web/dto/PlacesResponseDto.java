package com.kop.daegudot.web.dto;

import com.kop.daegudot.domain.places.Places;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PlacesResponseDto {
    private long id;
    private String address;
    private String attractContents;
    private String attractName;
    private String homepage;
    private String telephone;

    public PlacesResponseDto(Places places){
        this.id = places.getId();
        this.address = places.getAddress();
        this.attractContents = places.getAttractContents();
        this.attractName = places.getAttractName();
        this.homepage = places.getHomepage();
        this.telephone = places.getHomepage();
    }
}
