package com.jeyson.springboot;

import com.jeyson.springboot.dao.User;
import com.jeyson.springboot.mapper.UserMapper;
import com.jeyson.springboot.redis.RedisService;
import com.jeyson.springboot.testBean.Task;
import org.apache.kafka.common.protocol.types.Field;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {
	@Autowired
	UserMapper userMapper;
	@Autowired
	RedisService redisService;

	@Autowired
	Task task;
	/**
	 * 测试数据库连接
	 */
	@Test
	public void contextLoads() {
		User user=new User();
		user.setAccount("tt1");
		user.setUsername("11");
		user.setPassword("123");
//		int it=userMapper.insertUser(user);
//		System.out.println(it);
//		User temp=userMapper.getById(user.getId());
//		System.out.println("ss:"+temp);

	}

	/**
	 * 测试异步调用
	 */
	@Test
	public void testTask() throws InterruptedException {
		long start = System.currentTimeMillis();
		task.taskOne();
		task.taskTwo();
		task.taskThree();
		long end = System.currentTimeMillis();
		System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
	}
	/**
	 * 测试异步调用
	 */
	@Test
	public void testTask2() throws InterruptedException {
		long start = System.currentTimeMillis();
		Future<String> task1=	task.taskOne();
		Future<String> task2=	task.taskTwo();
		Future<String> task3=	task.taskThree();
	    Future<String> task4=	task.taskFour();
		Future<String> task5=	task.taskFive();
		while(true) {
			if(task4.isDone() && task5.isDone()&&task3.isDone()&&task2.isDone()&&task1.isDone() ) {
				// 任务都调用完成，退出循环等待
				break;
			}
			Thread.sleep(1000);
		}
		long end = System.currentTimeMillis();
		System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");

	}

	@Test
	public void  testRedis(){
		String key="wavley:user:code:123@163.com";
		redisService.setCache(key,"12341",60);
		System.out.println("验证码："+redisService.getCache(key));
	}
}
