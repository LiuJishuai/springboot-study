package com.jeyson.springboot.schedule;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: liujishuai
 * @Time: 2018/2/28 9:59
 * @Description:
 */
@Service
public class ScheduleService {

    @Scheduled(cron = "0 5/1 * * * ? ")
    public void test(){
        System.out.println("定时任务执行，当前时间："+ DateFormatUtils.format(new Date(),"yyyy-MM-dd hh:mm:ss"));
    }
}
