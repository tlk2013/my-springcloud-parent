package com.dwsoft.myspringcloud.factory;

import com.dwsoft.myspringcloud.api.UserRemoteService;
import com.dwsoft.myspringcloud.entity.User;
import com.dwsoft.myspringcloud.util.ResultEntity;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author tlk
 * @date 2020/7/15-9:54
 */
// 请注意自动扫描包的规则
@Component
public class MyFallBackFactory implements FallbackFactory<UserRemoteService> {

    // throwable 对象是失败原因对应的异常对象
    @Override
    public UserRemoteService create(Throwable throwable) {
        return new UserRemoteService() {
            @Override
            public User getUserById(Integer userId) {
                return null;
            }

            @Override
            public ResultEntity<User> getUserByCode(String code) {
                return ResultEntity.failed(throwable.getClass().getName()+":"+throwable.getMessage());
            }
        };
    }
}
