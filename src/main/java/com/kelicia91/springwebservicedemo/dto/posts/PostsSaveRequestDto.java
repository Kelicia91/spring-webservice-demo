package com.kelicia91.springwebservicedemo.dto.posts;

import com.kelicia91.springwebservicedemo.domain.posts.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    public Posts toEntity()
    {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
