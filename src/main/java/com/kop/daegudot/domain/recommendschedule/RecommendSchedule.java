package com.kop.daegudot.domain.recommendschedule;

import com.kop.daegudot.domain.comment.Comment;
import com.kop.daegudot.domain.mainschedule.MainSchedule;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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

    @OneToMany(mappedBy = "recommendSchedule", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private List<Comment> commentList = new ArrayList<>();

    private String title;

    @Column(columnDefinition = "TEXT", length = 2048)
    private String content;
}