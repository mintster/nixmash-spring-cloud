package com.nixmash.cloud.core.projections;

import com.nixmash.cloud.core.model.Post;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "postTitles", types = { Post.class })
public interface PostTitles {

    String getPostTitle();

}




