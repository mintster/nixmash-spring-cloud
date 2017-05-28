package com.nixmash.cloud.posts.service;

import com.nixmash.cloud.core.model.Post;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by daveburke on 5/28/17.
 */
public interface PostService {
    @Transactional(readOnly = true)
    List<Post> getRecentPosts();
}
