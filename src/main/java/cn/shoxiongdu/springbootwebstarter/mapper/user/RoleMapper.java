package cn.shoxiongdu.springbootwebstarter.mapper.user;

import cn.shoxiongdu.springbootwebstarter.entity.user.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    // 可以在此处添加RoleMapper特定的方法
}