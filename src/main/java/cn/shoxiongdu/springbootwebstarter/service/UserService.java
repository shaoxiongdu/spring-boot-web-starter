package cn.shoxiongdu.springbootwebstarter.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.shoxiongdu.springbootwebstarter.entity.User;
import cn.shoxiongdu.springbootwebstarter.request.user.LoginRequest;
import cn.shoxiongdu.springbootwebstarter.response.base.Resp;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService extends IService<User> {
    Resp<SaTokenInfo> login(LoginRequest requestBody, HttpServletRequest request);
}
