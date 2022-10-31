package com.lxk.enterprisecreditsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lxk.enterprisecreditsystem.mapper")
public class EnterpriseCreditSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnterpriseCreditSystemApplication.class, args);
    }

}
