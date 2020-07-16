package com.dwsoft.myspringcloud.controller;

import com.dwsoft.myspringcloud.entity.User;
import com.dwsoft.myspringcloud.util.ResultEntity;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.dwsoft.myspringcloud.util.ResultEntity.successWithData;

/**
 * @author tlk
 * @date 2020/7/13-14:40
 */
@RestController
public class UserController {

    @RequestMapping("/provider/get/user")
    public User getUser(HttpServletRequest httpServletRequest){
        int serverPort = httpServletRequest.getServerPort();

        return new User(123,"小明 端口号"+serverPort,"123@qq.com");
    }

    @RequestMapping("/provider/get/user/by/id")
    public User getUserById(@RequestParam("userId") Integer userId){

        return new User(userId,"小明 接收到的id"+userId,"123@qq.com");
    }

    /**
     * 测试熔断的方法
     * @param code
     * @return
     */
    @HystrixCommand(fallbackMethod = "getUserByCodeBackup")
    @RequestMapping("/provider/get/user/by/code")
    public ResultEntity<User> getUserByCode(@RequestParam("code") String code){
        if("666".equals(code)){
            throw new RuntimeException("code如果是666，咱们就去调用备用方法");
        }
        User user=new User(12345,"小明 接收到的code="+code,"123@qq.com");
        return ResultEntity.successWithData(user);
    }

    /**
     * 备用方法
     * @param code
     * @return
     */

    public ResultEntity<User> getUserByCodeBackup(@RequestParam("code") String code){

        return ResultEntity.failed("因为你传的是666，所以异常，我是备用方法");
    }

}
