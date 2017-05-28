package com.nixmash.cloud.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class CoreApplication {

    public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//        ctx.register(CoreConfig.class);
//        ctx.refresh();
//        System.out.println("Spring Framework Version: " + SpringVersion.getVersion());
//        System.out.println("Spring Boot Version: " + SpringBootVersion.getVersion());
////        JpaUI ui = ctx.getBean(JpaUI.class);
////        ui.init();
//        ctx.close();
//    }
}
