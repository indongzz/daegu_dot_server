package com.kop.daegudot.service.subschedule;

import com.kop.daegudot.domain.mainschedule.MainSchedule;
import com.kop.daegudot.domain.mainschedule.MainScheduleRepository;
import com.kop.daegudot.domain.subschedule.SubSchedule;
import com.kop.daegudot.domain.subschedule.SubScheduleRepository;
import com.kop.daegudot.web.dto.subschedule.SubScheduleRegisterDto;
import com.kop.daegudot.web.dto.subschedule.SubScheduleResponseDto;
import com.kop.daegudot.web.dto.subschedule.SubScheduleUpdateDto;
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

    //SELECT * FROM sub_schedule WHERE main_schedule_id = ?
    public ArrayList<SubScheduleResponseDto> findByMainScheduleId(long mainScheduleId){
        ArrayList<SubScheduleResponseDto> subScheduleResponseDtoArrayList = new ArrayList<>();
        ArrayList<SubSchedule> subScheduleArrayList = mSubScheduleRepository.findByMainScheduleId(mainScheduleId);

        for(int i=0; i<subScheduleArrayList.size();i++){
            SubScheduleResponseDto subScheduleResponseDto = new SubScheduleResponseDto(subScheduleArrayList.get(i));
            subScheduleResponseDtoArrayList.add(subScheduleResponseDto);
        }

        return subScheduleResponseDtoArrayList;
    }

    //DELETE
    public void deleteById(long subscheduleId){
        mSubScheduleRepository.deleteById(subscheduleId);
    }

    //UPDATE
    public Long updateById(long subscheduleId, SubScheduleUpdateDto subScheduleUpdateDto){
        SubSchedule subSchedule = mSubScheduleRepository.findById(subscheduleId);
        subSchedule.update(subScheduleUpdateDto.getDate(), subScheduleUpdateDto.getStartTime(),
                subScheduleUpdateDto.getEndTime(), subScheduleUpdateDto.getPlaces());
        return subscheduleId;
    }
}
