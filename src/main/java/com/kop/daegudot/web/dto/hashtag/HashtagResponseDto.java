package com.kop.daegudot.web.dto.hashtag;

import com.kop.daegudot.domain.hashtag.Hashtag;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class HashtagResponseDto {
    private long id;
    private String content;

    public HashtagResponseDto(Hashtag hashtag){
        this.id = hashtag.getId();
        this.content = hashtag.getContent();
    }
}
