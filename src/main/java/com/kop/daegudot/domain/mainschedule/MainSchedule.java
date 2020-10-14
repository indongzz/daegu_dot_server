package com.kop.daegudot.domain.mainschedule;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;

import com.kop.daegudot.domain.subschedule.SubSchedule;
import com.kop.daegudot.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@NoArgsConstructor
public class MainSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate startDate;
    private LocalDate endDate;
    private String title;

    @OneToMany(mappedBy = "mainSchedule", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<SubSchedule> subSchedules;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public MainSchedule(LocalDate startDate, LocalDate endDate, String title, User user) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.user = user;
    }

    public void update(LocalDate startDate, LocalDate endDate, String title) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
    }
}
