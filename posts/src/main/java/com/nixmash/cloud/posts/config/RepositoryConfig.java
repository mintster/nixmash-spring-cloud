package com.nixmash.cloud.posts.config;

import com.nixmash.cloud.core.model.Post;
import com.nixmash.cloud.core.model.Tag;
import com.nixmash.cloud.core.projections.PostTitles;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;


@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Post.class, Tag.class);
        config.getProjectionConfiguration().addProjection(PostTitles.class);
    }


}