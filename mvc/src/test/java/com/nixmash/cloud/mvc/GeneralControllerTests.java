package com.nixmash.cloud.mvc;

import com.nixmash.cloud.core.model.Post;
import com.nixmash.cloud.mvc.controller.GeneralController;
import com.nixmash.cloud.mvc.io.PostReader;
import com.nixmash.cloud.mvc.ui.WebUI;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.Resources;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static com.nixmash.cloud.mvc.controller.GeneralController.HOME_VIEW;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by daveburke on 6/2/17.
 */
@RunWith(SpringRunner.class)
public class GeneralControllerTests  extends AbstractContext {

    // region Beans

    private MockMvc mockMvc;

    @Autowired
    private WebUI webUI;

    @MockBean
    private PostReader postReader;

    // endregion

    @Before
    public void setUp() {
        GeneralController generalController = new GeneralController(webUI, postReader);
        mockMvc = MockMvcBuilders.standaloneSetup(generalController).build();

        Resources<Post> posts = new Resources<>(new ArrayList<>());
        when(postReader.recent()).thenReturn(posts);
    }

    @Test
    public void homePageTest() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("posts"))
                .andExpect(view().name(HOME_VIEW));
    }
}
