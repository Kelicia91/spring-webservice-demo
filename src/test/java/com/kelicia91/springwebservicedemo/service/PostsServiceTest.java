package com.kelicia91.springwebservicedemo.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.kelicia91.springwebservicedemo.domain.posts.Posts;
import com.kelicia91.springwebservicedemo.domain.posts.PostsRepository;
import com.kelicia91.springwebservicedemo.dto.posts.PostsSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRespository;

    @After
    public void cleanup() {
        postsRespository.deleteAll();
    }

    @Test
    public void saveDTOintoPostsRepos() {
        // given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .author("kelicia91")
                .title("title")
                .content("content")
                .build();

        // when
        postsService.save(dto);

        // then
        Posts posts = postsRespository.findAll().get(0);
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
    }
}
