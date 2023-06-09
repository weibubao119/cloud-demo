package com.example.feignClients;


import com.example.feignClients.fallback.UserClientFallBackFactory;
import com.example.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "gateway-service",fallbackFactory = UserClientFallBackFactory.class) //把请求发送到gateway网关，在gateway网关中配置了断言：是/usr/** 的请求路径都会到userservice路径下
public interface UserClient {

    @GetMapping("/user/{id}")
    User queryById(@PathVariable("id") Long id);

}
