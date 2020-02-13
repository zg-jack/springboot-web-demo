package com.xiangxue.jack.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduleConfig {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Scheduled(cron = "0 0/1 * * * ?") // 定义调度器
    public void job1() {
        logger.info("this is my first job execute");
    }
}
