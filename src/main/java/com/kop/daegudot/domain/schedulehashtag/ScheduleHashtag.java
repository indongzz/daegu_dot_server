package com.kop.daegudot.domain.schedulehashtag;

import com.kop.daegudot.domain.hashtag.Hashtag;
import com.kop.daegudot.domain.recommendschedule.RecommendSchedule;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class ScheduleHashtag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "hashtag_id")
    private Hashtag hashtag;

    @ManyToOne
    @JoinColumn(name = "recommend_schedule_id")
    private RecommendSchedule recommendSchedule;
}
