package com.xiangxue.jack.redisRepositories;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash(value = "persons",timeToLive = 60)
public class Person {

    @Id
    String id;

    private String username;

    private String password;
}
