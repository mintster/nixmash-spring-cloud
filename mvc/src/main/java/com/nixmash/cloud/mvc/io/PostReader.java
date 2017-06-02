package com.nixmash.cloud.mvc.io;

import com.nixmash.cloud.core.model.Post;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("post-service")
public interface PostReader {

    @RequestMapping(method = RequestMethod.GET, value = "/posts?sort=postId,desc&size=10")
    Resources<Post> recent();

    @RequestMapping(method = RequestMethod.GET, value = "/posts?projection=postTitles&sort=postId,desc&size=10")
    Resources<Post> recentTitles();
}
