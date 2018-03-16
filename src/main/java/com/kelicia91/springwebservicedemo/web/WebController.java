package com.kelicia91.springwebservicedemo.web;

import com.kelicia91.springwebservicedemo.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    private PostsService postsService;

    // @GetMapping = @RequestMapping(value="/", method=RequestMethod.GET)
    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "main";
    }
}
