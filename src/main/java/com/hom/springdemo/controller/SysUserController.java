package com.hom.springdemo.controller;

import com.hom.springdemo.entity.SysUser;
import com.hom.springdemo.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Api(description = "用户模块")
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    private final SysUserService sysUserService;

    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

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

    @ApiOperation("注册")
    @PostMapping("/reg")
    public SysUser reg(@RequestBody SysUser sysUser) {
        return sysUserService.save(sysUser);
    }
}