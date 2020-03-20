package com.hom.springdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Hom_Wang on 2020-03-19.
 */
@Entity
@Data
@Table(name = "SysUser")
public class SysUser implements Serializable {
    private static final long serialVersionUID = -3301605591108950415L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;
    private String password;
    private String role;
    private String wxOpenId;

}
