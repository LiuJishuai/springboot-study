package com.jeyson.springboot.kafka.springboot;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * @Author: liujishuai
 * @Time: 2018/6/6 9:57
 * @Description:
 */
public class Listener {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());


//    @KafkaListener(topics = {"test"})
//    public void listen(ConsumerRecord<?, ?> record) {
//        logger.info("kafka-key: " + record.key());
//        logger.info("kafka-topic: " + record.topic());
//        logger.info("kafka-value: " + record.value().toString());
//    }
}
