package com.kop.daegudot.service.subschedule;

import com.kop.daegudot.domain.mainschedule.MainSchedule;
import com.kop.daegudot.domain.mainschedule.MainScheduleRepository;
import com.kop.daegudot.domain.places.Places;
import com.kop.daegudot.domain.places.PlacesRepository;
import com.kop.daegudot.domain.subschedule.SubSchedule;
import com.kop.daegudot.domain.subschedule.SubScheduleRepository;
import com.kop.daegudot.web.dto.subschedule.SubScheduleRegisterDto;
import com.kop.daegudot.web.dto.subschedule.SubScheduleResponseDto;
import com.kop.daegudot.web.dto.subschedule.SubScheduleResponseListDto;
import com.kop.daegudot.web.dto.subschedule.SubScheduleUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class SubScheduleService {
    private final SubScheduleRepository mSubScheduleRepository;
    private final PlacesRepository mPlacesRepository;
    private final MainScheduleRepository mMainScheduleRepository;

    // INSERT to SubSchedule
    @Transactional
    public Long saveSubSchedule(SubScheduleRegisterDto subScheduleRegisterDto){
        Places places = mPlacesRepository.findById(subScheduleRegisterDto.getPlacesId())
                .orElseThrow(()->new IllegalArgumentException("There is no id = " + subScheduleRegisterDto.getPlacesId()));
        MainSchedule mainSchedule = mMainScheduleRepository.findById(subScheduleRegisterDto.getMainScheduleId())
                .orElseThrow(()->new IllegalArgumentException("There is no id = " + subScheduleRegisterDto.getMainScheduleId()));
        mSubScheduleRepository.save(subScheduleRegisterDto.toEntity(places, mainSchedule));
        return 1L;
    }

    //SELECT * FROM sub_schedule WHERE main_schedule_id = ?
    public SubScheduleResponseListDto findByMainScheduleId(long mainScheduleId){
        ArrayList<SubScheduleResponseDto> subScheduleResponseDtoArrayList;
        ArrayList<SubSchedule> subScheduleArrayList;
        SubScheduleResponseListDto subScheduleResponseListDto;

        subScheduleArrayList = mSubScheduleRepository.findByMainScheduleId(mainScheduleId)
                .orElseThrow(() -> new IllegalArgumentException("SubSchedule 조회 오류: " + mainScheduleId));
        subScheduleResponseDtoArrayList = new ArrayList<>();
        if(subScheduleArrayList.size() > 0){
            for(int i=0; i<subScheduleArrayList.size();i++){
                SubScheduleResponseDto subScheduleResponseDto = new SubScheduleResponseDto(subScheduleArrayList.get(i));
                subScheduleResponseDtoArrayList.add(subScheduleResponseDto);
            }
            subScheduleResponseListDto = new SubScheduleResponseListDto(subScheduleResponseDtoArrayList, 1L);
        }
        else
            subScheduleResponseListDto = new SubScheduleResponseListDto(subScheduleResponseDtoArrayList, 0L);

        return subScheduleResponseListDto;
    }

    //DELETE
    public Long deleteById(long subscheduleId){
        mSubScheduleRepository.deleteById(subscheduleId);
        return 1L;
    }

    //UPDATE
    @Transactional
    public Long updateById(long subscheduleId, SubScheduleUpdateDto subScheduleUpdateDto){
        SubSchedule subSchedule = mSubScheduleRepository.findById(subscheduleId)
                .orElseThrow(() -> new IllegalArgumentException("There is no subschedule id = "+subscheduleId));
        Places places = mPlacesRepository.findById(subScheduleUpdateDto.getPlacesId())
                .orElseThrow(()->new IllegalArgumentException("There is no places id = " + subScheduleUpdateDto.getPlacesId()));
        subSchedule.update(LocalDate.parse(subScheduleUpdateDto.getDate(), DateTimeFormatter.ISO_DATE)
                , places);
        mSubScheduleRepository.save(subSchedule);
        return 1L;
    }
}
