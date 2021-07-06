package com.kop.daegudot.service.mainshcedule;

import com.kop.daegudot.domain.mainschedule.MainSchedule;
import com.kop.daegudot.domain.mainschedule.MainScheduleRepository;
import com.kop.daegudot.domain.user.User;
import com.kop.daegudot.domain.user.UserRepository;
import com.kop.daegudot.web.dto.mainshcedule.MainScheduleRegisterDto;
import com.kop.daegudot.web.dto.mainshcedule.MainScheduleResponseDto;
import com.kop.daegudot.web.dto.mainshcedule.MainScheduleUpdateDto;
import lombok.RequiredArgsConstructor;
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
                .orElseThrow(()->new IllegalArgumentException("There is no user id = " + mainScheduleRegisterDto.getUserId()));
        return mMainScheduleRepository.save(mainScheduleRegisterDto.toEntity(user)).getId();
    }

    //SELECT * FROM main_schedule WHERE user_id = ?
    public ArrayList<MainScheduleResponseDto> findByUserId(long userId) {
        ArrayList<MainSchedule> mainScheduleList;
        ArrayList<MainScheduleResponseDto> mainScheduleResponseDtoArrayList = new ArrayList<>();

        mainScheduleList = mMainScheduleRepository.findByUserId(userId);
        for(int i=0; i<mainScheduleList.size();i++) {
            MainScheduleResponseDto mainScheduleResponseDto = new MainScheduleResponseDto(mainScheduleList.get(i));
            mainScheduleResponseDtoArrayList.add(mainScheduleResponseDto);
        }
        return mainScheduleResponseDtoArrayList;
    }

    //DELETE
    public Long deleteById(long mainScheduleId) {
        mMainScheduleRepository.deleteById(mainScheduleId);
        return mainScheduleId;
    }

    //UPDATE
    public Long updateById(long mainScheduleId, MainScheduleUpdateDto mainScheduleUpdateDto) {
        MainSchedule mainSchedule = mMainScheduleRepository.findById(mainScheduleId)
                .orElseThrow(()->new IllegalArgumentException("There is no id = " + mainScheduleId));
        mainSchedule.update(LocalDate.parse(mainScheduleUpdateDto.getStartDate(), DateTimeFormatter.ISO_DATE),
                LocalDate.parse(mainScheduleUpdateDto.getEndDate(), DateTimeFormatter.ISO_DATE));
        mMainScheduleRepository.save(mainSchedule);
        return mainScheduleId;
    }
}
