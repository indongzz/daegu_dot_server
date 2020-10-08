package com.kop.daegudot.domain.recommendschedule;

import com.kop.daegudot.domain.mainschedule.MainSchedule;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
}