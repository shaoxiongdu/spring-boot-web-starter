package cn.shoxiongdu.springbootwebstarter.mapper;

import cn.shoxiongdu.springbootwebstarter.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserMapperTest {

    @Autowired UserMapper userMapper;

    @Test
    void test(){

//        userMapper.insert(makeUser());


        userMapper.deleteById(11);
        System.out.println(userMapper.selectList(null));

//        User user = makeUser();
//        user.setId(11L);
//        user.setUsername("shaoxiong");
//        userMapper.updateById(user);
    }

    User makeUser(){
      User user = new User();
      user.setEmail("email@shaoxiongdu.cn");
      user.setPhone("15603430511");
      user.setPassword("123456");
      return user;
    }

}
