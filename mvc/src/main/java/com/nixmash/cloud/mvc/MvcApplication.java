package com.nixmash.cloud.mvc;

import com.nixmash.cloud.core.model.Post;
import com.nixmash.cloud.mvc.config.MvcConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@EnableZuulProxy
@EnableDiscoveryClient
//@EnableFeignClients
//@EnableAspectJAutoProxy(proxyTargetClass = true)
//@IntegrationComponentScan
@SpringBootApplication
public class MvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvcConfig.class, args);
    }

    @FeignClient("posts")
    interface ReservationReader {

        @RequestMapping(method = RequestMethod.GET, value = "/posts")
        List<Post> read();
    }

}
