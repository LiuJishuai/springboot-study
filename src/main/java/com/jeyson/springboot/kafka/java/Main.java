package com.jeyson.springboot.kafka.java;

/**
 * @Author: liujishuai
 * @Time: 2018/6/4 14:58
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        KafkaProducer producerThread = new KafkaProducer(KafkaPropertites.topic);
        producerThread.start();
        KafkaConsumer consumerThread = new KafkaConsumer(KafkaPropertites.topic);
        consumerThread.start();
    }
}
