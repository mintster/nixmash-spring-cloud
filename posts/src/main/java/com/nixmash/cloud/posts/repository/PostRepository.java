package com.nixmash.cloud.posts.repository;

import com.nixmash.cloud.core.model.Post;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by daveburke on 5/28/17.
 */
@RepositoryRestResource
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {

    Post findByPostId(Long postId) throws DataAccessException;

    List<Post> findAll(Sort sort);

    List<Post> findFirst10ByOrderByPostDateDesc(Sort sort);

    List<Post> findByIsPublishedTrue(Sort sort);

}