package com.kelicia91.springwebservicedemo.web;

import com.kelicia91.springwebservicedemo.dto.posts.PostsSaveRequestDto;
import com.kelicia91.springwebservicedemo.service.PostsService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto)
    {
        return postsService.save(dto);
    }
}
