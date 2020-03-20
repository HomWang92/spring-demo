package com.hom.springdemo.controller;

import com.hom.springdemo.entity.SysUser;
import com.hom.springdemo.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Api(description = "登录模块")
@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    @ApiOperation("登录")
    @PostMapping("/login")
    public String login(@RequestBody SysUser sysUser) {
        return loginService.login(sysUser);
    }

    @ApiOperation("哈哈")
    @PostMapping("haha")
    public String haha() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return "haha:" + userDetails.getUsername() + "," + userDetails.getPassword();
    }
}