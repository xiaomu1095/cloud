package com.example.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaom
 * @Date 2021/4/1
 * @Time 15:56
 */
@RestController
public class UserController {

    @Value("${server.port}")
    private Integer port;


    @GetMapping("/id/{userId}")
    public String findUserById(@PathVariable Long userId) {
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("===》》》》》》》》》》》》我是" + port);
        return "User--传入参数：" + userId + "；端口：" + port;
    }

}
