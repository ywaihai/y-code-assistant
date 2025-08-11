package com.waihai.ycodeassistant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.waihai.ycodeassistant.mapper")
public class    YCodeAssistantApplication {

    public static void main(String[] args) {
        SpringApplication.run(YCodeAssistantApplication.class, args);
    }

}
