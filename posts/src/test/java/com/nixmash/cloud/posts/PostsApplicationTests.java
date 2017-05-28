package com.nixmash.cloud.posts;

import com.nixmash.cloud.core.config.CoreConfig;
import com.nixmash.cloud.core.enums.SpringProfile;
import com.nixmash.cloud.posts.config.PostsConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = {CoreConfig.class, PostsConfig.class })
@ActiveProfiles(SpringProfile.H2)
@SpringBootTest
public class PostsApplicationTests {

	@Test
	public void contextLoads() {
	}

}
