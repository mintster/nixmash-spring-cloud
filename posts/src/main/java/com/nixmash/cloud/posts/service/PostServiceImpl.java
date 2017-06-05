package com.nixmash.cloud.posts.service;

import com.nixmash.cloud.core.dto.PostDTO;
import com.nixmash.cloud.core.model.Post;
import com.nixmash.cloud.core.utils.PostUtils;
import com.nixmash.cloud.posts.repository.PostRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<PostDTO> getRecentPostDTOs() {
        List<Post> recentPosts = postRepository.findFirst10ByOrderByPostDateDesc(sortByPostDateDesc());
        return postsToPostDTOs(recentPosts);
    }

    // endregion

    // region Sorters

    public Sort sortByPostDateDesc() {
        return new Sort(Sort.Direction.DESC, "postDate");
    }

    // endregion

    // region Converters

    @Override
    public List<PostDTO> postsToPostDTOs(List<Post> posts) {
        return posts.stream().map(PostUtils::postToPostDTO).collect(Collectors.toList());
    }

    // endregion
}