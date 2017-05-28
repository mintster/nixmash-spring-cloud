package com.nixmash.cloud.posts.service;

import com.nixmash.cloud.core.model.Post;
import com.nixmash.cloud.posts.repository.PostRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by daveburke on 5/28/17.
 */
@Service("postService")
@Transactional
public class PostServiceImpl implements PostService {

    // region Constructor

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // endregion

    // region Services

    @Transactional(readOnly = true)
    @Override
    public List<Post> getRecentPosts() {
        return postRepository.findFirst25ByOrderByPostDateDesc(sortByPostDateDesc());
    }

    // endregion

    // region Sorters

    public Sort sortByPostDateDesc() {
        return new Sort(Sort.Direction.DESC, "postDate");
    }

    // endregion

}