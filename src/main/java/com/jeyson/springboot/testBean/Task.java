package com.jeyson.springboot.testBean;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Future;

/**
 * @Author: liujishuai
 * @Time: 2018/3/1 14:32
 * @Description:
 */
@Component
public class Task {

    Random random=new Random();
    @Async
    public Future<String> taskOne() throws InterruptedException {
        Long start=System.currentTimeMillis();
        System.out.println("taskOne start at:"+ DateFormatUtils.format(new Date(),"yyyy-MM-dd hh:mm:ss:SSS"));
        Thread.sleep(random.nextInt(5000));
        System.out.println("taskOne end at:"+ DateFormatUtils.format(new Date(),"yyyy-MM-dd hh:mm:ss:SSS"));
        System.out.println("taskOne 结束，耗时:"+(System.currentTimeMillis()-start) );
        return new AsyncResult<>("task 1 over");
    }
    @Async
    public Future<String> taskTwo() throws InterruptedException {
        Long start=System.currentTimeMillis();
        System.out.println("taskTwo start at:"+ DateFormatUtils.format(new Date(),"yyyy-MM-dd hh:mm:ss:SSS"));
        Thread.sleep(random.nextInt(5000));
        System.out.println("taskTwo end at:"+ DateFormatUtils.format(new Date(),"yyyy-MM-dd hh:mm:ss:SSS"));
        System.out.println("taskTwo 结束，耗时:"+(System.currentTimeMillis()-start) );
        return new AsyncResult<>("task 2 over");
    }
    @Async
    public Future<String> taskThree() throws InterruptedException {
        Long start=System.currentTimeMillis();
        System.out.println("taskThree start at:"+ DateFormatUtils.format(new Date(),"yyyy-MM-dd hh:mm:ss:SSS"));
        Thread.sleep(random.nextInt(5000));
        System.out.println("taskThree end at:"+ DateFormatUtils.format(new Date(),"yyyy-MM-dd hh:mm:ss:SSS"));
        System.out.println("taskThree 结束，耗时:"+(System.currentTimeMillis()-start) );
        return new AsyncResult<>("task 3 over");
    }

    @Async
    public Future<String> taskFour() throws InterruptedException {
        Long start=System.currentTimeMillis();
        System.out.println("taskFour start at:"+ DateFormatUtils.format(new Date(),"yyyy-MM-dd hh:mm:ss:SSS"));
        Thread.sleep(random.nextInt(5000));
        System.out.println("taskFour end at:"+ DateFormatUtils.format(new Date(),"yyyy-MM-dd hh:mm:ss:SSS"));
        System.out.println("taskFour 结束，耗时:"+(System.currentTimeMillis()-start) );
        return new AsyncResult<>("task 4 over");
    }

    @Async
    public Future<String> taskFive() throws InterruptedException {
        Long start=System.currentTimeMillis();
        System.out.println("taskFive start at:"+ DateFormatUtils.format(new Date(),"yyyy-MM-dd hh:mm:ss:SSS"));
        Thread.sleep(random.nextInt(5000));
        System.out.println("taskFive end at:"+ DateFormatUtils.format(new Date(),"yyyy-MM-dd hh:mm:ss:SSS"));
        System.out.println("taskFive 结束，耗时:"+(System.currentTimeMillis()-start) );
        return new AsyncResult<>("task 5 over");
    }
}
