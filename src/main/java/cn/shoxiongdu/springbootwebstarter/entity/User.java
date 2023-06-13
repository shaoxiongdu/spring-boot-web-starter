package cn.shoxiongdu.springbootwebstarter.entity;

import cn.shoxiongdu.springbootwebstarter.config.JsonLocalDateTimeSerializer;
import cn.shoxiongdu.springbootwebstarter.entity.base.BaseEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends BaseEntity {
    private String username = "";
    private String password = "";
    private String email = "";
    private String phone = "";
    private String nickName = "";

    @JsonSerialize(using = JsonLocalDateTimeSerializer.class)
    private LocalDateTime registrationDate = null;

    @JsonSerialize(using = JsonLocalDateTimeSerializer.class)
    private LocalDateTime lastLoginDate = null;
    private String lastLoginIp = "";
    private int userType = 0;
    private int status = 0;
}
