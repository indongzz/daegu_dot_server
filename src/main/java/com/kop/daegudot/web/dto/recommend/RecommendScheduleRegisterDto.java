package com.kop.daegudot.web.dto.recommend;

import com.kop.daegudot.domain.hashtag.Hashtag;
import com.kop.daegudot.domain.mainschedule.MainSchedule;
import com.kop.daegudot.domain.recommendschedule.RecommendSchedule;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;

@NoArgsConstructor
@Getter
public class RecommendScheduleRegisterDto {
    private String title;
    private String content;
    private long mainScheduleId;
    private ArrayList<Long> hashtagId;

    public RecommendScheduleRegisterDto(String title, String content, long mainScheduleId, ArrayList<Long> hashtagsId){
        this.title = title;
        this.content = content;
        this.mainScheduleId = mainScheduleId;
        this.hashtagId = hashtagsId;
    }

    public RecommendSchedule toEntity(MainSchedule mainSchedule, ArrayList<Hashtag> hashtags, LocalDateTime datetime){
        return RecommendSchedule.builder().mainSchedule(mainSchedule).title(title).content(content).hashtags(hashtags).datetime(datetime).build();
    }
}
