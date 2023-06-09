package cn.itcast.order;

import com.example.config.DefaultFeignConfiguration;
import com.example.feignClients.UserClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients(clients = UserClient.class,defaultConfiguration = DefaultFeignConfiguration.class)  //开启feign客户端
@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }


    @Bean
    @LoadBalanced
    public RestTemplate RestTemplate(){
       return  new RestTemplate();
    }

}
