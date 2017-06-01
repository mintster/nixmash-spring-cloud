package com.nixmash.cloud.posts.repository;

import com.nixmash.cloud.core.model.Tag;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by daveburke on 5/28/17.
 */
@RepositoryRestResource
public interface TagRepository extends PagingAndSortingRepository<Tag, Long> {

}