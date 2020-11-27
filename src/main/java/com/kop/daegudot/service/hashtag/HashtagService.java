package com.kop.daegudot.service.hashtag;

import com.kop.daegudot.domain.hashtag.Hashtag;
import com.kop.daegudot.domain.hashtag.HashtagRepository;
import com.kop.daegudot.domain.recommendschedule.RecommendSchedule;
import com.kop.daegudot.domain.recommendschedule.RecommendScheduleRepository;
import com.kop.daegudot.domain.schedulehashtag.ScheduleHashtagRepository;
import com.kop.daegudot.web.dto.hashtag.HashtagResponseDto;
import com.kop.daegudot.web.dto.hashtag.RecommendScheduleRegisterDto;
import com.kop.daegudot.web.dto.hashtag.RecommendScheduleUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HashtagService {
    private final ScheduleHashtagRepository mScheduleHashtagRepository;
    private final RecommendScheduleRepository mRecommendScheduleRepository;
    private final HashtagRepository mHashtagRepository;

    //INSERT TO
    @Transactional
    public long saveRecommendSchedule(RecommendScheduleRegisterDto recommendScheduleRegisterDto){
        return mRecommendScheduleRepository.save(recommendScheduleRegisterDto.toEntity()).getId();
    }

    //UPDATE
    public Long updateRecommendSchedule(long recommendScheduleId, RecommendScheduleUpdateDto recommendScheduleUpdateDto){
        RecommendSchedule recommendSchedule = mRecommendScheduleRepository.findById(recommendScheduleId);
        recommendSchedule.update(recommendScheduleUpdateDto.getMainSchedule(), recommendSchedule.getTitle(), recommendSchedule.getContent());
        return recommendScheduleId;
    }

    //DELETE
    public void deleteRecommendSchedule(long id){
        mRecommendScheduleRepository.deleteById(id);
    }

    //SELECT * FROM Hashtag
    public ArrayList<HashtagResponseDto> findAll(){
        ArrayList<Hashtag> hashtagArrayList;
        ArrayList<HashtagResponseDto> hashtagResponseDtoArrayList = new ArrayList<>();

        hashtagArrayList = (ArrayList<Hashtag>) mHashtagRepository.findAll();
        for(int i=0; i<hashtagArrayList.size();i++){
            HashtagResponseDto hashtagResponseDto = new HashtagResponseDto(hashtagArrayList.get(i));
            hashtagResponseDtoArrayList.add(hashtagResponseDto);
        }
        return hashtagResponseDtoArrayList;
    }
}
