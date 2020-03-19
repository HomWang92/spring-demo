package com.hom.springdemo.controller;

import com.hom.springdemo.security.JwtTokenUtil;
import com.hom.springdemo.entity.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(description = "登录模块")
@RestController
public class LoginController {

    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @ApiOperation("登录")
    @PostMapping("/login")
    public String login(@RequestBody SysUser sysUser, HttpServletRequest request) {
        final UserDetails userDetails = userDetailsService.loadUserByUsername(sysUser.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return token;
    }

    @ApiOperation("哈哈")
    @PostMapping("haha")
    public String haha() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return "haha:" + userDetails.getUsername() + "," + userDetails.getPassword();
    }
}