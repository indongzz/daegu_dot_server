package com.kop.daegudot.web.dto.places;

import com.kop.daegudot.domain.places.Places;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PlaceRegsterDto {
    public String longitude;
    public String latitude;
    public String address;
    public String attractName;
    public String category;
    public String telephone;

    public PlaceRegsterDto(String longitude, String latitude, String address, String attractName, String category,
                           String telephone){
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.attractName = attractName;
        this.category = category;
        this.telephone = telephone;
    }

    public Places toEntity(){
        return Places.builder().address(address).attractName(attractName).telephone(telephone).longitude(longitude)
                .latitude(latitude).category(category).build();
    }
}
