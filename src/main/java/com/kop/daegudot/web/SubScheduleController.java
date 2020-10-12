package com.kop.daegudot.web;


import com.kop.daegudot.service.subschedule.SubScheduleService;
import com.kop.daegudot.web.dto.subschedule.SubScheduleRegisterDto;
import com.kop.daegudot.web.dto.subschedule.SubScheduleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class SubScheduleController {
    private final SubScheduleService mSubScheduleService;

    //Add Subschedule
    @PostMapping("/schedule/sub/register")
    public Long saveSubSchedule(@RequestBody SubScheduleRegisterDto subScheduleRegisterDto){
        return mSubScheduleService.saveSubSchedule(subScheduleRegisterDto);
    }

    //Subschedule inquiry
    @GetMapping("/schedule/sub/{mainScheduleId}")
    public ArrayList<SubScheduleResponseDto> findByMainScheduleId(@PathVariable long mainScheduleId){
        return mSubScheduleService.findByMainScheduleId(mainScheduleId);
    }
}
