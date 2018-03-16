package com.kelicia91.springwebservicedemo.domain.posts;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

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
    public void postBuildAndLoad()
    {
        // given
        postsRepository.save(Posts.builder()
            .title("test title")
            .content("test content")
            .author("kelicia91")
            .build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts post = postsList.get(0);
        assertThat(post.getTitle(), is("test title"));
        assertThat(post.getContent(), is("test content"));
    }

    @Test
    public void registerBaseTimeEntity()
    {
        // given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
            .title("title with time")
            .content("content with time")
            .author("kelicia91")
            .build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        assertTrue(posts.getCreatedDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));
    }
}
