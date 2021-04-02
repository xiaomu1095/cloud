package com.example.book.feign;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaom
 * @Date 2021/4/1
 * @Time 17:22
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLevel() {
        return Logger.Level.FULL;
    }
}
