package com.kop.daegudot.web;

import com.kop.daegudot.service.comment.CommentService;
import com.kop.daegudot.web.dto.comment.CommentRegisterDto;
import com.kop.daegudot.web.dto.comment.CommentResponseDto;
import com.kop.daegudot.web.dto.comment.CommentUpdateDto;
import com.kop.daegudot.web.dto.user.UserLoginDto;
import com.kop.daegudot.web.dto.user.UserRegisterDto;
import com.kop.daegudot.web.dto.user.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService mCommentService;

    //댓글 안에 start이라는 변수로 별점 또한 존재
    //추천글마다 댓글 읽어오기
    @GetMapping("/comment/{recommendId}")
    public ArrayList<CommentResponseDto> findAll(@PathVariable long recommendId){
        return mCommentService.findAllByRecommendScheduleId(recommendId);
    }

    //추천글마다 댓글 등록하기
    @PostMapping("/comment/register")
    public Long saveComment( @RequestBody CommentRegisterDto commentRegisterDto){
        return mCommentService.saveComment(commentRegisterDto);
    }

    //추천글마다 댓글 수정하기
    @PutMapping("/comment/update/{commentId}")
    public Long updateComment(@PathVariable long commentId, @RequestBody CommentUpdateDto commentUpdateDto){
        return mCommentService.updateComment(commentId, commentUpdateDto);
    }

    //추천글마다 댓글 삭제하기
    @DeleteMapping("/comment/delete/{commentId}")
    public void deleteComment(@PathVariable long commentId){
        mCommentService.deleteComment(commentId);
    }

}
