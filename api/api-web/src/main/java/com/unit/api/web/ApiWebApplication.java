package com.unit.api.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;

import java.util.Collections;
import java.util.Set;

@SpringBootApplication(scanBasePackages = {"com.unit.*"})
@EnableZuulProxy
//@EnableFeignClients(basePackages = "com.unit.api.core.*")
public class ApiWebApplication {

    @Autowired(required = false)
    private Set<ZuulFallbackProvider> zuulFallbackProviderSet = Collections.emptySet();

    public static void main(String[] args) {
        SpringApplication.run(ApiWebApplication.class, args);
    }

//    @Bean
//    @ConditionalOnMissingBean
//    public RibbonCommandFactory<?> ribbonCommandFactory(SpringClientFactory clientFactory, ZuulProperties zuulProperties) {
//        return new UnitHttpCliemtRibbonCommandFactory(clientFactory,zuulProperties, zuulFallbackProviderSet);
//    }
}
