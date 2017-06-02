package com.nixmash.cloud.mvc;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static com.nixmash.cloud.mvc.controller.PostController.POSTS_LIST_VIEW;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by daveburke on 6/2/17.
 */
public class PostControllerTests extends AbstractContext {

    // region Beans

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private Environment environment;

    private MockMvc mockMvc;

    // endregion

    @Before
    public void setUp() {
        mockMvc = webAppContextSetup(wac)
                .build();
    }

    @Test
    public void postsListPageTest() throws Exception {
        mockMvc.perform(get("/posts"))
                .andExpect(status().isOk())
                .andExpect(view().name(POSTS_LIST_VIEW));
    }
}
