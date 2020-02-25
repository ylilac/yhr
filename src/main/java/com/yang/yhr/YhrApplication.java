package com.yang.yhr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yang.yhr.dao")
public class YhrApplication {
    public static void main(String[] args) {
        SpringApplication.run(YhrApplication.class, args);
    }

}
