package com.nixmash.cloud.posts.config;

import com.nixmash.cloud.core.model.Post;
import com.nixmash.cloud.core.projections.PostTitles;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * Created by daveburke on 5/31/17.
 */
@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Post.class);
        config.getProjectionConfiguration().addProjection(PostTitles.class);
//        config.setDefaultMediaType(MediaType.APPLICATION_JSON_UTF8);
    }


}