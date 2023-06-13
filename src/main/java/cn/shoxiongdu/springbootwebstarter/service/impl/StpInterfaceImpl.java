package cn.shoxiongdu.springbootwebstarter.service.impl;

import cn.dev33.satoken.stp.StpInterface;
import cn.shoxiongdu.springbootwebstarter.entity.Permission;
import cn.shoxiongdu.springbootwebstarter.entity.Role;
import cn.shoxiongdu.springbootwebstarter.entity.RolePermission;
import cn.shoxiongdu.springbootwebstarter.entity.UserRoles;
import cn.shoxiongdu.springbootwebstarter.mapper.PermissionMapper;
import cn.shoxiongdu.springbootwebstarter.mapper.RoleMapper;
import cn.shoxiongdu.springbootwebstarter.mapper.RolePermissionMapper;
import cn.shoxiongdu.springbootwebstarter.mapper.UserRolesMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 自定义权限验证接口扩展
 */
@Component    // 保证此类被SpringBoot扫描，完成Sa-Token的自定义权限验证扩展
@AllArgsConstructor
public class StpInterfaceImpl implements StpInterface {

    UserRolesMapper userRolesMapper;
    RolePermissionMapper rolePermissionMapper;
    PermissionMapper permissionMapper;
    RoleMapper roleMapper;

    /**
     * 返回一个账号所拥有的权限码集合 
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {

        List<UserRoles> userRoles = userRolesMapper.selectList(new LambdaQueryWrapper<UserRoles>()
                .eq(UserRoles::getUserId, loginId));

        if (userRoles.isEmpty()) {
            return Collections.emptyList();
        }

        List<RolePermission> rolePermissionList = rolePermissionMapper.selectList(new LambdaQueryWrapper<RolePermission>()
                .in(RolePermission::getRoleId, userRoles.stream().map(UserRoles::getRoleId).toList()));

        if (rolePermissionList.isEmpty()) {
            return Collections.emptyList();
        }
        List<Permission> permissionsList = permissionMapper.selectList(new LambdaQueryWrapper<Permission>()
                .in(Permission::getId, rolePermissionList.stream().map(RolePermission::getPermissionId).toList()));

        return permissionsList.stream().map(Permission::getName).toList();
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {

        List<UserRoles> userRoles = userRolesMapper.selectList(new LambdaQueryWrapper<UserRoles>()
                .eq(UserRoles::getUserId, loginId));

        if (userRoles.isEmpty()) {
            return Collections.emptyList();
        }

        List<Role> roles = roleMapper.selectList(new LambdaQueryWrapper<Role>()
                .in(Role::getId, userRoles.stream().map(UserRoles::getRoleId).toList()));

        return roles.stream().map(Role::getName).toList();
    }

}
