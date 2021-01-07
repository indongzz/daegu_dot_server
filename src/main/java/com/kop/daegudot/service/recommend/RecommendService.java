package com.kop.daegudot.service.recommend;

import com.kop.daegudot.domain.hashtag.Hashtag;
import com.kop.daegudot.domain.hashtag.HashtagRepository;
import com.kop.daegudot.domain.recommendschedule.RecommendSchedule;
import com.kop.daegudot.domain.recommendschedule.RecommendScheduleRepository;
import com.kop.daegudot.web.dto.recommend.HashtagResponseDto;
import com.kop.daegudot.web.dto.recommend.RecommendScheduleRegisterDto;
import com.kop.daegudot.web.dto.recommend.RecommendScheduleResponseDto;
import com.kop.daegudot.web.dto.recommend.RecommendScheduleUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class RecommendService {
    private final RecommendScheduleRepository mRecommendScheduleRepository;
    private final HashtagRepository mHashtagRepository;

    //INSERT TO
    @Transactional
    public long saveRecommendSchedule(RecommendScheduleRegisterDto recommendScheduleRegisterDto){
        return mRecommendScheduleRepository.save(recommendScheduleRegisterDto.toEntity()).getId();
    }

    //SELECT * FROM RecommendSchedule
    public ArrayList<RecommendScheduleResponseDto> findAllRecommendSchedule(){
        ArrayList<RecommendSchedule> recommendScheduleArrayList;
        ArrayList<RecommendScheduleResponseDto> recommendScheduleResponseDtoArrayList = new ArrayList<>();

        recommendScheduleArrayList = (ArrayList<RecommendSchedule>) mRecommendScheduleRepository.findAll();
        for(int i=0; i<recommendScheduleArrayList.size();i++){
            RecommendScheduleResponseDto recommendScheduleResponseDto = new RecommendScheduleResponseDto(recommendScheduleArrayList.get(i));
            recommendScheduleResponseDtoArrayList.add(recommendScheduleResponseDto);
        }
        return recommendScheduleResponseDtoArrayList;
    }

    //UPDATE
    public Long updateRecommendSchedule(long recommendScheduleId, RecommendScheduleUpdateDto recommendScheduleUpdateDto){
        RecommendSchedule recommendSchedule = mRecommendScheduleRepository.findById(recommendScheduleId)
                .orElseThrow(()->new IllegalArgumentException("There is no id = "+recommendScheduleId));
        recommendSchedule.update(recommendScheduleUpdateDto.getMainSchedule(), recommendScheduleUpdateDto.getTitle(),
                recommendScheduleUpdateDto.getContent(), recommendScheduleUpdateDto.getHashtags());
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
