package com.kop.daegudot.web;

import com.kop.daegudot.service.mainshcedule.MainScheduleService;
import com.kop.daegudot.web.dto.mainshcedule.MainScheduleRegisterDto;
import com.kop.daegudot.web.dto.mainshcedule.MainScheduleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class MainScheduleController {
    private final MainScheduleService mMainScheduleService;

    //Add Mainschedule
    @PostMapping("/schedule/main/register")
    public Long saveMainSchedule(@RequestBody MainScheduleRegisterDto mainScheduleRegisterDto){
        return mMainScheduleService.saveMainSchedule(mainScheduleRegisterDto);
    }

    //Mainschedule inquiry
    @GetMapping("/schedule/main/{userId}")
    public ArrayList<MainScheduleResponseDto> findByUserId(@PathVariable long userId){
        return mMainScheduleService.findByUserId(userId);
    }
}
