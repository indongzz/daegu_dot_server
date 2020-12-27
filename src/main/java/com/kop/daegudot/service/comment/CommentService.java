package com.kop.daegudot.service.comment;


import com.kop.daegudot.domain.comment.Comment;
import com.kop.daegudot.domain.comment.CommentRepository;
import com.kop.daegudot.web.dto.comment.CommentRegisterDto;
import com.kop.daegudot.web.dto.comment.CommentResponseDto;
import com.kop.daegudot.web.dto.comment.CommentUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository mCommentRepository;

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
        return mCommentRepository.save(commentRegisterDto.toEntity()).getId();
    }

    //Update
    public Long updateComment(long id, CommentUpdateDto commentUpdateDto){
        Comment comment = mCommentRepository.findById(id);
        comment.update(commentUpdateDto.getComments());
        return id;
    }

    //delete
    public void deleteComment(long commentId){
        mCommentRepository.deleteById(commentId);
    }
}
