package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@MapperScan(value = "com.example.demo.mapper")

@ComponentScan("com.example.demo.*")
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableTransactionManagement
@EnableCaching
public class LoveAndPeaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoveAndPeaceApplication.class, args);
    }

}
