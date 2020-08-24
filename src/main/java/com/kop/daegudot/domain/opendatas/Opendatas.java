package com.kop.daegudot.domain.opendatas;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Opendatas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long placeId;


    private String address;
    private String attractContents;
    private String attractName;
    private String homepage;
    private String telephone;

    @Builder
    public Opendatas(String address, String attractContents, String attractName, String homepage,
                     String telephone){
        this.address = address;
        this.attractContents = attractContents;
        this.attractName = attractName;
        this.homepage = homepage;
        this.telephone = telephone;
    }

}
