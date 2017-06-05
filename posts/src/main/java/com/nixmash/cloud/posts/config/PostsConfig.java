package com.nixmash.cloud.posts.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.hateoas.mvc.TypeConstrainedMappingJackson2HttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by daveburke on 5/28/17.
 */

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.nixmash.cloud.posts", "com.nixmash.cloud.core"})
@EnableJpaRepositories(basePackages = "com.nixmash.cloud.posts.repository")
public class PostsConfig {

    @Autowired
    @Qualifier("halJacksonHttpMessageConverter")
    private TypeConstrainedMappingJackson2HttpMessageConverter halConverter;

    @Bean()
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> converters = restTemplate.getMessageConverters();
        converters.add(0, halConverter);
        restTemplate.setMessageConverters(converters);
        return restTemplate;
    }
}