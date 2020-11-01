package com.mavel.unit.web;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.mavel.unit.*"})
@MapperScan("com.mavel.unit.dal.mapper")
public class UnitStarterWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnitStarterWebApplication.class, args);
    }
}
