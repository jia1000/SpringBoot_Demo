package com.example.demo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

// 定时任务 ： 2、创建定时任务的实现类：添加@Component注解
@Component
public class SchedulerTask {
    private int count = 0;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    // 定时任务 ：3、添加@Scheduled注解；此处cron的值，后面4个*之间是有空格的。
    // 时间间隔是30s
    @Scheduled(cron = "*/30 * * * * ?")
    private void process() {
        System.out.println("this is scheduler task running " + (count++));
    }

    // 时间间隔是10s
    @Scheduled(fixedRate = 10000)
    public void reportCurrentTime() {
        System.out.println("现在时间: " + dateFormat.format(new Date()));
    }
}
