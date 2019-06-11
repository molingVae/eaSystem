package com.upower.easystemservice;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.upower.easystemservice.mapper")
public class EasystemserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasystemserviceApplication.class, args);
    }

}
