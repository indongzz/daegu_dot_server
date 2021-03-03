package com.kop.daegudot.service.recommend;

import com.kop.daegudot.domain.hashtag.Hashtag;
import com.kop.daegudot.domain.hashtag.HashtagRepository;
import com.kop.daegudot.domain.mainschedule.MainSchedule;
import com.kop.daegudot.domain.mainschedule.MainScheduleRepository;
import com.kop.daegudot.domain.recommendschedule.RecommendSchedule;
import com.kop.daegudot.domain.recommendschedule.RecommendScheduleRepository;
import com.kop.daegudot.web.dto.recommend.HashtagResponseDto;
import com.kop.daegudot.web.dto.recommend.RecommendScheduleRegisterDto;
import com.kop.daegudot.web.dto.recommend.RecommendScheduleResponseDto;
import com.kop.daegudot.web.dto.recommend.RecommendScheduleUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RecommendService {
    private final RecommendScheduleRepository mRecommendScheduleRepository;
    private final HashtagRepository mHashtagRepository;
    private final MainScheduleRepository mMainscheduleRepository;

    //INSERT TO
    @Transactional
    public long saveRecommendSchedule(RecommendScheduleRegisterDto recommendScheduleRegisterDto){
        LocalDateTime localDateTime = LocalDateTime.now();
        MainSchedule mainSchedule = mMainscheduleRepository.findById(recommendScheduleRegisterDto.getMainScheduleId())
                .orElseThrow(()->new IllegalArgumentException("There is no id = "+recommendScheduleRegisterDto.getMainScheduleId()));

        ArrayList<Hashtag> hashtagArrayList = new ArrayList<>();
        for(int i=0; i<recommendScheduleRegisterDto.getHashtagId().size();i++){
            long idx = recommendScheduleRegisterDto.getHashtagId().get(i);
            Hashtag hashtag = mHashtagRepository.findById(idx)
                    .orElseThrow(()->new IllegalArgumentException("There is no id = "+idx));
            hashtagArrayList.add(hashtag);
        }


        return mRecommendScheduleRepository.save(recommendScheduleRegisterDto.toEntity(mainSchedule, hashtagArrayList, localDateTime)).getId();
    }

    //SELECT * FROM RecommendSchedule
    public ArrayList<RecommendScheduleResponseDto> findAllRecommendSchedule(){
        List<RecommendSchedule> recommendScheduleList;
        ArrayList<RecommendScheduleResponseDto> recommendScheduleResponseDtoArrayList = new ArrayList<>();

        recommendScheduleList = mRecommendScheduleRepository.findAll();
        for(int i=0; i<recommendScheduleList.size();i++){
            RecommendScheduleResponseDto recommendScheduleResponseDto = new RecommendScheduleResponseDto(recommendScheduleList.get(i));
            recommendScheduleResponseDtoArrayList.add(recommendScheduleResponseDto);
        }
        return recommendScheduleResponseDtoArrayList;
    }

    //UPDATE
    public Long updateRecommendSchedule(long recommendScheduleId, RecommendScheduleUpdateDto recommendScheduleUpdateDto){
        LocalDateTime localDateTime = LocalDateTime.now();
        RecommendSchedule recommendSchedule = mRecommendScheduleRepository.findById(recommendScheduleId)
                .orElseThrow(()->new IllegalArgumentException("There is no id = "+recommendScheduleId));
        MainSchedule mainSchedule = mMainscheduleRepository.findById(recommendScheduleUpdateDto.getMainScheduleId())
                .orElseThrow(()->new IllegalArgumentException("There is no id = "+recommendScheduleUpdateDto.getMainScheduleId()));

        ArrayList<Hashtag> hashtagArrayList = new ArrayList<>();
        for(int i=0; i<recommendScheduleUpdateDto.getHashtagId().size();i++){
            long idx = recommendScheduleUpdateDto.getHashtagId().get(i);
            Hashtag hashtag = mHashtagRepository.findById(idx)
                    .orElseThrow(()->new IllegalArgumentException("There is no id = "+idx));
            hashtagArrayList.add(hashtag);
        }

        recommendSchedule.update(mainSchedule, recommendScheduleUpdateDto.getTitle(),
                recommendScheduleUpdateDto.getContent(), hashtagArrayList, localDateTime);
        mRecommendScheduleRepository.save(recommendSchedule);
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
