package com.kop.daegudot.web;

import com.kop.daegudot.service.hashtag.HashtagService;
import com.kop.daegudot.web.dto.hashtag.HashtagResponseDto;
import com.kop.daegudot.web.dto.hashtag.RecommendScheduleRegisterDto;
import com.kop.daegudot.web.dto.hashtag.RecommendScheduleUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class HashtagController {
    private final HashtagService mHashtagService;

    //메인일정을 추천하기
    @PostMapping("/hashtag/recommand")
    public Long saveRecommendSchedule(@RequestBody RecommendScheduleRegisterDto recommendScheduleRegisterDto){
        return mHashtagService.saveRecommendSchedule(recommendScheduleRegisterDto);
    }

    //추천 수정하기
    @PutMapping("hashtag/update/{recommendScheduleId}")
    public Long updateRecommendSchedule(@PathVariable long recommendScheduleId,
                                        @RequestBody RecommendScheduleUpdateDto recommendScheduleUpdateDto){
        return mHashtagService.updateRecommendSchedule(recommendScheduleId, recommendScheduleUpdateDto);
    }

    //추천 삭제하기
    @DeleteMapping("/hashtag/delete/{id}")
    public void deleteRecommendSchedule(@PathVariable long id){
        mHashtagService.deleteRecommendSchedule(id);
    }

    //추천에 해시태그 넣기
    //추천에 해시태그 삭제
    //추천에 해시태그 수정

    //해시태그 리스트
    @GetMapping("/hashtag/list")
    public ArrayList<HashtagResponseDto> findAll(){
        return mHashtagService.findAll();
    }
}
