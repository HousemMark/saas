package com.unit.api.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.route.RibbonCommandFactory;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.context.annotation.Bean;

import java.util.Collections;
import java.util.Set;

@SpringBootApplication (scanBasePackages = {"com.unit.*"})
@EnableZuulProxy
@EnableFeignClients (basePackages = "com.unit.api.common.*")
public class ApiWebApplication {

    @Autowired (required = false)
    private Set<ZuulFallbackProvider> zuulFallbackProviderSet = Collections.emptySet();

    public static void main(String[] args) {
        SpringApplication.run(ApiWebApplication.class, args);
    }

//    /**
//     * 负载均衡
//     */
//    @Bean
//    @ConditionalOnMissingBean
//    public RibbonCommandFactory<?> ribbonCommandFactory(SpringClientFactory clientFactory, ZuulProperties zuulProperties) {
//        return new UnitHttpCliemtRibbonCommandFactory(clientFactory, zuulProperties, zuulFallbackProviderSet);
//    }
}
