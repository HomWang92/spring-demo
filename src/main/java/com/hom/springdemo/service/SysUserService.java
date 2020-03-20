package com.hom.springdemo.service;

import com.hom.springdemo.entity.SysUser;
import com.hom.springdemo.repository.SysUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by Hom_Wang on 2020-03-20.
 */
@Service
public class SysUserService {

    private final SysUserRepository sysUserRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

    public SysUserService(SysUserRepository sysUserRepository, PasswordEncoder bCryptPasswordEncoder) {
        this.sysUserRepository = sysUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    }

    /**
     * 新增
     *
     * @param sysUser
     * @return
     */
    public SysUser save(SysUser sysUser) {
        sysUser.setPassword(bCryptPasswordEncoder.encode(sysUser.getPassword()));
        return sysUserRepository.save(sysUser);
    }
}
