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
    private long mainScheduleId;
    private ArrayList<Long> hashtagId;
    private double star;

    public RecommendScheduleUpdateDto(String title, String content, long mainScheduleId, ArrayList<Long> hastagId, double star){
        this.title = title;
        this.content = content;
        this.mainScheduleId = mainScheduleId;
        this.hashtagId = hastagId;
        this.star = star;
    }
}
