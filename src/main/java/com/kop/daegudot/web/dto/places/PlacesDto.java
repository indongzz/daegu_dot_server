package com.kop.daegudot.web.dto.places;

import com.kop.daegudot.domain.places.Places;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PlacesDto {
    private String address;
    private String attractContents;
    private String attractName;
    private String homepage;
    private String telephone;

    @Builder
    public PlacesDto(String address, String attractContents, String attractName, String homepage,
                     String telephone){
        this.address = address;
        this.attractContents = attractContents;
        this.attractName = attractName;
        this.homepage = homepage;
        this.telephone = telephone;
    }

    public Places toEntity() {
        return Places.builder().address(address) .attractContents(attractContents)
                .attractName(attractName).homepage(homepage).telephone(telephone).build();
    }
}
