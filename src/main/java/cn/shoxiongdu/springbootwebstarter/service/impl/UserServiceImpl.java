package cn.shoxiongdu.springbootwebstarter.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import cn.shoxiongdu.springbootwebstarter.entity.User;
import cn.shoxiongdu.springbootwebstarter.mapper.UserMapper;
import cn.shoxiongdu.springbootwebstarter.request.user.LoginRequest;
import cn.shoxiongdu.springbootwebstarter.response.base.Resp;
import cn.shoxiongdu.springbootwebstarter.response.base.RespENUM;
import cn.shoxiongdu.springbootwebstarter.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

    UserMapper userMapper;

    @Override
    public Resp<SaTokenInfo> login(LoginRequest request) {

        User user = userMapper.selectOne(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, request.getUsername())
                .eq(User::getPassword, request.getPassword()));

        if (user == null) {
            return Resp.error(RespENUM.CLIENT_ERROR_AUTH_LOGIN);
        }

        StpUtil.login(user.getId());
        StpUtil.getSession().set("user",user);
        return Resp.success(StpUtil.getTokenInfo());
    }
}
