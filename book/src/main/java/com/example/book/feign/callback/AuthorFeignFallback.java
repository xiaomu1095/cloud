package com.example.book.feign.callback;

import com.example.book.feign.AuthorFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author xiaom
 * @Date 2021/4/1
 * @Time 17:19
 */
@Component
public class AuthorFeignFallback implements AuthorFeignClient {

    @Override
    public String findUserInfo(Long userId) {
        return "Book-系统回调";
    }
}
