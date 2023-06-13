package cn.shoxiongdu.springbootwebstarter.service.impl;

import cn.shoxiongdu.springbootwebstarter.entity.User;
import cn.shoxiongdu.springbootwebstarter.mapper.UserMapper;
import cn.shoxiongdu.springbootwebstarter.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{


}
