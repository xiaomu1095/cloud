package com.example.book.controller;

import com.example.book.feign.AuthorFeignClient;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiaom
 * @Date 2021/3/31
 * @Time 17:49
 */
@RestController
public class BookController {

    @Value("${server.port}")
    private Integer port;

    // 直接使用Eureka
//    @Autowired
//    private EurekaClient eurekaClient;
    // 使用ribbon
//    @Autowired
//    private RestTemplate restTemplate;
    // 使用OpenFeign调用
    @Autowired
    private AuthorFeignClient authorFeignClient;


//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
//    },fallbackMethod = "findBookDefaultAuthorCallback")
//    @GetMapping("/author/{userId}")
//    public String findBookDefaultAuthor(@PathVariable Long userId){
//        String url = "http://user/user/id/" + userId;
//        String object = restTemplate.getForObject(url, String.class);
//        System.out.println(object);
//        return "Book--输入的参数：" + userId + "；系统端口：" + port;
//    }

    public String findBookDefaultAuthorCallback(Long userId){
        return "输入的参数：这是系统回调===========；系统端口：" + port;
    }


    @GetMapping("/author/{userId}")
    public String findBookDefaultAuthorByFeign(@PathVariable Long userId){
        System.out.println("Book--输入的参数：" + userId + "；系统端口：" + port);
        return authorFeignClient.findUserInfo(userId);
    }

}
