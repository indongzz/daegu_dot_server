package com.kop.daegudot.domain.places;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Places {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long placeId;


    @Column
    private String address;
    @Column (length = 5000)
    private String attractContents;
    @Column
    private String attractName;
    @Column
    private String homepage;
    @Column
    private String telephone;

    @Builder
    public Places(String address, String attractContents, String attractName, String homepage,
                  String telephone) {
        this.address = address;
        this.attractContents = attractContents;
        this.attractName = attractName;
        this.homepage = homepage;
        this.telephone = telephone;
    }

}
