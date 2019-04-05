package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
/**
 *  服务启动类
 */
@EnableCaching // 启动缓存
@SpringBootApplication
public class SpringCompanyTemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCompanyTemApplication.class, args);
    }

}
