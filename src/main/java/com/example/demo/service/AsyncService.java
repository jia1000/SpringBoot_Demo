package com.example.demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    // 异步处理注解 @Async
    @Async
    public void AsyncHandle1() {
        System.out.println("数据初始化中...");

        try {
            System.out.println("处理数据中...");
            Thread.sleep(7000);
            System.out.println("处理完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
