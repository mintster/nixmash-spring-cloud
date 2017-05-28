package com.nixmash.cloud.posts;

import com.nixmash.cloud.posts.config.PostsConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class PostsApplication {

	@Component
	class Runner implements CommandLineRunner {

		@Value("${message}")
		String message;

		@Override
		public void run(String... args) throws Exception {
			System.out.println(message);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(PostsConfig.class, args);
	}
}
