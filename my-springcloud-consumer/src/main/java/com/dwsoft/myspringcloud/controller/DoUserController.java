package com.dwsoft.myspringcloud.controller;

import com.dwsoft.myspringcloud.api.UserRemoteService;
import com.dwsoft.myspringcloud.entity.User;
import com.dwsoft.myspringcloud.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @Autowired
    private UserRemoteService userRemoteService;
    @RequestMapping("/consumer/get/user")
    public User getUser() {
        String host = "http://my-springcloud-provider";//服务提供工程的配置文件
        String url="/provider/get/user";      //服务提供工程的controller
        return restTemplate.getForObject(host+url,User.class);
    }

    @RequestMapping("/consumer/get/user/by/id")
    public User getUserById(@RequestParam("userId") Integer userId) {
        return userRemoteService.getUserById(userId);
    }

    /**
     * 用于测试熔断机制
     * @param code
     * @return
     */
    @RequestMapping("/consumer/get/user/by/code")
    public ResultEntity<User> getUserByCode(@RequestParam("code") String code) {
        return userRemoteService.getUserByCode(code);
    }
}
