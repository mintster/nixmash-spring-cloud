package com.nixmash.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigApplication {

/*	@Component
	class Runner implements CommandLineRunner {

		@Value("${message}")
		String message;

		@Override
		public void run(String... args) throws Exception {
			System.out.println(message);
		}
	}*/

	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class, args);
	}
}
