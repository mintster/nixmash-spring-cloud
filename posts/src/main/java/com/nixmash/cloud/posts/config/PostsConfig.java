package com.nixmash.cloud.posts.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by daveburke on 5/28/17.
 */
@Configuration
@EnableDiscoveryClient
@EnableTransactionManagement
@EnableConfigurationProperties
@ComponentScan(basePackages = {"com.nixmash.cloud.posts", "com.nixmash.cloud.core" })
@EnableJpaRepositories(basePackages = "com.nixmash.cloud.posts.repository")
public class PostsConfig {

}
