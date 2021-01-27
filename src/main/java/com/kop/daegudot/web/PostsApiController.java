package com.kop.daegudot.web;

import com.kop.daegudot.domain.posts.Posts;
import com.kop.daegudot.service.posts.PostsService;
import com.kop.daegudot.web.dto.PostsResponseDto;
import com.kop.daegudot.web.dto.PostsSaveRequestDto;
import com.kop.daegudot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    /* method: POST
    SQL: INSERT */
    @PostMapping("api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    /* method: GET
    SQL: UPDATE */
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    /* method: GET
    SQL: SELECT */
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id, Model model) {
        model.addAttribute(postsService.findById((id)));
        return postsService.findById(id);
    }

}
