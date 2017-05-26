package com.nixmash.cloud.core;

import com.nixmash.cloud.core.config.CoreConfig;
import com.nixmash.cloud.core.enums.SpringProfile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CoreConfig.class)
@Transactional
@ActiveProfiles(SpringProfile.H2)
public class CoreApplicationTests {

	@Test
	public void contextLoads() {
	}

}
