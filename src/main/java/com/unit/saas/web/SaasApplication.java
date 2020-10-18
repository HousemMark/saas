package com.unit.saas.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 */
@SpringBootApplication(scanBasePackages = {"com.unit.saas.*"})
@MapperScan(basePackages = {"com.unit.saas.dal.mapper"})
public class SaasApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaasApplication.class, args);
    }

}
