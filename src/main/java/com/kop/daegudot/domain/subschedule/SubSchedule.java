package com.kop.daegudot.domain.subschedule;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.*;

import com.kop.daegudot.domain.mainschedule.MainSchedule;
import com.kop.daegudot.domain.places.Places;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class SubSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @OneToOne
    @JoinColumn(name="places_id")
    private Places places;

    @ManyToOne
    @JoinColumn(name="mainSchedule_id")
    private MainSchedule mainSchedule;

    @Builder
    public SubSchedule(LocalDate date, LocalDateTime startTime, LocalDateTime endTime,
                       Places places, MainSchedule mainSchedule){
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.places = places;
        this.mainSchedule = mainSchedule;
    }

}
