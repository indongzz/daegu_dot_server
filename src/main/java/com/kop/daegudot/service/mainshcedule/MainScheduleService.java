package com.kop.daegudot.service.mainshcedule;

import com.kop.daegudot.domain.mainschedule.MainSchedule;
import com.kop.daegudot.domain.mainschedule.MainScheduleRepository;
import com.kop.daegudot.web.dto.mainshcedule.MainScheduleRegisterDto;
import com.kop.daegudot.web.dto.mainshcedule.MainScheduleResponseDto;
import com.kop.daegudot.web.dto.mainshcedule.MainScheduleUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@RequiredArgsConstructor
@Service
public class MainScheduleService {
    private final MainScheduleRepository mMainScheduleRepository;

    // INSERT to MainSchedule
    @Transactional
    public Long saveMainSchedule(MainScheduleRegisterDto mainScheduleRegisterDto){
        return mMainScheduleRepository.save(mainScheduleRegisterDto.toEntity()).getId();
    }

    //SELECT * FROM main_schedule WHERE user_id = ?
    public ArrayList<MainScheduleResponseDto> findByUserId(long userId){
        ArrayList<MainSchedule> mainScheduleList;
        ArrayList<MainScheduleResponseDto> mainScheduleResponseDtoArrayList = new ArrayList<>();

        mainScheduleList = mMainScheduleRepository.findByUserId(userId);
        for(int i=0; i<mainScheduleList.size();i++){
            MainScheduleResponseDto mainScheduleResponseDto = new MainScheduleResponseDto(mainScheduleList.get(i));
            mainScheduleResponseDtoArrayList.add(mainScheduleResponseDto);
        }
        return mainScheduleResponseDtoArrayList;
    }

    //DELETE
    public void DeleteById(long mainScheduleId){
        mMainScheduleRepository.deleteById(mainScheduleId);
    }

    //UPDATE
    public Long UpdateById(long mainScheduleId, MainScheduleUpdateDto mainScheduleUpdateDto){
        MainSchedule mainSchedule = mMainScheduleRepository.findById(mainScheduleId);
        mainSchedule.update(mainScheduleUpdateDto.getStartDate(), mainScheduleUpdateDto.getEndDate(),
                mainScheduleUpdateDto.getTitle());

        return mainScheduleId;
    }
}
