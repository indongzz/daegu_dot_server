package com.kop.daegudot.web.dto.hashtag;

import com.kop.daegudot.domain.mainschedule.MainSchedule;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sun.applet.Main;

@Getter
@NoArgsConstructor
public class RecommendScheduleUpdateDto {
    private String title;
    private String content;
    private MainSchedule mainSchedule;

    public RecommendScheduleUpdateDto(String title, String content, MainSchedule mainSchedule){
        this.title = title;
        this.content = content;
        this.mainSchedule = mainSchedule;
    }
}
