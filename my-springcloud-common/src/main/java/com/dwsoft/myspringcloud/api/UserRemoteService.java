package com.dwsoft.myspringcloud.api;

import com.dwsoft.myspringcloud.entity.User;
import com.dwsoft.myspringcloud.factory.MyFallBackFactory;
import com.dwsoft.myspringcloud.util.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author tlk
 * @date 2020/7/14-9:50
 */
@Component    //按道理不加这个注解也可以，但是在DoUserController.java中没法注入，加上也不影响
@FeignClient(value = "my-springcloud-provider",fallbackFactory = MyFallBackFactory.class) //value :指定服务名称 ,fallbackFactory: 指定 FallbackFactory 类型的类，保证备用方案返回相同类型的数据
public interface UserRemoteService {
    @RequestMapping("/provider/get/user/by/id")
    public User getUserById(@RequestParam("userId") Integer userId);

    /**
     * 测试熔断机制
     * @param code
     * @return
     */
    @RequestMapping("/provider/get/user/by/code")
    public ResultEntity<User> getUserByCode(@RequestParam("code") String code);
}
