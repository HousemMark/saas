package com.unit.merchant.web.configuaration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: 智灵时代广州研发中心
 * @description:
 * @author: 小蜘蛛(mazhonghao)
 * @create: 2020-09-1 17:41
 **/
@Configuration
@EnableSwagger2
public class swaggerConfig {

    @Value ("${unit.swagger.title}")
    private String swaggerTitle;
    @Value ("${unit.swagger.description}")
    private String swaggerDescription;

    //api接口包扫描路径
    public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.unit.merchant.web";

    public static final String VERSION = "1.0.0";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //设置文档的标题
                .title(swaggerTitle)
                // 设置文档的描述
                .description(swaggerDescription)
                // 设置文档的版本信息-> 1.0.0 Version information
                .version(VERSION)
                // 设置文档的License信息(可自定义)->1.3 License information
                .termsOfServiceUrl("http://www.baidu.com")
                .build();
    }
}
