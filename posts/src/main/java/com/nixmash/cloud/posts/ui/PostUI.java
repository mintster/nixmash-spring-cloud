package com.nixmash.cloud.posts.ui;

import com.nixmash.cloud.core.model.Post;
import com.nixmash.cloud.posts.service.PostService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by daveburke on 5/28/17.
 */
@Component
public class PostUI {

    private final PostService postService;

    public PostUI(PostService postService) {
        this.postService = postService;
    }

    public void init() {
        recentPosts();
    }

    private void recentPosts() {
        List<Post> posts = postService.getRecentPosts();
        posts.forEach(p -> System.out.println(p.getPostTitle()));
    }
}
