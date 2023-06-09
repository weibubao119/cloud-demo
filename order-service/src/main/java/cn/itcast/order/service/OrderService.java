package cn.itcast.order.service;

import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.feignClients.UserClient;

import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Autowired
    UserClient userClient;

//    @Autowired
//    private RestTemplate restTemplate;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        //2。查询用户信息
//        String url = "http://userservice/user/"+order.getUserId();
//        User user = restTemplate.getForObject(url, User.class);
      User user =  userClient.queryById(order.getUserId());
        //3.封装到order
        order.setUser(user);
        // 4.返回
        return order;
    }

    //默认情况下service层的方法是不会被sentinel监控的，需要我们自己通过注解来标记要监控的方法
    @SentinelResource("/goods")
    public void queryGoods(){
        System.err.println("查询商品");
    }
}
