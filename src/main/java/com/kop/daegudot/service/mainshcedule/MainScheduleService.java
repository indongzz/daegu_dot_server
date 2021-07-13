package com.kop.daegudot.service.mainshcedule;

import com.kop.daegudot.domain.mainschedule.MainSchedule;
import com.kop.daegudot.domain.mainschedule.MainScheduleRepository;
import com.kop.daegudot.domain.user.User;
import com.kop.daegudot.domain.user.UserRepository;
import com.kop.daegudot.web.dto.mainshcedule.MainScheduleRegisterDto;
import com.kop.daegudot.web.dto.mainshcedule.MainScheduleResponseDto;
import com.kop.daegudot.web.dto.mainshcedule.MainScheduleResponseListDto;
import com.kop.daegudot.web.dto.mainshcedule.MainScheduleUpdateDto;
import com.kop.daegudot.web.dto.user.UserResponseDto;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RequiredArgsConstructor
@Service
public class MainScheduleService {
    private final MainScheduleRepository mMainScheduleRepository;
    private final UserRepository mUserRepository;

    // INSERT to MainSchedule
    @Transactional
    public Long saveMainSchedule(MainScheduleRegisterDto mainScheduleRegisterDto) {
        User user = mUserRepository.findById(mainScheduleRegisterDto.getUserId())
                .orElseThrow(()->new IllegalArgumentException("UserID 오류: " + mainScheduleRegisterDto.getUserId()));
        mMainScheduleRepository.save(mainScheduleRegisterDto.toEntity(user));
        return 1L;
    }

    @Transactional
    public MainScheduleResponseListDto findByUserId(String email) {
        ArrayList<MainScheduleResponseDto> mainScheduleResponseDtoArrayList;
        ArrayList<MainSchedule> mainScheduleArrayList;
        MainScheduleResponseListDto mainScheduleResponseListDto;

        User user = mUserRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("EMAIL 오류:" + email));

        mainScheduleArrayList = mMainScheduleRepository.findByUserId(user.getId())
                .orElseThrow(() -> new IllegalArgumentException("MainSchedule 조회 오류: " + user.getId()));
        mainScheduleResponseDtoArrayList = new ArrayList<>();
        if(mainScheduleArrayList.size() > 0){
            for(int i=0; i<mainScheduleArrayList.size();i++){
                MainSchedule mainSchedule = mainScheduleArrayList.get(i);
                MainScheduleResponseDto mainScheduleResponseDto = new MainScheduleResponseDto(mainSchedule);
                mainScheduleResponseDtoArrayList.add(mainScheduleResponseDto);
            }
            mainScheduleResponseListDto = new MainScheduleResponseListDto(mainScheduleResponseDtoArrayList, 1L);
        }

        else
            mainScheduleResponseListDto = new MainScheduleResponseListDto(mainScheduleResponseDtoArrayList, 0L);
        return mainScheduleResponseListDto;
    }

    //DELETE
    public Long deleteById(long mainScheduleId) {
        mMainScheduleRepository.deleteById(mainScheduleId);
        return 1L;
    }

    //UPDATE
    @Transactional
    public Long updateById(long mainScheduleId, MainScheduleUpdateDto mainScheduleUpdateDto) {
        MainSchedule mainSchedule = mMainScheduleRepository.findById(mainScheduleId)
                .orElseThrow(()->new IllegalArgumentException("There is no id = " + mainScheduleId));
        mainSchedule.update(LocalDate.parse(mainScheduleUpdateDto.getStartDate(), DateTimeFormatter.ISO_DATE),
                LocalDate.parse(mainScheduleUpdateDto.getEndDate(), DateTimeFormatter.ISO_DATE));
        mMainScheduleRepository.save(mainSchedule);
        return 1L;
    }
}
