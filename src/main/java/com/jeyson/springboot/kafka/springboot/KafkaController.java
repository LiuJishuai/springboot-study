package com.jeyson.springboot.kafka.springboot;

import com.jeyson.springboot.common.model.JsonResult;
import com.jeyson.springboot.utils.NoLogin;
import org.apache.kafka.common.protocol.types.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: liujishuai
 * @Time: 2018/6/6 9:50
 * @Description:
 */
@RestController
public class KafkaController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    KafkaTemplate kafkaTemplate;

    @NoLogin
    @RequestMapping("/send")
    public JsonResult senMsg(String msg){
        try {
            logger.info("KafkaController senMsg: msg = {}", msg);
            kafkaTemplate.send("test",msg);
        }catch (Exception e){
        }
        return JsonResult.createSuccessResult(null);
    }
}
