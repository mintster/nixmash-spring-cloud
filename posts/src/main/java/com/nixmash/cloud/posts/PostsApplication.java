package com.nixmash.cloud.posts;

import com.nixmash.cloud.core.enums.SpringProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.stereotype.Component;

@EnableDiscoveryClient
@EnableAspectJAutoProxy(proxyTargetClass = true)
@IntegrationComponentScan
@SpringBootApplication
public class PostsApplication {

	private static final Logger logger = LoggerFactory.getLogger(PostsApplication.class);

	@Component
	@Profile(SpringProfile.MYSQL)
	class Runner implements CommandLineRunner {

		@Value("${message}")
		String message;

		@Override
		public void run(String... args) throws Exception {
			logger.info(message);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(PostsApplication.class, args);
	}
}