package com.kop.daegudot.web;

import com.kop.daegudot.service.recommend.RecommendService;
import com.kop.daegudot.service.user.UserService;
import com.kop.daegudot.web.dto.recommend.*;
import com.kop.daegudot.web.dto.user.UserResponseDto;
import com.kop.daegudot.web.dto.user.UserUpdateNicknameDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class RecommendController {
    private final RecommendService mRecommendService;
    private final UserService mUserService;

    //메인일정을 추천하기 - 추천할 때 해시태그 값도 필요
    @PostMapping("/recommend/register")
    public ResponseEntity<Long> saveRecommendSchedule(HttpServletRequest request,
                                                      @RequestBody RecommendScheduleRegisterDto recommendScheduleRegisterDto){
        String email = (String) request.getAttribute("email");
        UserResponseDto userResponseDto = mUserService.findByEmail((String) request.getAttribute("email"));
        Long recommendId = mRecommendService.saveRecommendSchedule(recommendScheduleRegisterDto, userResponseDto.getId());
        return ResponseEntity.ok().body(recommendId);
    }

    //추천된 일정 나열하기
    @GetMapping("/recommend/{hashtagId}")
    public RecommendScheduleResponseListDto listRecommendSchedule(@PathVariable long hashtagId){
        return mRecommendService.findRecommendSchedule(hashtagId);
    }

    //추천 수정하기
    @PutMapping("/recommend/update/{recommendScheduleId}")
    public Long updateRecommendSchedule(@PathVariable long recommendScheduleId,
                                        @RequestBody RecommendScheduleUpdateDto recommendScheduleUpdateDto){
        mRecommendService.updateRecommendSchedule(recommendScheduleId, recommendScheduleUpdateDto);
        return 1L;
    }

    //추천 삭제하기
    @DeleteMapping("/recommend/delete/{recommendScheduleId}")
    public Long deleteRecommendSchedule(@PathVariable long recommendScheduleId){
        return mRecommendService.deleteRecommendSchedule(recommendScheduleId);
    }

    //해시태그 리스트
    @GetMapping("/hashtag")
    public HashtagResponseListDto findAllHashtag(){
        return mRecommendService.findHashtag();
    }

    //내 추천글 리스트
    @GetMapping("/more/recommend")
    public ResponseEntity<RecommendScheduleResponseWithUserListDto> saveRecommendSchedule(HttpServletRequest request){
        String email = (String) request.getAttribute("email");
        UserResponseDto userResponseDto = mUserService.findByEmail((String) request.getAttribute("email"));
        return ResponseEntity.ok().body(mRecommendService.findMyRecommendSchedule(userResponseDto.getId()));
    }
}
