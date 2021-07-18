package com.kop.daegudot.web.dto.recommend;

import com.kop.daegudot.domain.hashtag.Hashtag;
import com.kop.daegudot.domain.mainschedule.MainSchedule;
import com.kop.daegudot.domain.recommendschedule.RecommendSchedule;
import com.kop.daegudot.web.dto.mainshcedule.MainScheduleResponseDto;
import com.kop.daegudot.web.dto.subschedule.SubScheduleResponseListDto;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class RecommendScheduleResponseDto {
    private long id;
    private String title;
    private String content;
    private List<Hashtag> hashtags;
    private String localDateTime;
    private double star;
    private MainScheduleResponseDto mainScheduleResponseDto;

    public RecommendScheduleResponseDto(RecommendSchedule recommendSchedule){
        this.id = recommendSchedule.getId();
        this.mainScheduleResponseDto = new MainScheduleResponseDto(recommendSchedule.getMainSchedule());
        this.title = recommendSchedule.getTitle();
        this.content = recommendSchedule.getContent();
        this.hashtags = recommendSchedule.getHashtags();
        this.localDateTime = recommendSchedule.getDatetime().toString();
        this.star = recommendSchedule.getStar();
    }
}
