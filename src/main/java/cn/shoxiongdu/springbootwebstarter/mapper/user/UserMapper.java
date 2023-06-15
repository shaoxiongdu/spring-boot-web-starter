package cn.shoxiongdu.springbootwebstarter.mapper.user;

import cn.shoxiongdu.springbootwebstarter.entity.user.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
