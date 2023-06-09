package com.example.config;

import com.example.feignClients.fallback.UserClientFallBackFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultFeignConfiguration {

    @Bean
    public UserClientFallBackFactory userClientFallBackFactory(){
        return new UserClientFallBackFactory();
    }
}
