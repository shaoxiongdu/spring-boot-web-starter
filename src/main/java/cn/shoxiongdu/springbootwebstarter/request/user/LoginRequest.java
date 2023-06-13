package cn.shoxiongdu.springbootwebstarter.request.user;

import lombok.Data;

import javax.swing.*;

@Data
public class LoginRequest {
    String username;
    String password;
}
