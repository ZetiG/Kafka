package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auth zmk
 * @Date 2019/2/17
 * @Desc
 */
@RestController
@RequestMapping("/kafka")
public class ProducerController {
    protected final Logger logger = LoggerFactory.getLogger(ProducerController.class);
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/send")
    public String sendKafka(String message) {
        try {
            logger.info("kafka的消息={}", message);
            kafkaTemplate.send("test01", "key", message);
            logger.info("发送kafka成功.");
            return "success";
        } catch (Exception e) {
            logger.info("发送失败.");
            return "failure";
        }
    }
}
