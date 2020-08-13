package com.kop.daegudot.web.domain.posts;

import static org.assertj.core.api.Assertions.assertThat;

import com.kop.daegudot.domain.posts.Posts;
import com.kop.daegudot.domain.posts.PostsRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void test_borad_load() {
        // given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository
                .save(Posts.builder().title(title).content(content).author("jojoldu@gmail.com")
                        .build());

        // when
        List<Posts> postsLists = postsRepository.findAll();

        // then
        Posts posts = postsLists.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void test_BaseTimeEntity_registration() {
        LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);
        postsRepository
                .save(Posts.builder().title("title").content("content").author("author").build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>>>>>> createDate=" + posts.getCreatedDate() + ", modifiedDate=" + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);

    }
}
