package com.kop.daegudot.web;


import com.kop.daegudot.service.opendatas.OpendatasService;
import com.kop.daegudot.web.dto.OpendataDto;
import com.kop.daegudot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class OpenDataController {
    private final OpendatasService mOpendatasService;

    @GetMapping("/parsing/opendatas")
    public ArrayList<OpendataDto> saveAll(){ return new OpenDataConnection().opendatasHttp();}

}
