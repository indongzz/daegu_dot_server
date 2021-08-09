package com.kop.daegudot.web;

import com.kop.daegudot.service.comment.CommentService;
import com.kop.daegudot.service.user.UserService;
import com.kop.daegudot.web.dto.comment.*;
import com.kop.daegudot.web.dto.user.UserLoginDto;
import com.kop.daegudot.web.dto.user.UserRegisterDto;
import com.kop.daegudot.web.dto.user.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService mCommentService;
    private final UserService mUserService;

    //댓글 안에 start이라는 변수로 별점 또한 존재
    //추천글마다 댓글 읽어오기
    @GetMapping("/comment/{recommendId}")
    public CommentResponseListDto findAll(@PathVariable long recommendId){
        return mCommentService.findAllByRecommendScheduleId(recommendId);
    }

    //추천글마다 댓글 등록하기
    @PostMapping("/comment/register")
    public ResponseEntity<CommentRegisterResponseDto> saveComment(HttpServletRequest request, @RequestBody CommentRegisterDto commentRegisterDto){
        String email = (String) request.getAttribute("email");
        UserResponseDto userResponseDto = mUserService.findByEmail((String) request.getAttribute("email")).getUserResponseDto();
        return ResponseEntity.ok().body(mCommentService.saveComment(commentRegisterDto, userResponseDto.getId()));
    }

    //추천글마다 댓글 수정하기
    @PutMapping("/comment/update/{commentId}")
    public Long updateComment(@PathVariable long commentId, @RequestBody CommentUpdateDto commentUpdateDto){
        return mCommentService.updateComment(commentId, commentUpdateDto);
    }

    //추천글마다 댓글 삭제하기
    @DeleteMapping("/comment/delete/{commentId}")
    public Long deleteComment(@PathVariable long commentId){
        return mCommentService.deleteComment(commentId);
    }

    //내가 작성한 댓글 조회하기
    @GetMapping("/more/comment")
    public ResponseEntity<CommentResponseListDto> selectMyComment(HttpServletRequest request){
        String email = (String) request.getAttribute("email");
        UserResponseDto userResponseDto = mUserService.findByEmail((String) request.getAttribute("email")).getUserResponseDto();
        CommentResponseListDto commentResponseListDto = mCommentService.selectMyComment(userResponseDto.getId());
        return ResponseEntity.ok().body(commentResponseListDto);
    }
}
