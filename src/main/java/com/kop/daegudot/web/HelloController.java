package com.kop.daegudot.web;

import com.kop.daegudot.web.dto.HelloResponseDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /* method: GET */
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    /* method: GET */
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
            @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
