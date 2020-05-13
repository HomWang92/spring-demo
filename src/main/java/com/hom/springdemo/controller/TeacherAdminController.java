package com.hom.springdemo.controller;

import com.hom.springdemo.model.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class TeacherAdminController {


    @GetMapping
    public R list() {
        List<String> list = new ArrayList<>();
        return R.ok().data("itms", list).message("用户列表");
    }
}    