package com.nixmash.cloud.posts.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.hateoas.mvc.TypeConstrainedMappingJackson2HttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daveburke on 5/28/17.
 */
@Configuration
@EnableDiscoveryClient
@EnableTransactionManagement
@EnableConfigurationProperties
@ComponentScan(basePackages = {"com.nixmash.cloud.posts", "com.nixmash.cloud.core"})
@EnableJpaRepositories(basePackages = "com.nixmash.cloud.posts.repository")
public class PostsConfig {

    @Autowired
    @Qualifier("halJacksonHttpMessageConverter")
    private TypeConstrainedMappingJackson2HttpMessageConverter halJacksonHttpMessageConverter;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> existingConverters = restTemplate.getMessageConverters();
        List<HttpMessageConverter<?>> newConverters = new ArrayList<>();
        newConverters.add(halJacksonHttpMessageConverter);
        newConverters.addAll(existingConverters);
        restTemplate.setMessageConverters(newConverters);
        return restTemplate;
    }
}
