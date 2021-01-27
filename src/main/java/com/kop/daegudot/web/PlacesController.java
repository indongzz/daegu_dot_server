package com.kop.daegudot.web;


import com.kop.daegudot.service.places.PlacesService;
import com.kop.daegudot.web.dto.PlacesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class PlacesController {
    private final PlacesService mPlacesService;

    /* method: GET
    SQL: INSERT */
    @GetMapping("/places")
    public void saveAll(){
        ArrayList<PlacesDto> mPlacesDtoArrayList = new ArrayList<>();
        mPlacesDtoArrayList = new PlacesConnection().opendatasHttp();   //Allocate result of XML parsing to new array list
        mPlacesService.saveAll(mPlacesDtoArrayList);
    }

}
