package com.xiangxue.jack.conditional;

import com.xiangxue.jack.bean.Role;
import com.xiangxue.jack.bean.User;
import com.xiangxue.jack.bean.ZgGoods;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigFamliy {




    /*
    * 存在People实例化才会调用该方法
    * */
    @Bean
    @ConditionalOnBean(name = "jack")
    public Famliy getFamliy(People people) {
        JackFamliy jackFamliy = new JackFamliy();
        jackFamliy.setPeople(people);
        people.toString();
        return jackFamliy;
    }

    @Bean("jack")
    public People getPeople() {
        Jack jack = new Jack();
        jack.setUsername("jack");
        return jack;
    }

    /*
    * 当类路径上存在该类时才会实例化Role
    * 类路径存在该类时，才会调用该方法
    * */
    @Bean
    @ConditionalOnClass(name = "com.xiangxue.jack.controller.JackController1")
    public Role getRole() {
        System.out.println("======ConfigFamliy.getRole====");
        return new Role();
    }


    /*
    * 当类路径不存在该类是，调用方法
    * */
    @Bean
    @ConditionalOnMissingClass(value = "com.xiangxue.jack.controller.JackController1")
    public ZgGoods zgGoods() {
        System.out.println("======ConfigFamliy.zgGoods====");
        return new ZgGoods();
    }

    /*
    * 当不存在某对象时调用该方法
    * */
    @Bean
    @ConditionalOnMissingBean(name = "jack")
    public User getUser() {
        System.out.println("======ConfigFamliy.getUser====");
        return new User();
    }

    /*
    * 当表达式成立时调用该方法
    * */
    @Bean
    @ConditionalOnExpression("${spring.datasource.max-idle}==10")
    public void conditionalOnExpressionTest() {
        System.out.println("======ConfigFamliy.conditionalOnExpressionTest");
    }

    /*
    * 当存在配置时调用该方法
    * */
    @Bean
    @ConditionalOnProperty(prefix = "spring.redis", name = "host", havingValue = "192.168.67.139")
    public void conditionalOnPropertyTest() {
        System.out.println("======ConfigFamliy.conditionalOnPropertyTest");
    }

    @Bean
    @Conditional(value = CustomCondition.class)
    public User conditionalTest() {
        System.out.println("======ConfigFamliy.conditionalTest");
        return new User();
    }
}
