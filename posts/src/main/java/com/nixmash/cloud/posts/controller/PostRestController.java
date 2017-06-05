package com.nixmash.cloud.posts.controller;

import com.nixmash.cloud.core.dto.PostDTO;
import com.nixmash.cloud.posts.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by daveburke on 5/30/17.
 */
@RestController
public class PostRestController {

    private final PostService postService;

    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/postdtos")
    public List<PostDTO> getRecentPosts() {
        return postService.getRecentPostDTOs();
    }

}
