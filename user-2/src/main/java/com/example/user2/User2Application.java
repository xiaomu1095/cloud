package com.example.user2;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class User2Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(User2Application.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }

}
