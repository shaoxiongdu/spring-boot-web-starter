package cn.shoxiongdu.springbootwebstarter.entity.user;

import cn.shoxiongdu.springbootwebstarter.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserRoles extends BaseEntity {
    private Long userId;
    private Long roleId;
}