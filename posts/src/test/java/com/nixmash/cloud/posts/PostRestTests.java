package com.nixmash.cloud.posts;

import com.nixmash.cloud.core.model.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.TypeReferences;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by daveburke on 5/30/17.
 */

@RunWith(SpringRunner.class)
public class PostRestTests extends AbstractContext {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
    }

    // region ParameterizedReturnTypes

    /**
     * ReturnType Classes replace duplicates of variant:
     * <p>
     * ParameterizedTypeReference<PagedResources<Post>> responseType =
     * new ParameterizedTypeReference<PagedResources<Post>>() {
     * };
     */
    private static final class PagedResourceReturnType extends TypeReferences.PagedResourcesType<Post> {
    }
    private static final class ResourcedReturnType extends TypeReferences.ResourcesType<Resource<Post>> {
    }

    // endregion

    // region MVC tests

    @Test
    public void getRestPostsMvcTest() throws Exception {
        mockMvc.perform(get("/posts"))
                .andExpect(status().isOk());
    }

    @Test
    public void getPostMvcTest() throws Exception {
        Integer id = 1;
        mockMvc.perform(get("/posts/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("postId").value(id));
    }

    // endregion

    // region Post RestTemplate tests

    @Test
    public void getPostWithRestTemplateTest() throws Exception {
        ResponseEntity<Resource<Post>> responseEntity
                = restTemplate.exchange("http://localhost:8000/posts/1",
                HttpMethod.GET, null, new ParameterizedTypeReference<Resource<Post>>() {
                });

        Post post = responseEntity.getBody().getContent();
        assertThat(post.getPostId()).isEqualTo(1);
    }

    @Test
    public void getPageResourcedPostsListTest() throws Exception {

        ResponseEntity<PagedResources<Post>> responseEntity =
                restTemplate.exchange("http://localhost:8000/posts",
                        HttpMethod.GET, null, new PagedResourceReturnType());

        PagedResources<Post> resources = responseEntity.getBody();
        List<Post> posts = new ArrayList<>(resources.getContent());
        assertThat(posts.size()).isGreaterThan(1);

    }

    @Test
    public void getResourcedPostsListTest() throws Exception {

        ResponseEntity<Resources<Resource<Post>>> responseEntity =
                restTemplate.exchange("http://localhost:8000/posts",
                        HttpMethod.GET, null, new ResourcedReturnType());

        Collection<Resource<Post>> posts = responseEntity.getBody().getContent();
        assertThat(posts.size()).isGreaterThan(1);
    }

    @Test
    public void postTitlesProjectionTest() throws Exception {

        Post post;
        ResponseEntity<PagedResources<Post>> responseEntity;
        PagedResources<Post> resources;
        List<Post> posts;

        responseEntity = restTemplate.exchange("http://localhost:8000/posts",
                        HttpMethod.GET, null, new PagedResourceReturnType());

        resources = responseEntity.getBody();
        posts = new ArrayList<>(resources.getContent());
        post = posts.get(0);
        assertNotNull(post.getPostName());

        responseEntity = restTemplate.exchange("http://localhost:8000/posts?projection=postTitles",
                HttpMethod.GET, null, new PagedResourceReturnType());

        resources = responseEntity.getBody();
        posts = new ArrayList<>(resources.getContent());
        post = posts.get(0);
        assertNull(post.getPostName());
    }

    // endregion

}
