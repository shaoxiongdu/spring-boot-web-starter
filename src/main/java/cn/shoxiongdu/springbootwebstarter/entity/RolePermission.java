package cn.shoxiongdu.springbootwebstarter.entity;

import cn.shoxiongdu.springbootwebstarter.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RolePermission extends BaseEntity {
    private Long roleId;
    private Long permissionId;
}