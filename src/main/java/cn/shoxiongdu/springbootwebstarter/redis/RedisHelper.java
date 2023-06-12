package cn.shoxiongdu.springbootwebstarter.redis;

import cn.hutool.db.nosql.redis.RedisDS;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Component
public final class RedisHelper {

    @Autowired
    private Environment environment;

//    private final Jedis jedis = RedisDS.create().getJedis();


//    public Jedis getJedis() {
//        return jedis;
//    }

    public String getKeyPrefix() {
        return Strings.isBlank(environment.getProperty("redis.key.prefix")) ? environment.getProperty("spring.application.name","") : environment.getProperty("redis.key.prefix");
    }
}
