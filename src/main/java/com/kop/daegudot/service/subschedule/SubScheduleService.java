package com.kop.daegudot.service.subschedule;

import com.kop.daegudot.domain.mainschedule.MainSchedule;
import com.kop.daegudot.domain.mainschedule.MainScheduleRepository;
import com.kop.daegudot.domain.subschedule.SubSchedule;
import com.kop.daegudot.domain.subschedule.SubScheduleRepository;
import com.kop.daegudot.web.dto.subschedule.SubScheduleRegisterDto;
import com.kop.daegudot.web.dto.subschedule.SubScheduleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SubScheduleService {
    private final SubScheduleRepository mSubScheduleRepository;

    // INSERT to SubSchedule
    @Transactional
    public Long saveSubSchedule(SubScheduleRegisterDto subScheduleRegisterDto){
        return mSubScheduleRepository.save(subScheduleRegisterDto.toEntity()).getId();
    }

    public ArrayList<SubScheduleResponseDto> findByMainScheduleId(long mainScheduleId){
        ArrayList<SubScheduleResponseDto> subScheduleResponseDtoArrayList = new ArrayList<>();
        ArrayList<SubSchedule> subScheduleArrayList = mSubScheduleRepository.findByMainScheduleId(mainScheduleId);

        for(int i=0; i<subScheduleArrayList.size();i++){
            SubScheduleResponseDto subScheduleResponseDto = new SubScheduleResponseDto(subScheduleArrayList.get(i));
            subScheduleResponseDtoArrayList.add(subScheduleResponseDto);
        }

        return subScheduleResponseDtoArrayList;
    }
}
