package com.jeyson.springboot.kafka.java;

/**
 * @Author: liujishuai
 * @Time: 2018/6/4 14:49
 * @Description:
 */
public interface KafkaPropertites {
    final static String groupId = "group1";
    final static String topic = "topic1";
    final static String kafkaServerURL = "140.143.230.*";
    final static String zkConnect = kafkaServerURL+":2181";
    final static int kafkaServerPort = 9092;
    final static String kafkaBrokerList = kafkaServerURL+":"+kafkaServerPort;
    final static int kafkaProducerBufferSize = 64 * 1024;
    final static int connectionTimeOut = 20000;
    final static int reconnectInterval = 10000;
    final static String topic2 = "topic2";
    final static String topic3 = "topic3";
    final static String clientId = "SimpleConsumerDemoClient";
}
