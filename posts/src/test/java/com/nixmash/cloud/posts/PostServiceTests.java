package com.nixmash.cloud.posts;

import com.nixmash.cloud.core.model.Post;
import com.nixmash.cloud.posts.service.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

/**
 * Created by daveburke on 5/28/17.
 */
@RunWith(SpringRunner.class)
@Transactional
public class PostServiceTests extends AbstractContext {

    @Autowired
    private PostService postService;

    @Test
    public void getRecentPostsTest() throws Exception {
        List<Post> posts = postService.getRecentPosts();
        assertThat(posts.size(), greaterThan(0));
    }

}
