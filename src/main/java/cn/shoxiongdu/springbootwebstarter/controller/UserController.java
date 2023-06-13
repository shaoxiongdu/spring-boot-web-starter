package cn.shoxiongdu.springbootwebstarter.controller;

import cn.shoxiongdu.springbootwebstarter.entity.User;
import cn.shoxiongdu.springbootwebstarter.response.base.Resp;
import cn.shoxiongdu.springbootwebstarter.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
