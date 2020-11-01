package com.mavel.unit.web;


import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author HouseMark
 */
@SpringBootApplication(scanBasePackages = {"com.mavel.unit.*"})
@MapperScan("com.mavel.unit.dal.mapper")
public class UnitStarterWebApplication {

    private static Logger log = LoggerFactory.getLogger(UnitStarterWebApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(UnitStarterWebApplication.class, args);
        log.info("============== 启动完成！===============");
    }
}
