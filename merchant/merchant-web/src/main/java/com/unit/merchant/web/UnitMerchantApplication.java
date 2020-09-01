package com.unit.merchant.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Administrator
 */
@SpringBootApplication(scanBasePackages = {"com.unit.merchant.*"})
@MapperScan(basePackages = {"com.unit.merchant.dal.mapper"})
public class UnitMerchantApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnitMerchantApplication.class, args);
    }

}
