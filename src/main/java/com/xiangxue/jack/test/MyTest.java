package com.xiangxue.jack.test;

import com.xiangxue.jack.bean.ConsultConfigArea;
import com.xiangxue.jack.mongo.MongoService;
import com.xiangxue.jack.mongo.User;
import com.xiangxue.jack.redisRepositories.Person;
import com.xiangxue.jack.redisRepositories.PersonRepository;
import com.xiangxue.jack.service.AreaService;
import com.xiangxue.jack.start.SpringbootTest;
import com.xx.jack.start.JackTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootTest.class)
@WebAppConfiguration
public class MyTest {

    private static final Logger logger = LoggerFactory.getLogger(MyTest.class);

    @Autowired
    AreaService areaService;

    @Autowired
    MongoService mongoService;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    JackTemplate jackTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void test1() {
        List<ConsultConfigArea> areas = areaService.qryArea(new HashMap());
        for (ConsultConfigArea area : areas) {
            logger.info(area.getAreaCode() + "   " + area.getAreaName() + "   "
                    + area.getState());
        }
    }

    @Test
    public void mongoTest() {
        User user = new User();
        user.setUsername("jack");
        user.setPassword("123");
        user.setId("87");
        mongoService.save(user);
    }

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void redisRepositories() {
        Person person = new Person();
        person.setUsername("James");
        person.setPassword("123xxee");
        personRepository.save(person);

        //resp
    }
}
