package com.kop.daegudot.domain.mainschedule;

import java.time.LocalDate;
import javax.persistence.*;

import com.kop.daegudot.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;
import sun.applet.Main;

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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public MainSchedule(LocalDate startDate, LocalDate endDate, String title, User user){
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.user = user;
    }
}
