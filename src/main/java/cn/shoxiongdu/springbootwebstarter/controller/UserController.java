package cn.shoxiongdu.springbootwebstarter.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import cn.shoxiongdu.springbootwebstarter.entity.User;
import cn.shoxiongdu.springbootwebstarter.request.user.LoginRequest;
import cn.shoxiongdu.springbootwebstarter.response.base.Resp;
import cn.shoxiongdu.springbootwebstarter.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    UserService userService;

    @GetMapping("/")
    public Resp<List<User>> getUserList(){
        return Resp.success(userService.list());
    }

    @PostMapping("/login")
    @Operation(summary = "登陆")
    public Resp<SaTokenInfo> login(@RequestBody LoginRequest request){
        return userService.login(request);
    }

    @Operation(summary = "检查登陆状态")
    @GetMapping("/login/isLogin")
    public Resp<Boolean> isLogin(){
        return Resp.success(StpUtil.isLogin());
    }

    @GetMapping("/tokenInfo")
    @Operation(summary = "查询token信息")
    public Resp<SaTokenInfo> tokenInfo() {
        return Resp.success(StpUtil.getTokenInfo());
    }

    @PostMapping("/logout")
    @Operation(summary = "退出登陆")
    public Resp<Boolean> logout() {
        StpUtil.logout();
        return Resp.success(true);
    }

    @GetMapping("/permissions")
    @Operation(summary = "权限列表")
    public Resp<List<String>> permissions() {
        StpUtil.checkPermission("test");
        return Resp.success(StpUtil.getPermissionList());
    }

}
