package com.xiangxue.jack.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class CustomCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        System.out.println("=====CustomCondition.matches======");
        String property = context.getEnvironment().getProperty("spring.redis.jedis.pool.max-active");

        if("8".equals(property)) {
            return false;
        } else {
            return true;
        }
    }
}
