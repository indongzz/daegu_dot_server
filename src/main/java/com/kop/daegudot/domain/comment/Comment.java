package com.kop.daegudot.domain.comment;

import com.kop.daegudot.domain.recommendschedule.RecommendSchedule;
import com.kop.daegudot.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String comments;
    private LocalDateTime dateTime;
    private int star;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "recommend_schedule_id")
    private RecommendSchedule recommendSchedule;

    @Builder
    public Comment(LocalDateTime dateTime, String comments, int star, User user, RecommendSchedule recommendSchedule){
        this.dateTime = dateTime;
        this.comments = comments;
        this.star = star;
        this.user = user;
        this.recommendSchedule = recommendSchedule;
    }

    public void update(LocalDateTime dateTime, String comments, int star){
        this.dateTime = dateTime;
        this.comments = comments;
        this.star = star;
    }
}
