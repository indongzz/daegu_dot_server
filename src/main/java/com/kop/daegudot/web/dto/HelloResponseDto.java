package com.kop.daegudot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // Getter method auto make
@RequiredArgsConstructor // base constructor
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
