package com.hom.springdemo.service;

import com.hom.springdemo.entity.SysUser;
import com.hom.springdemo.exception.BusinessException;
import com.hom.springdemo.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by Hom_Wang on 2020-03-20.
 */
@Service
public class LoginService {

    private final JwtTokenUtil jwtTokenUtil;

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    public LoginService(PasswordEncoder passwordEncoder,
                        JwtTokenUtil jwtTokenUtil,
                        @Qualifier("jwtUserDetailsService") UserDetailsService userDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    public String login(SysUser sysUser) {
        final UserDetails userDetails = userDetailsService.loadUserByUsername(sysUser.getUsername());
        if (!passwordEncoder.matches(sysUser.getPassword(), userDetails.getPassword())) {
            throw new BusinessException("密码不正确");
        }
        return jwtTokenUtil.generateToken(userDetails);
    }
}
