package com.dwsoft.myspringcloud.controller;

import com.dwsoft.myspringcloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author tlk
 * @date 2020/7/13-14:56
 */
@RestController
public class DoUserController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/get/user")
    public User getUser() {
        String host = "http://127.0.0.1:8081";//服务提供工程的配置文件
        String url="/provider/get/user";      //服务提供工程的controller
        return restTemplate.getForObject(host+url,User.class);
    }
}
