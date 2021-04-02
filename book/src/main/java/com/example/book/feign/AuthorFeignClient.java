package com.example.book.feign;

import com.example.book.feign.callback.AuthorFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiaom
 * @Date 2021/4/1
 * @Time 17:09
 */
@FeignClient(value = "user", fallback = AuthorFeignFallback.class, path = "/user")
//@RequestMapping("/user")
public interface AuthorFeignClient {

    //调⽤的请求路径
    //@RequestMapping(value = "/id/{userId}",method=  RequestMethod.GET)
    @GetMapping("/id/{userId}")
    //这里的value=userID ==> 必须得写上
    String findUserInfo(@PathVariable(value = "userId") Long userId);

}
