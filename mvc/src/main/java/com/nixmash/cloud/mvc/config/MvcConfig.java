package com.nixmash.cloud.mvc.config;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
@ComponentScan(basePackages = {"com.nixmash.cloud.mvc", "com.nixmash.cloud.core"})
public class MvcConfig {

}
