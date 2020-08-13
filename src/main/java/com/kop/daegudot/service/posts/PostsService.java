package com.kop.daegudot.service.posts;

import com.kop.daegudot.domain.posts.Posts;
import com.kop.daegudot.domain.posts.PostsRepository;
import com.kop.daegudot.web.dto.PostsResponseDto;
import com.kop.daegudot.web.dto.PostsSaveRequestDto;
import com.kop.daegudot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }


    // drity checking
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    // drity checking
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

}
