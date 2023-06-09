package cn.itcast.user.service;

import cn.itcast.user.mapper.UserMapper;
import cn.itcast.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
@RefreshScope //配置nacos热更新
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Value("${pattern.dateformat}")
    private String format;

    public User queryById(Long id) {
        return userMapper.findById(id);
    }

    public String now(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
    }
}