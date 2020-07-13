package com.dwsoft.myspringcloud.controller;

import com.dwsoft.myspringcloud.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tlk
 * @date 2020/7/13-14:40
 */
@RestController
public class UserController {

    @RequestMapping("/provider/get/user")
    public User getUser(){


        return new User(123,"小明","123@qq.com");
    }
}
