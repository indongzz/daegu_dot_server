package com.kop.daegudot.web.dto.recommend;

import com.kop.daegudot.domain.hashtag.Hashtag;
import com.kop.daegudot.domain.mainschedule.MainSchedule;
import com.kop.daegudot.domain.recommendschedule.RecommendSchedule;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
public class RecommendScheduleRegisterDto {
    private String title;
    private String content;
    private MainSchedule mainSchedule;
    private ArrayList<Hashtag> hashtags;

    public RecommendScheduleRegisterDto(String title, String content, MainSchedule mainSchedule, ArrayList<Hashtag> hashtags){
        this.title = title;
        this.content = content;
        this.mainSchedule = mainSchedule;
        this.hashtags = hashtags;
    }

    public RecommendSchedule toEntity(){
        return RecommendSchedule.builder().mainSchedule(mainSchedule).title(title).content(content)
                .hashtags(hashtags).build();
    }
}
