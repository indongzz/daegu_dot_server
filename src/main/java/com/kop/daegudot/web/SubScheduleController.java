package com.kop.daegudot.web;


import com.kop.daegudot.service.subschedule.SubScheduleService;
import com.kop.daegudot.web.dto.subschedule.SubScheduleRegisterDto;
import com.kop.daegudot.web.dto.subschedule.SubScheduleResponseDto;
import com.kop.daegudot.web.dto.subschedule.SubScheduleUpdateDto;
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
    public Long saveSubSchedule(@RequestBody SubScheduleRegisterDto subScheduleRegisterDto) {
        return mSubScheduleService.saveSubSchedule(subScheduleRegisterDto);
    }

    //Subschedule inquiry
    @GetMapping("/schedule/sub/{mainscheduleId}")
    public ArrayList<SubScheduleResponseDto> findByMainScheduleId(@PathVariable long mainscheduleId) {
        return mSubScheduleService.findByMainScheduleId(mainscheduleId);
    }

    //Delete SubSchedule
    @GetMapping("/schedule/sub/delete/{subscheduleId}")
    public void deleteById(@PathVariable long subscheduleId) {
        mSubScheduleService.deleteById(subscheduleId);
    }

    //Update SubSchedule
    @PutMapping("/schedule/sub/update/{subscheduleId}")
    public Long updateById(@PathVariable long subscheduleId, SubScheduleUpdateDto subScheduleUpdateDto) {
        return mSubScheduleService.updateById(subscheduleId, subScheduleUpdateDto);
    }
}
