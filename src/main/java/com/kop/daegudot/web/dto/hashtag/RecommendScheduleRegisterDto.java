package com.kop.daegudot.web.dto.hashtag;

import com.kop.daegudot.domain.mainschedule.MainSchedule;
import com.kop.daegudot.domain.recommendschedule.RecommendSchedule;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RecommendScheduleRegisterDto {
    private String title;
    private String content;
    private MainSchedule mainSchedule;

    public RecommendScheduleRegisterDto(String title, String content, MainSchedule mainSchedule){
        this.title = title;
        this.content = content;
        this.mainSchedule = mainSchedule;
    }

    public RecommendSchedule toEntity(){
        return RecommendSchedule.builder().title(title).content(content).mainSchedule(mainSchedule)
                .build();
    }
}
