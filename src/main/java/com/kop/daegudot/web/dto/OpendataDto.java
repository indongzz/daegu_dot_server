package com.kop.daegudot.web.dto;

import com.kop.daegudot.domain.opendatas.Opendatas;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OpendataDto {
    private String address;
    private String attractContents;
    private String attractName;
    private String homepage;
    private String telephone;

    @Builder
    public OpendataDto(String address, String attractContents, String attractName, String homepage,
                       String telephone){
        this.address = address;
        this.attractContents = attractContents;
        this.attractName = attractName;
        this.homepage = homepage;
        this.telephone = telephone;
    }

    public Opendatas toEntity() { return Opendatas.builder().address(address)
        .attractContents(attractContents).attractName(attractName).homepage(homepage)
            .telephone(telephone).build();
    }
}
