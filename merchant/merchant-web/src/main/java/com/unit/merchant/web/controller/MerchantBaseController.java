package com.unit.merchant.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: 智灵时代广州研发中心
 * @description:
 * @author: 小蜘蛛(mazhonghao)
 * @create: 2020-09-1 17:37
 **/
@Api("基本操作页面")
@RequestMapping("/base")
@RestController
public class MerchantBaseController {
    @ApiOperation("登录")
    @PostMapping("/login")
    public void login(@RequestParam("name") String name){
        System.out.println(name);
    }
}
