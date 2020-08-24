package com.kop.daegudot.web;


import com.kop.daegudot.service.opendatas.OpendatasService;
import com.kop.daegudot.web.dto.OpendataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OpenDataController {
    private final OpendatasService mOpendatasService;
    private final OpenDataConnection mOpenDataConnection = new OpenDataConnection();
    private final List<OpendataDto> mIterable = mOpenDataConnection.opendatasHttp();



}
