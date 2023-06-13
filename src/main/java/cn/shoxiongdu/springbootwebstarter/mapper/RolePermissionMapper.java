package cn.shoxiongdu.springbootwebstarter.mapper;

import cn.shoxiongdu.springbootwebstarter.entity.RolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RolePermissionMapper extends BaseMapper<RolePermission> {
    // 可以在此处添加RolePermissionMapper特定的方法
}