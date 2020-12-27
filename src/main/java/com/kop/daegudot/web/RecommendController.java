package com.kop.daegudot.web;

import com.kop.daegudot.service.recommend.RecommendService;
import com.kop.daegudot.web.dto.recommend.HashtagResponseDto;
import com.kop.daegudot.web.dto.recommend.RecommendScheduleRegisterDto;
import com.kop.daegudot.web.dto.recommend.RecommendScheduleResponseDto;
import com.kop.daegudot.web.dto.recommend.RecommendScheduleUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class RecommendController {
    private final RecommendService mRecommendService;

    //메인일정을 추천하기 - 추천할 때 해시태그 값도 필요
    @PostMapping("/recommand/register")
    public Long saveRecommendSchedule(@RequestBody RecommendScheduleRegisterDto recommendScheduleRegisterDto){
        return mRecommendService.saveRecommendSchedule(recommendScheduleRegisterDto);
    }

    //추천된 일정 나열하기
    @PostMapping("/recommend")
    public ArrayList<RecommendScheduleResponseDto> listRecommendSchedule(){

    }

    //추천 수정하기
    @PutMapping("/recommend/update/{recommendScheduleId}")
    public Long updateRecommendSchedule(@PathVariable long recommendScheduleId,
                                        @RequestBody RecommendScheduleUpdateDto recommendScheduleUpdateDto){
        return mRecommendService.updateRecommendSchedule(recommendScheduleId, recommendScheduleUpdateDto);
    }

    //추천 삭제하기
    @DeleteMapping("/recommend/delete/{id}")
    public void deleteRecommendSchedule(@PathVariable long id){
        mRecommendService.deleteRecommendSchedule(id);
    }


    //해시태그 리스트
    @GetMapping("/hashtag/list")
    public ArrayList<HashtagResponseDto> findAll(){
        return mRecommendService.findAll();
    }
}
