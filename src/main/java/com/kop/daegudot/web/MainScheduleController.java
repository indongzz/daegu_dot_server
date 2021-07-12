package com.kop.daegudot.web;

import com.kop.daegudot.domain.mainschedule.MainSchedule;
import com.kop.daegudot.service.mainshcedule.MainScheduleService;
import com.kop.daegudot.web.dto.mainshcedule.MainScheduleRegisterDto;
import com.kop.daegudot.web.dto.mainshcedule.MainScheduleResponseDto;
import com.kop.daegudot.web.dto.mainshcedule.MainScheduleResponseListDto;
import com.kop.daegudot.web.dto.mainshcedule.MainScheduleUpdateDto;
import com.kop.daegudot.web.dto.user.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class MainScheduleController {
    private final MainScheduleService mMainScheduleService;

    //Add Mainschedule
    @PostMapping("/schedule/main/register")
    public Long saveMainSchedule(@RequestBody MainScheduleRegisterDto mainScheduleRegisterDto) {
        return mMainScheduleService.saveMainSchedule(mainScheduleRegisterDto);
    }

    //Mainschedule inquiry
    @GetMapping("/schedule/main")
    public ResponseEntity<MainScheduleResponseListDto> findByUserId(HttpServletRequest request) {
        String email = (String) request.getAttribute("email");
        return ResponseEntity.ok().body(mMainScheduleService.findByUserId(email));
    }

    /* Delete MainSchedule
    if MainSchedule is deleted, all of the SubSchedule that is related MainSchedule is, too.*/
    @DeleteMapping("/schedule/main/delete/{mainscheduleId}")
    public Long deleteById(@PathVariable long mainscheduleId) {
        return mMainScheduleService.deleteById(mainscheduleId);
    }

    //Update MainSchedule
    @PutMapping(value = "/schedule/main/update/{mainscheduleId}")
    public Long updateById(@PathVariable long mainscheduleId, @RequestBody MainScheduleUpdateDto mainScheduleUpdateDto) {
        return mMainScheduleService.updateById(mainscheduleId, mainScheduleUpdateDto);
    }
}
