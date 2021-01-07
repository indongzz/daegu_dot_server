package com.kop.daegudot.web.dto.recommend;

import com.kop.daegudot.domain.hashtag.Hashtag;
import com.kop.daegudot.domain.mainschedule.MainSchedule;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@NoArgsConstructor
public class RecommendScheduleUpdateDto {
    private String title;
    private String content;
    private MainSchedule mainSchedule;
    private ArrayList<Hashtag> hashtags;

    public RecommendScheduleUpdateDto(String title, String content, MainSchedule mainSchedule, ArrayList<Hashtag> hastags){
        this.title = title;
        this.content = content;
        this.mainSchedule = mainSchedule;
        this.hashtags = hastags;
    }
}
