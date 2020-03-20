package com.hom.springdemo.security;

import com.hom.springdemo.entity.SysUser;
import com.hom.springdemo.exception.BusinessException;
import com.hom.springdemo.repository.SysUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    private final SysUserRepository sysUserRepository;

    public JwtUserDetailsService(SysUserRepository sysUserRepository) {
        this.sysUserRepository = sysUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println("JwtUserDetailsService:" + userName);
        Optional<SysUser> byUsername = sysUserRepository.findByUsername(userName);
//        if (!byUsername.isPresent()) {
//            throw new BusinessException("用户不存在");
//        }
        SysUser sysUser = byUsername.get();
//        if(){
//
//        }
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority(sysUser.getRole()));
        return new SecurityUserDetails(sysUser.getUsername(), authorityList);
    }

}