package com.kop.daegudot.domain.recommendschedule;

import com.kop.daegudot.domain.mainschedule.MainSchedule;

import javax.persistence.*;

import com.kop.daegudot.domain.schedulehashtag.ScheduleHashtag;
import com.kop.daegudot.web.dto.hashtag.RecommendScheduleUpdateDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class RecommendSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "main_schedule_id")
    private MainSchedule mainSchedule;

    private String title;

    @Column(columnDefinition = "TEXT", length = 2048)
    private String content;

    @OneToMany(mappedBy = "recommendSchedule", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ScheduleHashtag> scheduleHashtags;

    @Builder
    public RecommendSchedule(MainSchedule mainSchedule, String title, String content){
        this.mainSchedule = mainSchedule;
        this.title = title;
        this.content = content;
    }

    public void update(MainSchedule mainSchedule, String title, String content){
        this.mainSchedule = mainSchedule;
        this.title = title;
        this.content = content;
    }
}