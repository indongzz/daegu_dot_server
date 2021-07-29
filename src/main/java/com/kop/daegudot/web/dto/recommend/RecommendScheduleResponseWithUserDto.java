package com.kop.daegudot.web.dto.recommend;

import com.kop.daegudot.domain.hashtag.Hashtag;
import com.kop.daegudot.domain.recommendschedule.RecommendSchedule;
import com.kop.daegudot.web.dto.mainshcedule.MainScheduleResponseDto;
import com.kop.daegudot.web.dto.user.UserResponseDto;
import lombok.Getter;

import java.util.List;

@Getter
public class RecommendScheduleResponseWithUserDto {
    private long id;
    private String title;
    private String content;
    private List<Hashtag> hashtags;
    private String localDateTime;
    private double star;
    private MainScheduleResponseDto mainScheduleResponseDto;
    private UserResponseDto userResponseDto;

    public RecommendScheduleResponseWithUserDto(RecommendSchedule recommendSchedule){
        this.id = recommendSchedule.getId();
        this.mainScheduleResponseDto = new MainScheduleResponseDto(recommendSchedule.getMainSchedule());
        this.title = recommendSchedule.getTitle();
        this.content = recommendSchedule.getContent();
        this.hashtags = recommendSchedule.getHashtags();
        this.localDateTime = recommendSchedule.getDatetime().toString();
        this.star = recommendSchedule.getStar();
        this.userResponseDto = new UserResponseDto(recommendSchedule.getUser());
    }
}
