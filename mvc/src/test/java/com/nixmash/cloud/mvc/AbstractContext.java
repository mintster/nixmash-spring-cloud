package com.nixmash.cloud.mvc;

import com.nixmash.cloud.core.config.CoreConfig;
import com.nixmash.cloud.core.enums.SpringProfile;
import com.nixmash.cloud.mvc.config.MvcConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {CoreConfig.class, MvcConfig.class })
@SpringBootTest
@ActiveProfiles(SpringProfile.H2)
@TestPropertySource("classpath:test.properties")
public class AbstractContext {

	@Test
	public void contextLoads() {
	}

}
