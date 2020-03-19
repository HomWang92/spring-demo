package com.hom.springdemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "用户模块")
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @ApiOperation("测试")
    @GetMapping(value = "/test")
    public String test() {
        return "Hello Spring Security";
    }

    @ApiOperation("待权限")
    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping(value = "/testNeed")
    public String testNeed() {
        return "testNeed";
    }
}