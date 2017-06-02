package com.nixmash.cloud.mvc.controller;

import com.nixmash.cloud.mvc.io.PostReader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/posts")
public class PostController {

    // region Constants

    public static final String POSTS_LIST_VIEW = "posts/list";
    // endregion

    // region Beans

    private final PostReader postReader;

    public PostController(PostReader postReader) {
        this.postReader = postReader;
    }

    // endregion

    @GetMapping("")
    public String postsListPage() {
        return POSTS_LIST_VIEW;
    }
}
