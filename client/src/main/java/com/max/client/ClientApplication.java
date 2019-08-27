package com.max.client;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages={"com.max.*.mapper"})
@ComponentScan(basePackages = {
        "com.max.client",
        "com.max.base",
        "com.max.core",
        "com.max.money",
        "com.max.business",
        "com.max.event"})
public class ClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }
}
