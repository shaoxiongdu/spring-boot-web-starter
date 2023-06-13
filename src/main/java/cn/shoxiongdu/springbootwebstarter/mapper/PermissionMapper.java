package cn.shoxiongdu.springbootwebstarter.mapper;

import cn.shoxiongdu.springbootwebstarter.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
    // 可以在此处添加PermissionMapper特定的方法
}