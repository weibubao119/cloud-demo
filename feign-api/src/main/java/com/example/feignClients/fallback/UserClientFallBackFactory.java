package com.example.feignClients.fallback;

import com.example.feignClients.UserClient;
import com.example.pojo.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
public class UserClientFallBackFactory implements FallbackFactory<UserClient> {

    @Override
    public UserClient create(Throwable throwable) {
        return new UserClient() {
            @Override
            public User queryById(Long id) {
                log.error("查询用户异常", throwable);
                return new User();
            }
        };
    }
}
