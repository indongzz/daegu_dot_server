package com.kop.daegudot.web;

import com.kop.daegudot.domain.mainschedule.MainSchedule;
import com.kop.daegudot.service.mainshcedule.MainScheduleService;
import com.kop.daegudot.web.dto.mainshcedule.MainScheduleRegisterDto;
import com.kop.daegudot.web.dto.mainshcedule.MainScheduleResponseDto;
import com.kop.daegudot.web.dto.mainshcedule.MainScheduleUpdateDto;
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

    /* Delete MainSchedule
    if MainSchedule is deleted, all of the SubSchedule that is related MainSchedule is, too.*/
    @GetMapping("/schedule/main/delete/{mainscheduleId}")
    public void DeleteById(@PathVariable long mainscheduleId){
        mMainScheduleService.DeleteById(mainscheduleId);
    }

    //Update MainSchedule
    @PutMapping("/schedule/main/update/{mainscheduleId}")
    public Long UpdateById(@PathVariable long mainscheduleId, MainScheduleUpdateDto mainScheduleUpdateDto){
        return mMainScheduleService.UpdateById(mainscheduleId, mainScheduleUpdateDto);
    }
}
