package com.kop.daegudot.service.comment;


import com.kop.daegudot.domain.comment.Comment;
import com.kop.daegudot.domain.comment.CommentRepository;
import com.kop.daegudot.domain.recommendschedule.RecommendSchedule;
import com.kop.daegudot.domain.recommendschedule.RecommendScheduleRepository;
import com.kop.daegudot.domain.user.User;
import com.kop.daegudot.domain.user.UserRepository;
import com.kop.daegudot.web.dto.comment.CommentRegisterDto;
import com.kop.daegudot.web.dto.comment.CommentResponseDto;
import com.kop.daegudot.web.dto.comment.CommentUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository mCommentRepository;
    private final UserRepository mUserRepository;
    private final RecommendScheduleRepository mRecommendScheduleRepository;

    //SELECT * FROM Comment Where RecommendSchedule.id = ?
    public ArrayList<CommentResponseDto> findAllByRecommendScheduleId(long id){
        ArrayList<Comment> commentArrayList;
        ArrayList<CommentResponseDto> commentResponseDtoArrayList = new ArrayList<>();

        commentArrayList = mCommentRepository.findByRecommendScheduleId(id);
        for(int i=0; i<commentArrayList.size();i++){
            CommentResponseDto commentResponseDto = new CommentResponseDto(commentArrayList.get(i));
            commentResponseDtoArrayList.add(commentResponseDto);
        }

        return commentResponseDtoArrayList;
    }

    //Insert
    @Transactional
    public Long saveComment(CommentRegisterDto commentRegisterDto){
        User user = mUserRepository.findById(commentRegisterDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("There is no id =" + commentRegisterDto.getUserId()));
        RecommendSchedule recommendSchedule = mRecommendScheduleRepository.findById(commentRegisterDto.getRecommendScheduleId())
                .orElseThrow(() -> new IllegalArgumentException("There is no id =" + commentRegisterDto.getRecommendScheduleId()));
        return mCommentRepository.save(commentRegisterDto.toEntity(user, recommendSchedule)).getId();
    }

    //Update
    public Long updateComment(long id, CommentUpdateDto commentUpdateDto){
        Comment comment = mCommentRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("There is no id =" + id));
        comment.update(LocalDateTime.parse(commentUpdateDto.getDateTime(), DateTimeFormatter.ISO_DATE_TIME),
                comment.getComments(), comment.getStar());
        mCommentRepository.save(comment);
        return id;
    }

    //delete
    public void deleteComment(long commentId){
        mCommentRepository.deleteById(commentId);
    }
}
