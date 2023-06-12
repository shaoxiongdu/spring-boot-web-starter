package cn.shoxiongdu.springbootwebstarter.entity;

import cn.shoxiongdu.springbootwebstarter.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends BaseEntity {
    private String username = "";
    private String password = "";
    private String email = "";
    private String phone = "";
    private String nickName = "";
    private LocalDateTime registrationDate = LocalDateTime.now();
    private LocalDateTime lastLoginDate = LocalDateTime.now();
    private String lastLoginIp = "";
    private int userType = 0;
    private int status = 0;
}
