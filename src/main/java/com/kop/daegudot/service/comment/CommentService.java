package com.kop.daegudot.service.comment;


import com.kop.daegudot.domain.comment.Comment;
import com.kop.daegudot.domain.comment.CommentRepository;
import com.kop.daegudot.domain.recommendschedule.RecommendSchedule;
import com.kop.daegudot.domain.recommendschedule.RecommendScheduleRepository;
import com.kop.daegudot.domain.user.User;
import com.kop.daegudot.domain.user.UserRepository;
import com.kop.daegudot.web.dto.comment.*;
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
    public CommentResponseListDto findAllByRecommendScheduleId(long id){
        ArrayList<Comment> commentArrayList;
        ArrayList<CommentResponseDto> commentResponseDtoArrayList = new ArrayList<>();
        CommentResponseListDto commentResponseListDto;

        commentArrayList = mCommentRepository.findByRecommendScheduleId(id);
        if(commentArrayList.size() > 0){
            for(int i=0; i<commentArrayList.size();i++){
                CommentResponseDto commentResponseDto = new CommentResponseDto(commentArrayList.get(i));
                commentResponseDtoArrayList.add(commentResponseDto);
            }
            commentResponseListDto = new CommentResponseListDto(commentResponseDtoArrayList, 1L);
        }
        else{
            commentResponseListDto = new CommentResponseListDto(commentResponseDtoArrayList, 0L);
        }
        return commentResponseListDto;
    }

    //Insert
    @Transactional
    public CommentRegisterResponseDto saveComment(CommentRegisterDto commentRegisterDto, long userId){
        CommentRegisterResponseDto commentRegisterResponseDto;
        LocalDateTime localDateTime = LocalDateTime.now();
        User user = mUserRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("There is no id =" + userId));
        RecommendSchedule recommendSchedule = mRecommendScheduleRepository.findById(commentRegisterDto.getRecommendScheduleId())
                .orElseThrow(() -> new IllegalArgumentException("There is no id =" + commentRegisterDto.getRecommendScheduleId()));
        long id = mCommentRepository.save(commentRegisterDto.toEntity(user, recommendSchedule, localDateTime)).getId();
        commentRegisterResponseDto = new CommentRegisterResponseDto(id, localDateTime);
        return commentRegisterResponseDto;
    }

    //Update
    public Long updateComment(long id, CommentUpdateDto commentUpdateDto){
        LocalDateTime localDateTime = LocalDateTime.now();
        Comment comment = mCommentRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("There is no id =" + id));
        comment.update(localDateTime, comment.getComments());
        mCommentRepository.save(comment);
        return 1L;
    }

    //delete
    public Long deleteComment(long commentId){
        mCommentRepository.deleteById(commentId);
        return 1L;
    }

    public CommentResponseListDto selectMyComment(long userId){
        ArrayList<Comment> commentArrayList;
        ArrayList<CommentResponseDto> commentResponseDtoArrayList = new ArrayList<>();
        CommentResponseListDto commentResponseListDto;

        commentArrayList = mCommentRepository.findByUserId(userId);
        if(commentArrayList.size() > 0){
            for(int i=0; i<commentArrayList.size();i++){
                CommentResponseDto commentResponseDto = new CommentResponseDto(commentArrayList.get(i));
                commentResponseDtoArrayList.add(commentResponseDto);
            }
            commentResponseListDto = new CommentResponseListDto(commentResponseDtoArrayList, 1L);
        }
        else{
            commentResponseListDto = new CommentResponseListDto(commentResponseDtoArrayList, 0L);
        }
        return commentResponseListDto;
    }
}
