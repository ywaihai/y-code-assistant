package com.waihai.ycodeassistant;

import dev.langchain4j.community.store.embedding.redis.spring.RedisEmbeddingStoreAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {RedisEmbeddingStoreAutoConfiguration.class})
@MapperScan("com.waihai.ycodeassistant.mapper")
public class    YCodeAssistantApplication {

    public static void main(String[] args) {
        SpringApplication.run(YCodeAssistantApplication.class, args);
    }

}
