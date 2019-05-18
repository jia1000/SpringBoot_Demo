package com.example.demo.controler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQControllerTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    // 发送 一个消息到RabbitMQ
    @Test
    public void sendRabbitMQ() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "这是第一个消息");
        map.put("data", Arrays.asList("hello", 123, true));

        rabbitTemplate.convertAndSend("exchange.direct", "mytest.news", map);
    }

    // 接收 一个消息到RabbitMQ
    @Test
    public void receiveRabbitMQ() {
        Object o  = rabbitTemplate.receiveAndConvert("mytest.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    // 创建RabbitMQ 的Exchage、 Queue、binding等
    @Test
    public void createRabbitMQBind() {
        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
        System.out.println("创建Exchange完成");

        amqpAdmin.declareQueue(new Queue("amqpadmin.queue", true));
        System.out.println("创建Queue完成");

        amqpAdmin.declareBinding(
                new Binding(
                        "amqpadmin.queue",
                        Binding.DestinationType.QUEUE,
                        "amqpadmin.exchange",
                        "amqpadmin.exchange",
                        null
                ) );
        System.out.println("创建Binding完成");
    }

    // 发送一个消息，给自己创建的Exchange
    @Test
    public void sendRabbitMQ_amqp() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "这是一个amqp消息");
        map.put("data", Arrays.asList("hello", 123, true));

        rabbitTemplate.convertAndSend("amqpadmin.exchange", "amqpadmin.exchange", map);
    }

    // 接收 一个消息，从自己创建的Queue
    @Test
    public void receiveRabbitMQ_amqp() {
        Object o  = rabbitTemplate.receiveAndConvert("amqpadmin.queue");
        System.out.println(o.getClass());
        System.out.println(o);
    }
}
