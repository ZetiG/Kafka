package com.example.demo.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerController {
    @KafkaListener(topics = "test01")
    public void listen (ConsumerRecord<?, ?> record) {
        System.out.printf("topic = %s, offset = %s, value = %s \n", record.topic(), record.key(), record.value());
    }
}
