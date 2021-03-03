package com.kop.daegudot.domain.recommendschedule;

import com.kop.daegudot.domain.hashtag.Hashtag;
import com.kop.daegudot.domain.comment.Comment;
import com.kop.daegudot.domain.mainschedule.MainSchedule;

import javax.persistence.*;


import lombok.Builder;
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
    private List<Comment> commentList = new ArrayList<>();

    private String title;

    @Column(columnDefinition = "TEXT", length = 2048)
    private String content;

    @ManyToMany
    @JoinColumn(name = "hashtag_id")
    private List<Hashtag> hashtags;

    @Builder
    public RecommendSchedule(MainSchedule mainSchedule, String title, String content, ArrayList<Hashtag> hashtags){
        this.mainSchedule = mainSchedule;
        this.title = title;
        this.content = content;
        this.hashtags = hashtags;
    }

    public void update(MainSchedule mainSchedule, String title, String content, ArrayList<Hashtag> hashtags){
        this.mainSchedule = mainSchedule;
        this.title = title;
        this.content = content;
        this.hashtags = hashtags;
    }
}