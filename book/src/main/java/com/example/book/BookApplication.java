package com.example.book;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@EnableHystrix    去掉Hystrix熔断的⽀持注解@EnableCircuitBreaker，因为Feign会⾃动引⼊，不需要显式指定
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class BookApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(BookApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }

//    //使用Resttemple进行远程调用,先对注入该对象
//    @LoadBalanced
//    @Bean
//    public RestTemplate getRestTemplete(){
//        return new RestTemplate();
//    }

}
