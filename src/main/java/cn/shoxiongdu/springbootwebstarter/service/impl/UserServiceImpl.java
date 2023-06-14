package cn.shoxiongdu.springbootwebstarter.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.shoxiongdu.springbootwebstarter.entity.User;
import cn.shoxiongdu.springbootwebstarter.mapper.UserMapper;
import cn.shoxiongdu.springbootwebstarter.request.user.EnrollRequest;
import cn.shoxiongdu.springbootwebstarter.request.user.LoginRequest;
import cn.shoxiongdu.springbootwebstarter.response.base.Resp;
import cn.shoxiongdu.springbootwebstarter.response.base.RespENUM;
import cn.shoxiongdu.springbootwebstarter.service.UserService;
import cn.shoxiongdu.springbootwebstarter.utils.RequestUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    UserMapper userMapper;

    @Override
    public Resp<SaTokenInfo> login(LoginRequest requestBody, HttpServletRequest request) {

        User user = userMapper.selectOne(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, requestBody.getUsername())
                .eq(User::getPassword, requestBody.getPassword()));

        if (user == null) {
            return Resp.error(RespENUM.CLIENT_ERROR_AUTH_LOGIN);
        }

        user.setLastLoginDate(LocalDateTime.now());
        user.setLastLoginIp(RequestUtils.getIpAddress(request));
        userMapper.updateById(user);

        StpUtil.login(user.getId());
        StpUtil.getSession().set("user", user);
        return Resp.success(StpUtil.getTokenInfo());
    }

    @Override
    public Resp<Boolean> enroll(EnrollRequest request) {

        Long count = userMapper.selectCount(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, request.getUsername()));
        if (count > 0) {
            return Resp.error(405, "用户名已存在");
        }

        User user = new User();
        BeanUtils.copyProperties(request, user);
        user.setRegistrationDate(LocalDateTime.now());
        userMapper.insert(user);
        return Resp.success(true);
    }
}
