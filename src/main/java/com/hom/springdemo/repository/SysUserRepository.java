package com.hom.springdemo.repository;

import com.hom.springdemo.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Hom_Wang on 2020-03-20.
 */
public interface SysUserRepository extends JpaRepository<SysUser, Integer> {

    Optional<SysUser> findByUsername(String userName);
}
