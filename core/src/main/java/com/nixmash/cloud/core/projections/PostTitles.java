package com.nixmash.cloud.core.projections;

import com.nixmash.cloud.core.model.Post;
import org.springframework.data.rest.core.config.Projection;

/**
 * Created by daveburke on 5/31/17.
 */
@Projection(name = "postTitles", types = { Post.class })
public interface PostTitles {

    String getPostTitle();

}
